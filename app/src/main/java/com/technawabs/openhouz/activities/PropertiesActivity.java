package com.technawabs.openhouz.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.*;
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
    private Handler mHandler = new Handler();

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
        messageAdapter = new MessageAdapter(PropertiesActivity.this,messageList);
        messageList.add(Utility.botSentMessage(getResources().obtainTypedArray(R.array.questions).getText(0).toString()));
        recList.setAdapter(messageAdapter);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendMessage(messageAdapter);
            }
        },5300);
        //set hint
//        userTypedMessage = (EditText) findViewById(R.id.send_message_text);
//        setHintText();
        //send message
//        sendUserMessage = (ImageView) findViewById(R.id.send_message);
//        sendUserMessage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (TextUtils.isEmpty(userTypedMessage.getText())) {
//                    Toast.makeText(getApplicationContext(), "Please write something", Toast.LENGTH_SHORT).show();
//                } else {
//                    messageList.add(Utility.userSentMessage(userTypedMessage.getText().toString()));
//                    messageAdapter.notifyDataSetChanged();
//                    userTypedMessage.setText("");
//                    setHintText();
//                }
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                startActivity(new Intent(PropertiesActivity.this, PropertyDetail.class));
                finish();
                return true;
            case R.id.action_viewings:
                startActivity(new Intent(PropertiesActivity.this,PropertiesActivity.class));
                finish();
                return true;
            case R.id.action_feedback:
                startActivity(new Intent(PropertiesActivity.this,FeedbackActivity.class));
                finish();
                return true;
            case R.id.action_about:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
//                if (!messageList.get(2).getMessage().equalsIgnoreCase("Hi Alan")) {
////                    messageList.add()
//                }
                break;
        }
    }

    private void sendMessage(MessageAdapter messageAdapter){
        switch (messageAdapter.getItemCount()){
            case 1:
//                messageList.add(Utility.botSentMessage(getResources().obtainTypedArray(R.array.questions).getText(1).toString()));
                Message message=new Message();
                message.setSender(OpenHouzConstants.ApartmentProperties.TYPE);
                message.setMessage(getResources().obtainTypedArray(R.array.questions).getText(1).toString());
                messageList.add(message);
                messageAdapter.notifyDataSetChanged();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

}
