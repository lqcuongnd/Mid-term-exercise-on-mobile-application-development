package com.example.giuakynhom4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int INPUT = 1;
    public static final int CHOOSE = 2;
    public static final int RESULT = 3;
    public static final int RETURN_INPUT = 11;
    public static final int RETURN_CHOOSE = 22;
    public static final int RETURN_RESULT = 33;

    String input;
    int typeCode = -1;

    Button btnInput, btnChooseAlgorithm, btnGetResult;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInput = (Button) findViewById(R.id.btnInput);
        btnChooseAlgorithm = (Button) findViewById(R.id.btnChooseAlgorithm);
        btnGetResult = (Button) findViewById(R.id.btnGetResult);

        input = "";

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, InputActivity.class);

                bundle = new Bundle();
                bundle.putString("input", input);
                intent.putExtras(bundle);

                startActivityForResult(intent, INPUT);
            }
        });
        btnChooseAlgorithm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ChooseAlgorithmActivity.class);
                startActivityForResult(intent, CHOOSE);
            }
        });
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noti = "Please ";
                if (input.compareTo("") == 0) {
                    noti += "input a sequence of numbers, ";
                }
                if (typeCode == -1) {
                    noti += "choose an algorithm to sort";
                }
                if (noti.compareTo("Please ") != 0) {
                    Toast.makeText(MainActivity.this, noti, Toast.LENGTH_LONG).show();
                    return;
                }
                intent = new Intent(MainActivity.this, ResultActivity.class);

                Bundle b = new Bundle();
                b.putString("input", input);
                b.putInt("typeCode", typeCode);
                intent.putExtras(b);

                startActivityForResult(intent, RESULT);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INPUT) {
            if (resultCode == RETURN_INPUT) {
                bundle = data.getExtras();
                input = bundle.getString("input");
            }
        }
        if (requestCode == CHOOSE) {
            if (resultCode == RETURN_CHOOSE) {
                bundle = data.getExtras();
                typeCode = bundle.getInt("typeCode");
            }
        }
        if (requestCode == RESULT) {
            if (resultCode == RETURN_RESULT) {
                typeCode = -1;
            }
        }
    }
}


