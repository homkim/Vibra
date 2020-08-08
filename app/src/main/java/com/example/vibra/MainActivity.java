package com.example.vibra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {100,300,100,700,300,2000}; // miliSecond
        //           대기,진동,대기,진동,....
        // 짝수 인덱스 : 대기시간
        // 홀수 인덱스 : 진동시간
        vibrator.vibrate(pattern, // 진동 패턴을 배열로
                -1);     // 반복 인덱스
        // 0 : 무한반복, -1: 반복없음,
        // 양의정수 : 진동패턴배열의 해당 인덱스부터 진동 무한반복

    }

    public void onVibButtonClicked(View v){
        Toast.makeText(this, "1초 진동을 울립니다.",Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000); // 1초간 진동
    }


}