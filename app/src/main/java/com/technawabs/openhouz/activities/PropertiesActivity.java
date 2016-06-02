package com.technawabs.openhouz.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.Message;
import com.technawabs.openhouz.utils.Utility;
import com.technawabs.openhouz.views.adapters.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class PropertiesActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private RecyclerView recList;
    private LinearLayoutManager linearLayoutManager;
    private List<Message> messageList;
    private ProgressDialog progressDialog;
    private MessageAdapter messageAdapter;
    private EditText userTypedMessage;
    private ImageView sendUserMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        //set list
        recList = (RecyclerView) findViewById(R.id.job_card_list);
        recList.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(linearLayoutManager);
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        messageList.add(Utility.botSentMessage(getResources().obtainTypedArray(R.array.questions).getText(0).toString()));
        recList.setAdapter(messageAdapter);
        //set hint
        userTypedMessage = (EditText) findViewById(R.id.send_message_text);
        setHintText();
        //send message
        sendUserMessage = (ImageView) findViewById(R.id.send_message);
        sendUserMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(userTypedMessage.getText())) {
                    Toast.makeText(getApplicationContext(), "Please write something", Toast.LENGTH_SHORT).show();
                } else {
                    messageList.add(Utility.userSentMessage(userTypedMessage.getText().toString()));
                    messageAdapter.notifyDataSetChanged();
                    userTypedMessage.setText("");
                    setHintText();
                }
            }
        });
    }

    private void setHintText() {
        switch (messageList.size()) {
            case 1:
                userTypedMessage.setHint(getResources().obtainTypedArray(R.array.wait_hints).getText(1).toString());
                break;
            case 2:
                if (!TextUtils.isEmpty(userTypedMessage.getText())) {
                    if (userTypedMessage.getText().toString().equalsIgnoreCase("Hi Alan")) {
                        messageList.add(Utility.botSentMessage(getResources().obtainTypedArray(R.array.questions).getText(1).toString()));
                    }
                }
                break;
            case 3:
                if (!messageList.get(2).getMessage().equalsIgnoreCase("Hi Alan")){
//                    messageList.add()
                }
                break;
        }
    }


}
