package com.mamezou.android.parcerableexample;

import android.os.Parcel;
import android.os.Parcelable;

public class ExampleParcelable implements Parcelable {

	private String data;

	public ExampleParcelable() {

	}

	public ExampleParcelable(Parcel in) {
		data = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(data);
	}

	public static final Parcelable.Creator<ExampleParcelable> CREATOR = new Parcelable.Creator<ExampleParcelable>() {
		public ExampleParcelable createFromParcel(Parcel in) {
			return new ExampleParcelable(in);
		}

		public ExampleParcelable[] newArray(int size) {
			return new ExampleParcelable[size];
		}
	};

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
