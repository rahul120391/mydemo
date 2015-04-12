package com.example.slidingpanelayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	String[] MenuTitles = new String[] { "First Item", "Second Item",
			"Third Item", "Fourth Item" };
	ListView listview;
	SlidingPaneLayout slidingpane;
	FrameLayout frame;
	FragmentManager fragmentManager;
    Fragment fragment;
    String TAG;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		slidingpane = (SlidingPaneLayout) findViewById(R.id.slidingpane);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_dropdown_item_1line,
				MenuTitles);
		listview = (ListView) findViewById(R.id.listview);
		listview.setAdapter(adapter);
		slidingpane.setPanelSlideListener(panelListener);
		slidingpane.setParallaxDistance(100);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		try
		{
			fragment=new CoverFlowEffect();
			_LetsHaveSomeTransactions(R.id.frame, fragment,TAG);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if (slidingpane.isOpen()) {
					slidingpane.closePane();
				}
				switch (position) {
				case 0:
					try
					{
						fragment=new CoverFlowEffect();
						_LetsHaveSomeTransactions(R.id.frame, fragment,TAG);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 1:
					try
					{
						fragment=new MappFragment();
						_LetsHaveSomeTransactions(R.id.frame, fragment,TAG);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try
					{
						fragment=new Fragment3();
						_LetsHaveSomeTransactions(R.id.frame, fragment,TAG);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					try
					{
						fragment=new Fragment4();
						_LetsHaveSomeTransactions(R.id.frame, fragment,TAG);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (slidingpane.isOpen()) {
				slidingpane.closePane();
			//	getActionBar().setTitle(getString(R.string.app_name));
			} else {
				slidingpane.openPane();
				//getActionBar().setTitle("menu titles");
			}
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	PanelSlideListener panelListener = new PanelSlideListener() {

		@Override
		public void onPanelClosed(View arg0) {
		}

		@Override
		public void onPanelOpened(View arg0) {
		}

		@Override
		public void onPanelSlide(View arg0, float arg1) {

		}

	};

	public void _LetsHaveSomeTransactions(int id, Fragment _frag, String tag) {
		Fragment _fragment = getSupportFragmentManager().findFragmentByTag(tag);
		fragmentManager = getSupportFragmentManager();
		if (null == _fragment) {
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			fragmentTransaction.setCustomAnimations(R.anim.left_to_right, 0, 0,
					R.anim.right_to_left);
			fragmentTransaction.add(id, _frag, tag);
			fragmentTransaction.addToBackStack(tag);
			fragmentTransaction.commit();
		} else {
			fragmentManager.popBackStack(tag, 0);
		}
	}

	@Override
	public void onBackPressed() {
		try {
			slidingpane.closePane();
			if (fragmentManager.getBackStackEntryCount() == 1) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			} else {
				super.onBackPressed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
