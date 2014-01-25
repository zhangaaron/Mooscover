package com.example.mooscover;

import java.util.Stack;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class DiscoverSongs extends Activity {
	public static Stack favoritesList = new Stack();
	MediaPlayer mPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discover_songs);
		int song = R.raw.song1;
		mPlayer = MediaPlayer.create(this.getBaseContext(), song);
		mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mPlayer.seekTo(60*1000);
		mPlayer.start();
		favoritesList.push(song);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discover_songs, menu);
		return true;
	}
	
	public void dislikeButton(View view){
		mPlayer.stop();
		mPlayer.release();
		favoritesList.pop();
		startActivity(new Intent(this, DiscoverSongs.class));
	}
	
	public void likeButton(View view){		
		mPlayer.stop();
		mPlayer.release();
		startActivity(new Intent(this, DiscoverSongs.class));
	}
	
	public void showList(View view){
		mPlayer.stop();
		mPlayer.release();
		startActivity(new Intent(this, ShowList.class));
	}

}
