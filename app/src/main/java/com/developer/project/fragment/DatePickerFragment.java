package com.developer.project.fragment;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DatePickerFragment extends DialogFragment {

	private OnDateSetListener ondateSet;

	public DatePickerFragment() {
	}

	public void setCallBack(OnDateSetListener ondate) {

		ondateSet = ondate;
	}

	private int year, month, day;

	@Override
	public void setArguments(Bundle bundle) {

		super.setArguments(bundle);
		year  = bundle.getInt("year");
		month = bundle.getInt("month");
		day   = bundle.getInt("day");
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		return new DatePickerDialog(getActivity(), ondateSet, year, month, day);
	}
}