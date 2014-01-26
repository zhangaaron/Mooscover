package com.example.mooscover;


import java.io.FileDescriptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ShowList extends Activity {
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_list);

		/*
		for (int i = 0; i < DiscoverSongs.favoritesList.size(); i++){
			System.out.println(DiscoverSongs.favoritesList.get(i));
		}*/

		int arraySize = DiscoverSongs.favoritesList.size();
		TextView txtview = (TextView)findViewById(R.id.textView1);
		//System.out.println(DiscoverSongs.favoritesList.size());
		String dis = new String();
		
		for(int i = 0; i < arraySize; i++) {	
			MediaMetadataRetriever getInfo = new MediaMetadataRetriever();
			System.out.println(DiscoverSongs.favoritesList.get(i));
			AssetFileDescriptor songToID = this.getResources().openRawResourceFd(DiscoverSongs.favoritesList.get(i));
			FileDescriptor fd = songToID.getFileDescriptor();
			getInfo.setDataSource(fd);
			
			dis += getInfo.extractMetadata(9) + "\n";
			System.out.println(dis);
		}
		//txtview.setText((CharSequence) DiscoverSongs.favoritesList.toString());
		txtview.setText(dis);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_list, menu);
		return true;
	}
	
	public void discoverSongs(View view){
		startActivity(new Intent(this, DiscoverSongs.class));
	}

}
