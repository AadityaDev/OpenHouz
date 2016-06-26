package com.technawabs.openhouz.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Path;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.*;
import com.technawabs.openhouz.utils.Utility;
import com.technawabs.openhouz.views.adapters.GenericArrayAdapter;
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
    private ScrollView scrollView;
    private RelativeLayout action;
    private TextView suggestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        //set list
        suggestText = (TextView) findViewById(R.id.suggest_text);
        action = (RelativeLayout) findViewById(R.id.action_button);
        action.setVisibility(View.INVISIBLE);
        recList = (RecyclerView) findViewById(R.id.job_card_list);
        recList.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(linearLayoutManager);
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        messageList.add(Utility.sendMessage(getResources().obtainTypedArray(R.array.questions).getText(0).toString(), OpenHouzConstants.Sender.BOT));
        recList.setAdapter(messageAdapter);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendMessage(messageAdapter);
                action.setVisibility(View.VISIBLE);
            }
        }, 5300);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelectedApartmentOptions(OpenHouzConstants.ApartmentProperties.TYPE);
            }
        });
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
        getMenuInflater().inflate(R.menu.main, menu);
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
                startActivity(new Intent(PropertiesActivity.this, PropertiesActivity.class));
                finish();
                return true;
            case R.id.action_feedback:
                startActivity(new Intent(PropertiesActivity.this, FeedbackActivity.class));
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
                break;
            case 2:
                suggestText.setText("Select apartment type");
                break;
            case 3:
                break;
        }
    }

    private void sendMessage(MessageAdapter messageAdapter) {
        switch (messageAdapter.getItemCount()) {
            case 1:
                messageList.add(Utility.sendMessage(getResources().obtainTypedArray(R.array.questions).getText(1).toString(), OpenHouzConstants.ApartmentProperties.TYPE));
                scrollView.fullScroll(View.FOCUS_DOWN);
                setHintText();
                break;
            case 2:
                messageList.add(Utility.sendMessage(getResources().obtainTypedArray(R.array.questions).getText(2).toString(), OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS));
                scrollView.fullScroll(View.FOCUS_DOWN);
                break;
            case 3:
                messageList.add(Utility.sendMessage(getResources().obtainTypedArray(R.array.questions).getText(3).toString(), OpenHouzConstants.ApartmentProperties.BUDGET));
                scrollView.fullScroll(View.FOCUS_DOWN);
                break;
        }
    }

    public void getSelectedApartmentOptions(String property) {
        switch (property) {
            case OpenHouzConstants.ApartmentProperties.TYPE:
                getSelectedValue(OpenHouzConstants.APARTMENT_TYPE);
                break;
            case OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS:
                break;
            case OpenHouzConstants.ApartmentProperties.BUDGET:
                break;
        }
    }

    public void getSelectedValue(int property) {
        int count = 0;
        final int size = messageAdapter.getListView(property).getChildCount();
        for (int i = 0; i < size; i++) {
            RelativeLayout relativeLayout = (RelativeLayout) messageAdapter.getListView(property).getChildAt(i);
            ToggleButton toggleButton = (ToggleButton) relativeLayout.getChildAt(0);
            if (toggleButton.isChecked()) {
                count++;
            }
        }
        Log.d(TAG, "Type Checked: " + count);
        Log.d(TAG, "ItemList" + messageAdapter.getArrayList(property).size());
        if (count > 0) {
            sendMessage(messageAdapter);
        }
    }

}
