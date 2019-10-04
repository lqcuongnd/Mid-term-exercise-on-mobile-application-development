package com.example.giuakynhom4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class InputActivity extends AppCompatActivity {

    ImageView banner;
    ImageButton btnReset, btnSubmit, btnBack;
    EditText txtInput;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); //Ngăn tự động bung bàn phím ảo

        banner = (ImageView) findViewById(R.id.banner);
        btnReset = (ImageButton) findViewById(R.id.btnReset);
        btnSubmit = (ImageButton) findViewById(R.id.btnSubmit);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        txtInput = (EditText) findViewById(R.id.txtInput);

        txtInput.setSelected(false);

        //Lấy chuỗi đang nhập lưu từ bên main
        intent = getIntent();
        bundle = intent.getExtras();
        txtInput.setText(bundle.getString("input"));

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText("");
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = new Bundle();
                bundle.putString("input", txtInput.getText().toString());
                intent.putExtras(bundle);
                setResult(11, intent);
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
