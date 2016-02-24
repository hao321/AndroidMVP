package com.melo.androidmvp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.melo.androidmvp.Interface.ContentViewInterface;
import com.melo.androidmvp.persenter.ContentPersenter;


public class MainActivity extends Activity implements ContentViewInterface{
	
	private TextView contentTV;
	private Button mvpBtn;
	private ProgressDialog dialog ;
	private ContentPersenter persenter;
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				dialog.show();
				break;

			case 2:
				dialog.dismiss();
				break;
			}
		};
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        initView();
        setEvent();
        persenter = new ContentPersenter(this,getApplicationContext());
        
        
    }

	private void initView() {
		contentTV = (TextView) findViewById(R.id.content);
		mvpBtn = (Button) findViewById(R.id.btn_mvp);
	}
	
	private void setEvent(){
		mvpBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			     persenter.setContent();
			}
		});
	}

	@Override
	public void showLoading() {
		Message msg1 = new Message();
		msg1.what = 1;
		mHandler.sendMessage(msg1);
		
	}

	@Override
	public void hideLoading() {
		Message msg2 = new Message();
		msg2.what = 2;
		mHandler.sendMessage(msg2);
	}

	@Override
	public void showContent(String contentString) {
		contentTV.setText(contentString);
		//dialog.dismiss();
	}

   
}
