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

public class GameActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_game);
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

        imageView1.setImageResource(R.drawable.rikishi_0);
        imageView2.setImageResource(R.drawable.rikishi_0);

        imageView1.setRotation(-90);
        imageView2.setRotation(90);

        imageView1.setTranslationX(-300);
        imageView2.setTranslationX(300);

        progressBar1.setProgress(progressStatus);

        imageView1.setOnClickListener(v ->{
            if (!gameStarted){
                return;
            }
            progressStatus = progressStatus - 10;
            progressBar1.setProgress(progressStatus);
            player1Score++;
            tvScore1.setText("" + player1Score);
            imageView1.setScaleX(1.25f);
            imageView1.setScaleY(1.25f);
            new Handler().postDelayed(() -> {
                imageView1.setScaleX(1.0f);
                imageView1.setScaleY(1.0f);
            },50);
        });
        imageView2.setOnClickListener(v ->{
            if (!gameStarted){
                return;
            }
            progressStatus = progressStatus + 10;
            progressBar1.setProgress(progressStatus);
            player2Score++;
            tvScore2.setText("" + player2Score);
            imageView2.setScaleX(1.25f);
            imageView2.setScaleY(1.25f);
            new Handler().postDelayed(() -> {
                imageView2.setScaleX(1.0f);
                imageView2.setScaleY(1.0f);
            },50);
        });

        btnStart.setOnClickListener(v -> {
            imageView1.animate().translationX(550).setDuration(3000);
            imageView2.animate().translationX(-550).setDuration(3000);
            tvInfo.setVisibility(TextView.VISIBLE);
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
                tvInfo.setVisibility(TextView.INVISIBLE);
            },3000);
        });
    }
}
