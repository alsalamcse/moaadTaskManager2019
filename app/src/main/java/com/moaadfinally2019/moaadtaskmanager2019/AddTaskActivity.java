



package com.moaadfinally2019.moaadtaskmanager2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle;
    private EditText etText;
    private SeekBar skbrImportant;
    private SeekBar skbrNecessary;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle=findViewById(R.id.etTitle);
        etText=findViewById(R.id.etText);
        skbrImportant=findViewById(R.id.skbrImpotant);
        skbrNecessary=findViewById(R.id.skbrNeccesary);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
