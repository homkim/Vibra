package com.example.vibra;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
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

    public void onButton1Clicked(View v){
        Toast.makeText(this, "1초 진동을 울립니다.",Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.cancel();
        vibrator.vibrate(1000); // 1초간 진동
    }


    public void onButton2Clicked(View v){
        Toast.makeText(this, "패턴진동을 울립니다.",Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.cancel();
        long[] pattern = {100,300,100,700,300,2000}; // miliSecond
        //           대기,진동,대기,진동,....
        // 짝수 인덱스 : 대기시간
        // 홀수 인덱스 : 진동시간
        vibrator.vibrate(pattern, // 진동 패턴을 배열로
                -1);     // 반복 인덱스
        // 0 : 무한반복, -1: 반복없음,
        // 양의정수 : 진동패턴배열의 해당 인덱스부터 진동 무한반복
    }

    public void onButton3Clicked(View v){
        Toast.makeText(this, "무한진동을 울립니다.",Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.cancel();
        vibrator.vibrate( new long[]{100,1000,100,500,100,500,100,1000} , 0);
    }

    public void onCancelClicked(View v){
        Toast.makeText(this, "진동을 취소합니다.",Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.cancel();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onExitClicked(View v){
        Toast.makeText(this, "프로그램을 종료합니다.",Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.cancel();

        moveTaskToBack(true);						// 태스크를 백그라운드로 이동
        finishAndRemoveTask();						// 액티비티 종료 + 태스크 리스트에서 지우기
        android.os.Process.killProcess(android.os.Process.myPid());	// 앱 프로세스 종료
    }
}