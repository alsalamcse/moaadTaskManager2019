package com.moaadfinally2019.moaadtaskmanager2019.taskfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moaadfinally2019.moaadtaskmanager2019.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskHistoryFragment extends Fragment {


    public TaskHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_history, container, false);
    }

}
