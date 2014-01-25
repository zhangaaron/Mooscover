package com.example.mooscover;

import java.util.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class ShowList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_list);
		
	
		for (int i = 0; i < DiscoverSongs.favoritesList.size(); i++){
			System.out.println(DiscoverSongs.favoritesList.get(i));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_list, menu);
		return true;
	}

}
