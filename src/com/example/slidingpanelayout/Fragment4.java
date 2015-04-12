package com.example.slidingpanelayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment4 extends Fragment 
{

	View v=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try
		{
			getActivity().getActionBar().setTitle("Fragment4");
			System.out.println("inside system 4");
			v=inflater.inflate(R.layout.fragment4,null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}

	
}
