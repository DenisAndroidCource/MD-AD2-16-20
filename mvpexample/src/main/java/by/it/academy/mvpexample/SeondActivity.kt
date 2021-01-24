package by.it.academy.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SeondActivity : AppCompatActivity(), MainActivityView {

    private lateinit var textView: TextView
    private lateinit var button: Button

    private val presenter: MainActivityPresenter =
        MainActivityPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener { presenter.fetchData() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.close()
    }

    override fun showData(data: String) {
        textView.text = data
    }
}