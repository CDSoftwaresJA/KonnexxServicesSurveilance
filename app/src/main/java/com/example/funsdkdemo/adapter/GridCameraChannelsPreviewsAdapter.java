package com.example.funsdkdemo.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.funsdkdemo.R;
import com.example.funsdkdemo.devices.monitor.ActivityGuideDevicePreview;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.widget.FunVideoView;

public class GridCameraChannelsPreviewsAdapter extends BaseAdapter{
	
	private LayoutInflater inflater;
	private int mchannels;
	private int height,width;
	
	public GridCameraChannelsPreviewsAdapter(Context context, int channels) {
		// TODO Auto-generated constructor stub
		inflater = LayoutInflater.from(context);
		mchannels = channels;
		DisplayMetrics displayMetrics = new DisplayMetrics();
		WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(displayMetrics);
		 height = displayMetrics.heightPixels/6;
		 width = displayMetrics.widthPixels/4;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		System.out.println("TTT---->>> count");
		return mchannels;
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		//return mList.get(position);
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout view = null;
		ChannelsItem channelsItem = new ChannelsItem();
		if ( null == convertView ) {
			if (inflater != null) {
				view = (LinearLayout) inflater.inflate(R.layout.layout_channelspreview_list_item, null);
				channelsItem.textView = view.findViewById(R.id.textVideoStat1);
				channelsItem.funVideoView = view.findViewById(R.id.funVideoView1);
			}
		} else {
			view = (LinearLayout) convertView;
		}
		
		view.setTag(position);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height);
		//view.setLayoutParams(layoutParams);


		return view;
	}

	public final class ChannelsItem{
		
		public TextView textView;
		public FunVideoView funVideoView;
		
	}
	
}
