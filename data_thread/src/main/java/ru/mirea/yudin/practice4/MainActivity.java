package ru.mirea.yudin.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        final Runnable runn1 = () -> tvInfo.setText("runn1");
        final Runnable runn2 = () -> tvInfo.setText("runn2");
        final Runnable runn3 = () -> tvInfo.setText("runn3");
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                runOnUiThread(runn1);
                TimeUnit.SECONDS.sleep(1);
                tvInfo.postDelayed(runn3, 2000);
                tvInfo.post(runn2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}