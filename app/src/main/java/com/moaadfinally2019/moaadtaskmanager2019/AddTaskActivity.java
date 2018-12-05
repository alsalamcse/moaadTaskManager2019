



package com.moaadfinally2019.moaadtaskmanager2019;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moaadfinally2019.moaadtaskmanager2019.data.MyTask;

import java.util.Date;

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
        String title=etTitle.getText().toString();
        String date=etDueDate.getText().toString();
        int SeekbBar1 = skbrImportant.getProgress();
        int SeekBar2 = skbrNecessary.getProgress();
        if (title.length() == 0)
        {
            etTitle.setError("Tittle can not be empty");
        }

        if (text.length()==0)
        {
            etText.setError("Text can not be empty");
            isok=false;

        }
        if (isok)
        {
            MyTask task=new MyTask();
            task.setCreatedAt(new Date());
            task.setDueDate(new Date(date));
            task.setText(text);
            task.setTitle(title);
            task.setImportant(skbrImportant.getProgress());
            task.setNecessary(skbrNecessary.getProgress());

            FirebaseAuth auth=FirebaseAuth.getInstance();
            task.setOwner(auth.getCurrentUser().getEmail());


            DatabaseReference reference= FirebaseDatabase.getInstance().getReference();


            String key=reference.child("MyTasks").push().getKey();
            task.setKey(key);

            reference.child("MyTasks").child(key).setValue(task).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(AddTaskActivity.this,"Add Successful",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(AddTaskActivity.this,"Add Failed",Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

}