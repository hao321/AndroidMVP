package com.melo.androidmvp.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * 从网络获取数据
 * @author melo
 *
 */
public class NetworkData {
	private RequestQueue mRequestQueue;
	public NetworkData(Context context){
		mRequestQueue = Volley.newRequestQueue(context);
	}
	
	public void getDataFromNetwork(final DataListener dataListener) {
		StringRequest stringRequest = new StringRequest("http://baidu.com",
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						dataListener.onSuccess(response);

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

					}
				});
		mRequestQueue.add(stringRequest);
		mRequestQueue.start();

	}
	
	public interface DataListener{
		public void onSuccess(String data);
	}

}

