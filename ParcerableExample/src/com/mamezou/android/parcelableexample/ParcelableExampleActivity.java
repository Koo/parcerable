package com.mamezou.android.parcelableexample;

import com.mamezou.android.parcelableexample.IExampleParcelableService;
import com.mamezou.android.parcelableexample.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ParcelableExampleActivity extends Activity {

	IExampleParcelableService service;

	private ServiceConnection conn = new ServiceConnection() {
		public void onServiceConnected(ComponentName componentName,
				IBinder binder) {
			// binderからサービスを取得
			service = IExampleParcelableService.Stub.asInterface(binder);
		}

		public void onServiceDisconnected(ComponentName componentName) {
			conn = null;
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(sendListener);
	}

	private Button sendButton;

	private View.OnClickListener sendListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (service != null) {
				ExampleParcelable parcelable = new ExampleParcelable();
				parcelable.setData("this is sample message!!");
				try {
					service.hoge(parcelable);
				} catch (RemoteException e) {
					Log.e("parcelableexampleActivity", e.getLocalizedMessage(),
							e);
				}
			}
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		Intent intent = new Intent(IExampleParcelableService.class.getName());
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unbindService(conn);
	}
}