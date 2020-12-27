package by.it.academy.viewexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import by.it.academy.viewexample.adapter.User;

public class MainActivity extends AppCompatActivity {

    private static final int SIDE_SIZE = 100;

    private Button button;

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            List<Integer> list = new ArrayList<>();
            while (Thread.interrupted()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(213);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        thread.start();





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        User user = new User.Builder()
                .setName("Name")
                .setAddress("Address")
                .build();

        int a = 0;
        User.Builder builder = new User.Builder();
        if (a == 10) {
            builder.setAddress("asd")
                    .setEmail("email");
        }

        user = builder.build();

        CustomView customView = findViewById(R.id.customView);
        customView.updateViewRectangle(SIDE_SIZE);
        customView.setOnCustomViewActionListener(new CustomView.OnCustomViewActionListener() {
            @Override
            public void onActionDown(float x, float y) {
                createDialog();
            }
        });

//        button.findViewById(R.id.viewButtonAction);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                foo();
//            }
//        });
//
//        CheckBox checkBox = findViewById(R.id.viewCheckBoxAction);
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
//
//        RadioGroup radioGroup = findViewById(R.id.radioGroup);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.viewRadioButton1: break;
//                    case R.id.viewRadioButton2: break;
//                    case R.id.viewRadioButton3: break;
//                    default: break;
//                }
//            }
//        });
    }

    private void createDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ic_launcher_background);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("MSG", "setPositiveButton");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("MSG", "setNegativeButton");
                    }
                })
                .setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:foo(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void foo() {
        Log.d("MSG", "Button has been clicked");
    }
}