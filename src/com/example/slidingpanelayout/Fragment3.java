package com.example.slidingpanelayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment3 extends Fragment 
{
	View v=null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try
		{
			getActivity().getActionBar().setTitle("Fragment3");
			System.out.println("inside system 3");
			v=inflater.inflate(R.layout.fragment3,null);
			System.out.println("inside fragment 3");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
 
	
}
