package com.example.giuakynhom4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.giuakynhom4.SortAlgorithms.Sort;

public class ResultActivity extends AppCompatActivity {

    TextView lblKQ, lblTitle;
    ImageButton btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lblKQ = (TextView) findViewById(R.id.lbKQ);
        lblTitle = (TextView) findViewById(R.id.lblTitle);
        btnOK = (ImageButton) findViewById(R.id.btnOK);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String input = bundle.getString("input");
        int typeCode = bundle.getInt("typeCode");

        input.replace("- ", "");

        Sort sort = new Sort();
        String[] inputs = input.split(" ");
        int[] num = new int[inputs.length];
        int count = 0;
        for (String i : inputs) {
            try {
                num[count++] = Integer.parseInt(i);
            } catch (NumberFormatException e) {
                count--;
            }
        }

        sort.doSortting(typeCode, num);

        String s = "";

        for (int n : num) {
            s += n + ", ";
            if (s.length() % 17 == 0) {
                s += "\n";
            }
        }

        //Xóa dấu phẩy cuối cùng
        StringBuilder ss = new StringBuilder(s);
        ss.setCharAt(s.length() - 2, '\0');

        lblTitle.setText("Below is the sorted number sequence by " + sort.getTypeSorttingName(typeCode) + ":");
        lblKQ.setText(ss);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
