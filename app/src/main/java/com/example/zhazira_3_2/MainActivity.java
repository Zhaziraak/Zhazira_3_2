package com.example.zhazira_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhazira_3_2.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private Button btnSend;
    private EditText etMail;
    private EditText etTheme;
    private  EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnSend = findViewById(R.id.btn_send);
        etMail = findViewById(R.id.et_mail);
        etTheme = findViewById(R.id.et_theme);
        etMessage = findViewById(R.id.et_message);
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = Objects.requireNonNull(etMessage).getText().toString();
                String mail = Objects.requireNonNull(etMail).getText().toString();
                String theme = Objects.requireNonNull(etTheme).getText().toString();
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
                intent.putExtra(Intent.EXTRA_SUBJECT, theme);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}