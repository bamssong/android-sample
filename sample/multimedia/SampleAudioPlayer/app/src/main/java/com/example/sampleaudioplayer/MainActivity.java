package com.example.sampleaudioplayer;

import java.io.File;
import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity 
{
//	private MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText audioPath   = (EditText) findViewById(R.id.srcedt);
		final CheckBox loopControl = (CheckBox) findViewById(R.id.setloop);
		final Button   playPause   = (Button)   findViewById(R.id.playpause);
		final Button   stop        = (Button) 	findViewById(R.id.stop);
		final Button   load        = (Button) 	findViewById(R.id.load);
		
		
		stop.setEnabled(false);
		playPause.setEnabled(false);
		
		
		load.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				String path = null;
				if(isExternalStorageReadable()) {
					Log.d("TTT","isExternalStorageReadable true");
					File file = new File(Environment.getExternalStoragePublicDirectory(
					            Environment.DIRECTORY_MUSIC), "music_test.mp3");
					path = file.getAbsolutePath();
				} else {
					Log.d("TTT","isExternalStorageReadable false ");
				}
				
				//String path = audioPath.getText().toString();
				if (!loadAudio(path))
				{
					Toast.makeText(getApplicationContext(), "파일 불러오기에 실패했습니다.", Toast.LENGTH_SHORT).show();
				}
				else
				{
					loopControl.setEnabled(true);
					
					audioPath.setEnabled(false);
					load.setEnabled(false);
					
					stop.setEnabled(true);
					playPause.setEnabled(true);

					Toast.makeText(getApplicationContext(), "파일 : " + audioPath.getText().toString(), Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		loopControl.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (loopControl.isChecked()) 
				{
					mp.setLooping(true);
					
					Toast.makeText(getApplicationContext(), "반봅 활성화됨", Toast.LENGTH_SHORT).show();
				}
				else
				{
					mp.setLooping(false);

					Toast.makeText(getApplicationContext(), "반봅 헤제됨", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		playPause.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				if (playPauseAudio() == 0)
				{
					playPause.setText("일시정지");
				}
				else
				{
					playPause.setText("재생");
				}
			}
		});
		
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				mp.stop();
				
				audioPath.setEnabled(true);
				
				playPause.setText("재생");
				loopControl.setChecked(false);
				playPause.setEnabled(false);
				stop.setEnabled(false);
				loopControl.setEnabled(false);
				load.setEnabled(true);
			}
		});
	}
	
	
	private int playPauseAudio()
	{
		if (!mp.isPlaying())
		{
			mp.start();
			Toast.makeText(getApplicationContext(), "재생", Toast.LENGTH_SHORT).show();
			
			return 0;
		}
		else
		{
			mp.pause();
			Toast.makeText(getApplicationContext(), "일시정지됨", Toast.LENGTH_SHORT).show();
			
			return 1;
		}
	}
	
	private boolean loadAudio(String path) 
	{
		mp = new MediaPlayer();
		
		mp = MediaPlayer.create(this, R.raw.music_test);
		return true;
//		try {
//			mp.setDataSource(path);
//			mp.setOnErrorListener(new OnErrorListener() {
//				
//				@Override
//				public boolean onError(MediaPlayer mp, int what, int extra) {
//					Log.d("TTT","what : " + what + " extra : " + extra);
//					return false;
//				}
//			});
//			return true;
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		return false;
	}
	
	
	public boolean isExternalStorageReadable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state) ||
	        Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
	        return true;
	    }
	    return false;
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		
		if (mp != null)
		{
			mp.release();
			mp = null;
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
