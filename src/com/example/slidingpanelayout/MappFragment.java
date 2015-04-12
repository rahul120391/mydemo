package com.example.slidingpanelayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class MappFragment extends Fragment {

	
	GoogleMap map;
	View v = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try {
			System.out.println("inside mapp fragment");
			getActivity().getActionBar().setTitle("Map");
			v = inflater.inflate(R.layout.mapfragments, null);
			if(map==null)
			{
				map = ((SupportMapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				map.setBuildingsEnabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		SupportMapFragment f = (SupportMapFragment)getFragmentManager().findFragmentById(R.id.map);
	    if (f != null){ 
	        getFragmentManager().beginTransaction().remove(f).commit();
	    }
	}
}
