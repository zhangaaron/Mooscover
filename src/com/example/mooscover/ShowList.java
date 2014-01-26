package com.example.mooscover;


import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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


		int arraySize = DiscoverSongs.favoritesList.size();
		TextView txtview = (TextView)findViewById(R.id.textView1);
		System.out.println(DiscoverSongs.favoritesList.size());
		String dis = new String();
		MediaMetadataRetriever getInfo = new MediaMetadataRetriever();
		
		for(int i = 0; i < arraySize; i++) {	
			
			File f = new File(DiscoverSongs.favoritesList.get(i));
			try {
				FileInputStream fstream = new FileInputStream(f);
				FileDescriptor fd = fstream.getFD();
				
				getInfo.setDataSource(fd);
				dis += getInfo.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE) + "\n";
				System.out.println(dis);
				fstream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			        
			
			
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
