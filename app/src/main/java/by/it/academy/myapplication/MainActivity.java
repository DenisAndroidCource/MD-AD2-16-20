package by.it.academy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import by.it.academy.myapplication.activity.ActivityExample;

// 1) создать Intent(контекст, класс активити)
// 2) добавить экстра если надо
// 3) startActivity, startActivityForResult

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = getString(R.string.app_name);
        getSystemService(LOCATION_SERVICE);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityExample.class);
                intent.putExtra("KEY", 150);
//                startActivity(intent);
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1000 && resultCode == Activity.RESULT_OK && data != null) {
            int result = data.getIntExtra("RESULT", 0);
            Log.d("RESULT", "Result: " + result);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
