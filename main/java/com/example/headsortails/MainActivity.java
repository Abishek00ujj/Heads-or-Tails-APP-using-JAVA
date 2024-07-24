package com.example.headsortails;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView ans;
    TextView git;
    ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button headButton = findViewById(R.id.headbtn);
        Button tailButton = findViewById(R.id.tailbtn);
        img = findViewById(R.id.img);
        ans = findViewById(R.id.answer);
        git = findViewById(R.id.github);
        headButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = randomNumber(0, 1);
                if (result == 0) {
                    img.setImageResource(R.drawable.head);
                    ans.setText("It's Heads! Jaichutoooo");
                    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.winsound);
                    mediaPlayer.start();
                } else {
                    img.setImageResource(R.drawable.tail);
                    ans.setText("It's Tails! Ipd thothutiye da");
                    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lostsound);
                    mediaPlayer.start();
                }
            }
        });

        tailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = randomNumber(0, 1);
                if (result == 1) {
                    img.setImageResource(R.drawable.tail);
                    ans.setText("It's Tails! Jaichutoooo");
                    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.winsound);
                    mediaPlayer.start();
                } else {
                    img.setImageResource(R.drawable.head);
                    ans.setText("It's Heads! Ipd thothutiye da");
                    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lostsound);
                    mediaPlayer.start();
                }
            }
        });
        git = findViewById(R.id.github);
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="https://github.com/Abishek00ujj";
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
        mainLayout = findViewById(R.id.main);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });
    }
    public int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}