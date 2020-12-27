package by.it.academy.asyncexample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class HandlerActivity extends AppCompatActivity {

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    private Handler handler;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Future futureVoid = executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        Future<Integer> futureResult = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call(){
                return 0;
            }
        });

        button = findViewById(R.id.startJob);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread(() -> {
//                    String randomString = UUID.randomUUID().toString();
//                    Message message = handler.obtainMessage(0, randomString);
//                    handler.sendMessage(message);
//                }).start();
                setButtonTextAsync();
            }
        });

        handler = new Handler(getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == 0) {
                    button.setText((String)msg.obj);
                }
                return false;
            }
        });


//        try {
//            if (futureResult.isDone()) {
//                button.setText(futureResult.get().toString());
//            }
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void setButtonTextAsync() {
        CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return 200;
                    }
                }, executorService)
                .thenApplyAsync(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return "The number is " + integer.toString();
                    }
                }, executorService)
                .thenAcceptAsync(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        button.setText(s);
                    }
                }, getMainExecutor());
    }
}
