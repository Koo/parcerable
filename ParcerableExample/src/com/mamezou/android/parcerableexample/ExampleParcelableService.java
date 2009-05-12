package com.mamezou.android.parcerableexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ExampleParcelableService extends Service {

	IExampleParcelableService.Stub binder = new IExampleParcelableService.Stub() {

		@Override
		public void hoge(ExampleParcelable e) throws RemoteException {
			Log.d("ExampleParcelableService", "hoge called data = [" + e.getData() + "]");
		}
		
	};
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

}
