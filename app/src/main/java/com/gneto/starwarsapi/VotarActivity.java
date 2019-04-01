package com.gneto.starwarsapi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;

public class VotarActivity extends AppCompatActivity {
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Get the widgets reference from XML layout
//        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
//        final Button btnVotar = (Button) findViewById(R.id.btnVote);
//        final Button btnRevogar = (Button) findViewById(R.id.btnRevoke);
//        final TextView tv = (TextView) findViewById(R.id.tv);
//        final ProgressBar pb = (ProgressBar) findViewById(R.id.pbQtdVotos);
//
//        btnVotar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressStatus = 0;
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        progressStatus += 1;
//
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                pb.setProgress(progressStatus);
//                                tv.setText(progressStatus + "");
//                            }
//                        });
//                    }
//                })
//                        .start();
//            }
//        });
//
//        btnRevogar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressStatus = 1;
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        progressStatus =-1;
//                    }
//                })
//            }
//        });
    }
}