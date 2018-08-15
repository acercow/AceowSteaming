package com.example.acercow.aceomstreaming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acercow.aceomstreaming.clean.DemoTask;
import com.example.acercow.aceomstreaming.clean.SimpleUseCaseScheduler;
import com.example.acercow.aceomstreaming.clean.UseCase;
import com.example.acercow.aceomstreaming.clean.UseCaseHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UseCaseHandler.getInstance(new SimpleUseCaseScheduler()).execute(new DemoTask(this), new DemoTask.RequestValue(), new UseCase.UseCaseCallback<DemoTask.ResponseValue>() {
            @Override
            public void onSuccess(DemoTask.ResponseValue responseValue) {
                Toast.makeText(MainActivity.this, responseValue.mMsg, Toast.LENGTH_SHORT).show();
                TextView tv = findViewById(R.id.text);
                ImageView iv = findViewById(R.id.image);
                tv.setText("asldfjlasjfdlkasdjfdkls");
                iv.setImageResource(R.drawable.ic_launcher_background);
            }

            @Override
            public void onError(DemoTask.ResponseValue responseValue) {

            }
        });
    }
}
