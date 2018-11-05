



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
    private EditText etDueDate;
    private Button btnDatePicker;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle=findViewById(R.id.etTitle);
        etDueDate=findViewById(R.id.etDueDate);
        etText=findViewById(R.id.etText);
        skbrImportant=findViewById(R.id.skbrImpotant);
        skbrNecessary=findViewById(R.id.skbrNeccesary);
        btnSave=findViewById(R.id.btnSave);
        btnDatePicker=findViewById(R.id.btnDatePicker);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
    private void dataHandler()
    {
        boolean isok=true;//if all the fields filled well
        String text=etText.getText().toString();
        String tittle=etTitle.getText().toString();
        String Date=etDueDate.getText().toString();
        int SeekbBar1 = skbrImportant.getProgress();
        int SeekBar2 = skbrNecessary.getProgress();
        if (text.length()<4 ||
                text.indexOf('@')<0||
                text.indexOf('.')<0)
        {
            etText.setError("HAVE TO BE AT LEAST 4 letter");
            isok=false;
        }
        if (tittle.length()<8)
        {
            etTitle.setError("HAVE TO BE AT LEAST 4 letter");
            isok=false;
        }
    }

}