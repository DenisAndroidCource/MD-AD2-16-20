package by.it.academy.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class Fragment2 : Fragment() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    private lateinit var viewModel: SharedDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = LayoutInflater.from(context)
        .inflate(R.layout.fragment_2, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedDataViewModel::class.java)
        viewModel.valueLiveData.observe(viewLifecycleOwner, Observer { data ->
            Snackbar.make(view, "Fragment 2 $data", Snackbar.LENGTH_SHORT).show()
        })

        editText = view.findViewById(R.id.editText)
        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            Snackbar.make(view, "Button has been clicked on Fragment 2", Snackbar.LENGTH_SHORT)
                .show()
        }
//        button.isVisibleOrGone(savedInstanceState != null)

        val value = requireArguments().getString("KEY", "")
        editText.setText(value)

        childFragmentManager.commit {
            add(
                R.id.childFragmentContainer,
                Fragment1::class.java,
                bundleOf("KEY" to "Inner fragment data")
            )
        }
    }
}