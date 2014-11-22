package com.utad.baccus.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.utad.baccus.R;

public class SettingsFragment extends Fragment implements OnClickListener {

	public static final String OPTION_SELECTED = "OPTION_SELECTED";
	public static final int OPTION_NORMAL = 0;
	public static final int OPTION_FIT = 1;
	protected View mRoot = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		mRoot = inflater.inflate(R.layout.fragment_settings, container, false);
		
		Button cancelButton = (Button) mRoot.findViewById(R.id.cancel_button);
		cancelButton.setOnClickListener(this);
		
		Button saveButton = (Button) mRoot.findViewById(R.id.save_button);
		saveButton.setOnClickListener(this);
				
		return mRoot;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cancel_button:
			cancel();
			break;
		case R.id.save_button:
			save();
			break;
		default:
			break;
		}
	}
	
	public void cancel() {
		Activity activity = getActivity();
		activity.setResult(Activity.RESULT_CANCELED);
		activity.finish();
	}
	
	public void save() {
		Activity activity = getActivity();
		Intent intent = activity.getIntent();
		
		RadioGroup radios = (RadioGroup) mRoot.findViewById(R.id.radio_options);
		
		if (radios.getCheckedRadioButtonId() == R.id.radio_normal) {
			intent.putExtra(OPTION_SELECTED, OPTION_NORMAL);
		}
		else {
			intent.putExtra(OPTION_SELECTED, OPTION_FIT);
		}
		activity.setResult(Activity.RESULT_OK, intent);
		activity.finish();
	}
}