package by.it.academy.asyncexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    static synchronized  void staticFoo(){
        // class
    }

    static synchronized  void staticFoo2(){
        // class
    }

    private Boolean flag = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        synchronized (flag) {
            // Thread 1
        }
    }

    private synchronized void foo(){
        // this
    }
}
