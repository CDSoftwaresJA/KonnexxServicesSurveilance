package com.example.funsdkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.funsdkdemo.alarm.ServiceGuideLanAlarmNotification;
import com.example.funsdkdemo.alarm.ServiceGuidePushAlarmNotification;
import com.lib.SDKCONST;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunLoginListener;
import com.lib.funsdk.support.models.FunDevType;
import com.lib.funsdk.support.models.FunDevice;
import com.orhanobut.hawk.Hawk;

public class ActivityStartup extends FragmentActivity implements OnFunLoginListener {

	private final int MESSAGE_ENTER_MAINMENU = 0x100;
	private final int MESSAGE_LOGIN_FUNISHED = 0x101;
	
	
	private boolean mLoginHasFinished = false;
	private boolean mWaitTimeout = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_startup);
		
		startPushAlarmNotification();
		Hawk.init(getBaseContext()).build();
		mHandler.sendEmptyMessageDelayed(MESSAGE_ENTER_MAINMENU, 2000);
		
		// 监听用户登录/登出时间
		FunSupport.getInstance().registerOnFunLoginListener(this);
		
		// 尝试登录上一次成功登录的自动登录
		if ( !FunSupport.getInstance().getAutoLogin()
						|| !FunSupport.getInstance().loginByLastUser() ) {
			// 之前没有账号成功登录或者没有设置为自动登录,结束登录流程
			mHandler.sendEmptyMessage(MESSAGE_LOGIN_FUNISHED);
		}
	}

	@Override
	protected void onDestroy() {
		FunSupport.getInstance().removeOnFunLoginListener(this);
		
		if ( null != mHandler ) {
			mHandler.removeCallbacksAndMessages(null);
			mHandler = null;
		}
		super.onDestroy();
	}

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {
			case MESSAGE_ENTER_MAINMENU:
				{
					mWaitTimeout = true;
					String mac = Hawk.get("ID");
					String name=Hawk.get("name");
					if (mac !=null && name !=null){
						FunDevice mFunDevice = FunSupport.getInstance().buildTempDeivce(FunDevType.EE_DEV_CAMERA, mac);
						mFunDevice.loginName=name;
						DeviceActivitys.startDeviceActivity(ActivityStartup.this, mFunDevice);
					}else{
						enterSDKGuide();
					}

					
				}
				break;
			case MESSAGE_LOGIN_FUNISHED:
				{
					mLoginHasFinished = true;
					
					enterSDKGuide();
				}
				break;

			}
		}
		
	};
	
	private void startPushAlarmNotification() {
		Intent intent = new Intent(this, ServiceGuidePushAlarmNotification.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startService(intent);
	}
	
	private void startLanAlarmNotification() {
		Intent intent = new Intent(this, ServiceGuideLanAlarmNotification.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startService(intent);
	}
	
	private void enterSDKGuide() {
		// 在登录动作完成后才允许进入Demo主界面
		if ( mLoginHasFinished && mWaitTimeout ) {


			Intent intent = new Intent();
			intent.setClass(this, ActivityGuideDeviceSNLogin.class);

			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			startActivity(intent);
			overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
			finish();
		}
	}

	@Override
	public void onLoginSuccess() {
		if ( null != mHandler ) {
			mHandler.sendEmptyMessage(MESSAGE_LOGIN_FUNISHED);
		}
	}

	@Override
	public void onLoginFailed(Integer errCode) {
		if ( null != mHandler ) {
			mHandler.sendEmptyMessage(MESSAGE_LOGIN_FUNISHED);
		}
	}

	@Override
	public void onLogout() {}

}
