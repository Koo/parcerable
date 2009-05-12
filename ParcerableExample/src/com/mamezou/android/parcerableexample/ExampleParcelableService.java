package com.mamezou.android.parcerableexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class ExampleParcelableService extends Service {

	IExampleParcelableService.Stub binder = new IExampleParcelableService.Stub() {

		@Override
		public void hoge(ExampleParcelable e) throws RemoteException {
			Toast.makeText(getApplicationContext(), "param = " + e.getData(), 0).show();
		}
		
	};
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

}
