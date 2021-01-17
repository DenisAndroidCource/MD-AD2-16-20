package by.it.academy.fragmentexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class Fragment1: Fragment(R.layout.fragment_1) {

    private lateinit var viewModel: SharedDataViewModel

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedDataViewModel::class.java)
        viewModel.valueLiveData.observe(viewLifecycleOwner, Observer {
                data -> Snackbar.make(view, "Fragment 1 $data", Snackbar.LENGTH_SHORT).show()
        })

        editText = view.findViewById(R.id.editText)
        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            val data = editText.text.toString()
            viewModel.postDataToAnotherScreen(data)
        }

//        getArguments()
        editText.setText(arguments?.getString("KEY") ?: "")


    }
}