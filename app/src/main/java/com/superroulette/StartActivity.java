package com.superroulette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import static android.net.Uri.*;


public class StartActivity extends AppCompatActivity {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean start = false;
    private static boolean Amoji = true;
    private static boolean Bmoji = true;
    private static boolean Cmoji = true;
    private static boolean Dmoji = true;

    private AdView mAdView;

    private InputMethodManager inputMethodManager;
    private LinearLayout mainLayout;

    String contentA,contentB,contentC,contentD;
    String string_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //MobileAds.initialize(this, "ca-app-pub-1148946478421218~2444630829");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //以下contentの処理
        CompoundButton toggleA = (CompoundButton) findViewById(R.id.switchA);
        toggleA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Amoji = true;
                    findViewById(R.id.textViewA).setVisibility(View.VISIBLE);
                    findViewById(R.id.editTextA).setVisibility(View.VISIBLE);
                } else {
                    Amoji = false;
                    findViewById(R.id.textViewA).setVisibility(View.INVISIBLE);
                    findViewById(R.id.editTextA).setVisibility(View.INVISIBLE);
                }
            }
        });
        CompoundButton toggleB = (CompoundButton) findViewById(R.id.switchB);
        toggleB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Bmoji = true;
                    findViewById(R.id.textViewB).setVisibility(View.VISIBLE);
                    findViewById(R.id.editTextB).setVisibility(View.VISIBLE);
                } else {
                    Bmoji = false;
                    findViewById(R.id.textViewB).setVisibility(View.INVISIBLE);
                    findViewById(R.id.editTextB).setVisibility(View.INVISIBLE);
                }
            }
        });
        CompoundButton toggleC = (CompoundButton) findViewById(R.id.switchC);
        toggleC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Cmoji = true;
                    findViewById(R.id.textViewC).setVisibility(View.VISIBLE);
                    findViewById(R.id.editTextC).setVisibility(View.VISIBLE);
                } else {
                    Cmoji = false;
                    findViewById(R.id.textViewC).setVisibility(View.INVISIBLE);
                    findViewById(R.id.editTextC).setVisibility(View.INVISIBLE);
                }
            }
        });
        CompoundButton toggleD = (CompoundButton) findViewById(R.id.switchD);
        toggleD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Dmoji = true;
                    findViewById(R.id.textViewD).setVisibility(View.VISIBLE);
                    findViewById(R.id.editTextD).setVisibility(View.VISIBLE);
                } else {
                    Dmoji = false;
                    findViewById(R.id.textViewD).setVisibility(View.INVISIBLE);
                    findViewById(R.id.editTextD).setVisibility(View.INVISIBLE);
                }
            }
        });

        //使い方への遷移
        Button button1 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.setClassName(getPackageName(), getPackageName() + ".ExplanationActivity");
                startActivity(intent3);
            }
        });

        //スタートを押したときの処理
        final Button buttonstart = (Button) findViewById(R.id.button4);

        final Button sharebutton = (Button) findViewById(R.id.sharebutton);

        final AnimationDrawable animA = new AnimationDrawable();
        final AnimationDrawable animB = new AnimationDrawable();
        final AnimationDrawable animC = new AnimationDrawable();
        final AnimationDrawable animD = new AnimationDrawable();

        final ImageView img = (ImageView) findViewById(R.id.imageView);

        final Drawable frame1 = getResources().getDrawable(R.drawable.a1);
        final Drawable frame2 = getResources().getDrawable(R.drawable.b1);
        final Drawable frame3 = getResources().getDrawable(R.drawable.c1);
        final Drawable frame4 = getResources().getDrawable(R.drawable.d1);
        final TextView result = findViewById(R.id.textView5);
        animA.addFrame(frame1, 60);
        animB.addFrame(frame2, 60);
        animC.addFrame(frame3, 60);
        animD.addFrame(frame4, 60);


        animA.setOneShot(true);
        animB.setOneShot(true);
        animC.setOneShot(true);
        animD.setOneShot(true);


        //確定文字消す
        findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
        sharebutton.setVisibility(View.INVISIBLE);

        buttonstart.setOnClickListener(new View.OnClickListener() {
            AnimationDrawable anim = new AnimationDrawable();

            @SuppressLint("SetTextI18n")
            @Override

            public void onClick(View v) {

                anim.setOneShot(false);
                img.setBackgroundDrawable(anim);

                //String contentA,contentB,contentC,contentD;
                EditText AA = findViewById(R.id.editTextA);
                EditText BB = findViewById(R.id.editTextB);
                EditText CC = findViewById(R.id.editTextC);
                EditText DD = findViewById(R.id.editTextD);
                contentA = AA.getText().toString();
                contentB = BB.getText().toString();
                contentC = CC.getText().toString();
                contentD = DD.getText().toString();

                if (Amoji) {
                    anim.addFrame(frame1, 60);
                }
                if (Bmoji) {
                    anim.addFrame(frame2, 60);
                }
                if (Cmoji) {
                    anim.addFrame(frame3, 60);
                }
                if (Dmoji) {
                    anim.addFrame(frame4, 60);
                }

                int frameNumber = 0;
                if (start) {
                    //終了時
                    buttonstart.setText("START");
                    start = false;
                    anim.stop();

                    //止まった場所のフレーム取得(通常時）

                    Drawable currentFrame;
                    currentFrame = anim.getCurrent();

                    if (currentFrame == frame1) {
                        frameNumber = 0;
                    }
                    if (currentFrame == frame2) {
                        frameNumber = 1;
                    }
                    if (currentFrame == frame3) {
                        frameNumber = 2;
                    }
                    if (currentFrame == frame4) {
                        frameNumber = 3;
                    }

                    //以下イカサマ設定

                    if (A) {
                        img.setBackgroundDrawable(animA);
                        animA.start();
                        animA.stop();
                        frameNumber = 0;
                    }
                    if (B) {
                        img.setBackgroundDrawable(animB);
                        animB.start();
                        animB.stop();
                        frameNumber = 1;
                    }
                    if (C) {
                        img.setBackgroundDrawable(animC);
                        animC.start();
                        animC.stop();
                        frameNumber = 2;
                    }
                    if (D) {
                        img.setBackgroundDrawable(animD);
                        animD.start();
                        animD.stop();
                        frameNumber = 3;
                    }
                    //Log.d("checkk", "" + frameNumber);
                    switch (frameNumber) {
                        case 0:
                            result.setText(contentA + "！");
                            string_result = contentA;
                            break;
                        case 1:
                            result.setText(contentB + "！");
                            string_result = contentB;
                            break;
                        case 2:
                            result.setText(contentC + "！");
                            string_result = contentC;
                            break;
                        case 3:
                            result.setText(contentD + "！");
                            string_result = contentD;
                            break;
                    }
                    result.setVisibility(View.VISIBLE);
                    sharebutton.setVisibility(View.VISIBLE);
                    //初期化
                    anim = new AnimationDrawable();
                    A = false;
                    B = false;
                    C = false;
                    D = false;
                } else {
                    //開始時
                    buttonstart.setText("STOP");
                    start = true;
                    anim.start();
                    result.setVisibility(View.INVISIBLE);
                    sharebutton.setVisibility(View.INVISIBLE);
                }

            }
        });

        //隠しボタンの処理
        TextView buttonA = (TextView) findViewById(R.id.textViewA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = true;
                B = false;
                C = false;
                D = false;
            }
        });
        TextView buttonB = (TextView) findViewById(R.id.textViewB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = false;
                B = true;
                C = false;
                D = false;
            }
        });
        TextView buttonC = (TextView) findViewById(R.id.textViewC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = false;
                B = false;
                C = true;
                D = false;
            }
        });
        TextView buttonD = (TextView) findViewById(R.id.textViewD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = false;
                B = false;
                C = false;
                D = true;
            }
        });

        //以下シェア実行
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = null;
                if (Amoji) {

                    choice = "" + contentA;
                }
                if (Bmoji) {
                    choice = choice + "、" + contentB;
                }
                if (Cmoji) {
                    choice = choice + "、" + contentC;
                }
                if (Dmoji) {
                    choice = choice + "、" + contentD;
                }
                String url = "http://twitter.com/share?url=https://play.google.com/store/apps/details?id=com.superroulette&text=" + choice + "の中から、厳正な（？）抽選の結果、、、\n＊　　　＊　　　＊\n＊　　　＊　　　＊\n＊　　　＊　　　＊\n" + string_result + "が選ばれました！&hashtags=いかさまルーレット";
                Intent intent = new Intent(Intent.ACTION_VIEW, parse(url));
                startActivity(intent);
            }
        });

        //キーボード消す1
        mainLayout = (LinearLayout) findViewById(R.id.linear);
        //キーボード表示を制御するためのオブジェクト
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

    }

   // キーボード消す１
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(mainLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        //背景にフォーカスを移す
        mainLayout.requestFocus();

        return false;
    }
}