package com.hoanglam0869.cuahangthietbionline.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.hoanglam0869.cuahangthietbionline.R;

public class LienHeActivity extends AppCompatActivity {

    Toolbar toolBarLienHe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);

        toolBarLienHe = findViewById(R.id.toolBarLienHe);
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toolBarLienHe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarLienHe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}