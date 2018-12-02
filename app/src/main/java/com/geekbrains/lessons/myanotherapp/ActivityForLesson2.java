package com.geekbrains.lessons.myanotherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class ActivityForLesson2 extends AppCompatActivity {

    EditText editText;
    TextView tv;
    Observable<String> observable;
    Observable<String> observable2;
    Observer<String> observer;
    Observer<String> observer2;
    PublishSubject<String> subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_lesson2);
        initGUI();

        /*editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                tv.setText(editText.getText());
            }
        });*/
        subject=PublishSubject.create();
        observable2=Observable.just("1","2","3");
        observable = Observable.just("a","b","c");
        observer2=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

                Log.d("Dto", s);


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d("Dto", s);

            }

            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onSubscribe(Disposable d)
            {

            }


        };
        observable.subscribe(subject);
        observable2.subscribe(subject);
        subject.subscribe(observer);
        subject.subscribe(observer2);
        subject.onNext("Mystring");

    }




    private void initGUI()
    {
        editText=findViewById(R.id.EditText);
        tv=findViewById(R.id.textview);

    }

}
