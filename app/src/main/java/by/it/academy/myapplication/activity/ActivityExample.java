package by.it.academy.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import by.it.academy.myapplication.R;

//public class ActivityExample extends Activity
public class ActivityExample extends AppCompatActivity {

    private int value;

    private static final String LOG_KEY = "LOG_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Log.d(LOG_KEY, "onCreate");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = getIntentData();
//                int data = getIntentData();
//                int result = 5 * data;
//                Intent intent = new Intent();
//                intent.putExtra("RESULT", result);
//                setResult(Activity.RESULT_OK, intent);
//                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("VALUE", value);
        super.onSaveInstanceState(outState);
        Log.d(LOG_KEY, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_KEY, "onRestoreInstanceState" + savedInstanceState.getInt("VALUE"));
    }

    private int getIntentData() {
        Intent intent = getIntent();
        return intent != null ? intent.getIntExtra("KEY", 0) : 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_KEY, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_KEY, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_KEY, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_KEY, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_KEY, "onDestroy");
    }
}
