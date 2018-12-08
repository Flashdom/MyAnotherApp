package com.geekbrains.lessons.myanotherapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ActivityForLesson2 extends AppCompatActivity {

    EditText editText;
    TextView tv;
    ImageView iv;
    Bitmap bmp;
    File file;
    Observable<Drawable> observable;
    Observer<Drawable> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_lesson2);
        initGUI();
        file=new File("/Users/Robert/AndroidStudioProjects/MyAnotherApp/app/src/main/res/drawable-v24/pic.jpg");
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
        observable = Observable.just(getDrawable(R.drawable.pic));
        observer = new Observer<Drawable>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(final Drawable drawable) {
                new Thread(() -> {
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, out); //100-best quality
                        out.close();

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }).start();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);


    }


    private void initGUI() {
        editText = findViewById(R.id.EditText);
        tv = findViewById(R.id.textview);
        iv=findViewById(R.id.imageView);

    }


}
