package com.technawabs.openhouz.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.Message;

import java.util.List;

public class PropertiesActivity extends AppCompatActivity {

    private final String TAG = this.getLocalClassName();
    private RecyclerView recList;
    private LinearLayoutManager linearLayoutManager;
    private List<Message> messageList;
    private ProgressDialog progressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);

        recList = (RecyclerView) findViewById(R.id.job_card_list);
        recList.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(linearLayoutManager);
    }
}
