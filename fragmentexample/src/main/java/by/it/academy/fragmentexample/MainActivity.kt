package by.it.academy.fragmentexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

fun View.isVisibleOrGone(flag: Boolean) {
    visibility = if (flag) View.VISIBLE else View.GONE
}

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SharedDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SharedDataViewModel::class.java)
        viewModel.valueLiveData.observe(this, Observer { data ->
            Snackbar.make(findViewById(R.id.rootLayout), "MainActivity $data", Snackbar.LENGTH_SHORT)
                .show()
        })

        showFragment1()
        showFragment2()
    }

    private fun showFragment1() {
        val bundle = bundleOf("KEY" to "VALUE FOR THE FRAGMENT 1")
        val fragment = Fragment1().apply {
//            setArguments(bundle)
            arguments = bundle
        }

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
            .add(R.id.fragmentContainer1, fragment, "FragmentTag1")
//            .replace()
//            .remove()
//            .show()
//            .hide()
            .commit()
    }

    private fun showFragment2() {
        val bundle = bundleOf("KEY" to "VALUE FOR THE FRAGMENT 2")
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragmentContainer2, Fragment2::class.java, bundle)
        }
//        supportFragmentManager.beginTransaction()
////            .add(R.id.fragmentContainer2, Fragment2.class) // Java
//            .add<Fragment2>(R.id.fragmentContainer2) // Kotlin
//            .commit()
    }
}