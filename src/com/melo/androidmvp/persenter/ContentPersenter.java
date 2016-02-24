package com.melo.androidmvp.persenter;

import android.content.Context;

import com.melo.androidmvp.Interface.ContentViewInterface;
import com.melo.androidmvp.model.NetworkData;
import com.melo.androidmvp.model.NetworkData.DataListener;
/**
 * persenter MVP 的中间核心类
 * @author melo
 *
 */
public class ContentPersenter {
	
	private ContentViewInterface contentViewInterface;
	private NetworkData networkData;
	
	public ContentPersenter(ContentViewInterface contentViewInterface,Context context) {
		this.contentViewInterface = contentViewInterface;
		networkData = new NetworkData(context);
	}
	
	public void setContent(){
		contentViewInterface.showLoading();
		networkData.getDataFromNetwork(new DataListener() {
			
			@Override
			public void onSuccess(String data) {
				contentViewInterface.showContent(data);
				contentViewInterface.hideLoading();
				
			}
		});
		
		
		
	}

}
