package ru.mirea.yudin.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float sred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCount(View v){
        new Thread(() -> {
            EditText days =(EditText) findViewById(R.id.editDays);
            float fDays = Float.parseFloat(days.getText().toString());
            EditText couples =(EditText) findViewById(R.id.editCouples);
            float fCouples = Float.parseFloat(couples.getText().toString());
            sred = fCouples / fDays;
            TextView result = findViewById(R.id.textResult);
            runOnUiThread(() -> result.setText(String.valueOf(sred)));
        }).start();
    }
}