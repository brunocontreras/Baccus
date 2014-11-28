package com.utad.baccus.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;
import com.utad.baccus.model.Winehouse;

public class WineListFragment extends Fragment {

	private OnWineSelectedListener mOnWineSelectedListener = null;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View root = inflater.inflate(R.layout.fragment_wine_list, container, false);
		
		ListView list = (ListView) root.findViewById(R.id.wine_list);
		list.setAdapter(new ArrayAdapter<Wine>(
				getActivity(),
				android.R.layout.simple_spinner_dropdown_item,
				Winehouse.getInstance().cloneWineList()));
		
		
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (mOnWineSelectedListener != null) {
					mOnWineSelectedListener.onWineSelected(position);
				}				
			}
		});
		
		return root;
	}
	
	public void setOnWineSelectedListener(OnWineSelectedListener onWineSelectedListener) {
		mOnWineSelectedListener = onWineSelectedListener;
	}
	
	public interface OnWineSelectedListener {
		void onWineSelected(int index);
	}
}