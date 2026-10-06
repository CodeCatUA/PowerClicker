package com.codecat.powerclicker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnNewGame, btnSettings, btnAbout;

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

        btnNewGame = findViewById(R.id.btnNewGame);
        btnSettings= findViewById(R.id.btnSettings);
        btnAbout = findViewById(R.id.btnAbout);

        btnNewGame.setOnClickListener(v -> newGame());

    }

    private void newGame() {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }

}