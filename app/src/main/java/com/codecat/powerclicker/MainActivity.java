package com.codecat.powerclicker;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int player1Score = 0;
    private int player2Score = 0;
    private int progressStatus = 50;
    private TextView tvScore1, tvScore2, tvInfo;
    private ImageView imageView1, imageView2;
    private ProgressBar progressBar1;
    private Button btnStart;

    private boolean gameStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvScore1 = findViewById(R.id.tvScore1);
        tvScore2 = findViewById(R.id.tvScore2);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        progressBar1 = findViewById(R.id.progressBar);
        tvInfo = findViewById(R.id.tvInfo);
        btnStart = findViewById(R.id.btnStart);

        progressBar1.setProgress(progressStatus);

        imageView1.setOnClickListener(v ->{
            progressStatus = progressStatus - 10;
            progressBar1.setProgress(progressStatus);
            player1Score++;
            tvScore1.setText("" + player1Score);
        });
        imageView2.setOnClickListener(v ->{
            progressStatus = progressStatus + 10;
            progressBar1.setProgress(progressStatus);
            player2Score++;
            tvScore2.setText("" + player2Score);
        });

        btnStart.setOnClickListener(v -> {
            tvInfo.setText("3");
            new Handler().postDelayed(() -> {
                tvInfo.setText("2");
            },1000);
            new Handler().postDelayed(() -> {
                tvInfo.setText("1");
            },2000);
            new Handler().postDelayed(() -> {
                tvInfo.setText("Start!");
                gameStarted = true;
            },3000);
        });
    }
}