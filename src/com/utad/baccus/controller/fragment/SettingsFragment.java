package com.utad.baccus.controller.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioGroup;

import com.utad.baccus.R;

public class SettingsFragment extends DialogFragment implements android.content.DialogInterface.OnClickListener {

	public static final int REQUEST_SELECT_SCALE_TYPE = 0;
	public static final String OPTION_SELECTED = "OPTION_SELECTED";
	public static final int OPTION_NORMAL = 0;
	public static final int OPTION_FIT = 1;
	protected View mRoot = null;
	
	@SuppressLint("InflateParams") @Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		
		mRoot = getActivity().getLayoutInflater().inflate(R.layout.fragment_settings, null);
		dialog.setTitle(R.string.action_settings);
		dialog.setView(mRoot);
		dialog.setPositiveButton(android.R.string.ok, this);
		dialog.setNegativeButton(android.R.string.cancel, this);
		
		return dialog.create();
	}
	
	public void cancel() {
		Fragment targetFragment = getTargetFragment();
		if (targetFragment == null) {
			Activity activity = getActivity();
			activity.setResult(Activity.RESULT_CANCELED);
			activity.finish();
		}
		else {
			targetFragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_CANCELED, null);
		}
	}
	
	public void save() {
		Activity activity = getActivity();
		Intent intent = new Intent();
		RadioGroup radios = (RadioGroup) mRoot.findViewById(R.id.radio_options);
		
		if (radios.getCheckedRadioButtonId() == R.id.radio_normal) {
			intent.putExtra(OPTION_SELECTED, OPTION_NORMAL);
		}
		else {
			intent.putExtra(OPTION_SELECTED, OPTION_FIT);
		}
		
		Fragment targetFragment = getTargetFragment();
		if (targetFragment == null) {
			activity.setResult(Activity.RESULT_OK, intent);
			activity.finish();
		}
		else {
			targetFragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
		}
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
			case DialogInterface.BUTTON_POSITIVE:
				save();
				break;
	
			case DialogInterface.BUTTON_NEGATIVE:
				cancel();
				break;
				
			default:
				break;
		}
	}
}