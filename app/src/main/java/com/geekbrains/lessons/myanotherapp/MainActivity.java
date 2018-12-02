package com.geekbrains.lessons.myanotherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener, View {


    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = (Button) findViewById(R.id.button);
        btnCounter2 = (Button) findViewById(R.id.button2);
        btnCounter3 = (Button) findViewById(R.id.button3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
        mPresenter = new Presenter(this);
    }


    @Override
    public void setSeconds(int value) {
        btnCounter1.setText("Количество = " + value);
    }

    @Override
    public void setMinute(int value) {
        btnCounter2.setText("Количество = " + value);
    }

    @Override
    public void setHours(int value) {
        btnCounter3.setText("Количество = " + value);
    }



    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()){
            case R.id.button: {
                mPresenter.incSec();
                break;
            }
            case R.id.button2: {
                mPresenter.incMin();
                break;
            }
            case R.id.button3:{
                mPresenter.incHours();
                break;
            }
        }
    }
}
