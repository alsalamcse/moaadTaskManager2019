package com.moaadfinally2019.moaadtaskmanager2019.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.moaadfinally2019.moaadtaskmanager2019.R;

public class TaskAdapter extends ArrayAdapter<MyTask>
{

    public TaskAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
       if (convertView==null)
           convertView=LayoutInflater.from(getContext()).inflate(R.layout.task_item,parent,false);
        MyTask m=getItem(position);
        TextView tvTitle=convertView.findViewById(R.id.tvitemTittle);
        TextView tvText=convertView.findViewById(R.id.tvitemText);
        SeekBar skpNess=convertView.findViewById(R.id.skbitemNess);
        SeekBar skpImp=convertView.findViewById(R.id.skbitemImp);
        ImageButton ibDel=convertView.findViewById(R.id.btnitemDel);
        tvText.setText(m.getText());
        tvTitle.setText(m.getTitle());
        skpImp.setProgress(m.getImportant());
        skpNess.setProgress(m.getNecessary());
        ibDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Del",Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
