package com.example.giuakynhom4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseAlgorithmActivity extends AppCompatActivity {

    ListView lstChoose;
    ArrayAdapter<String> algAdapter;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sort_type);


        String[] lst = getResources().getStringArray(R.array.sort_type);
        algAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lst);

        lstChoose = (ListView) findViewById(R.id.lstChoose);
        lstChoose.setAdapter(algAdapter);

        lstChoose.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ChooseAlgorithmActivity.this, "Selected " + new Sort().getTypeSorttingName(position), Toast.LENGTH_LONG).show();

                intent = getIntent();
                bundle = new Bundle();
                bundle.putInt("typeCode", position);
                intent.putExtras(bundle);
                setResult(22, intent);
                finish();
            }
        });
    }

}
