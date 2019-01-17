package com.mzaini30.yuisongs;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.webkit.JavascriptInterface;

public class AudioInterface {
	Context mContext;

	AudioInterface(Context c) {
		mContext = c;
	}

	private MediaPlayer mp;

	@JavascriptInterface
	public void stopAudio(){
		if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
	}
	
	//Play an audio file from the webpage
	@JavascriptInterface
	public void playAudio(String aud) { //String aud - file name passed 
	                                    //from the JavaScript function
		// final MediaPlayer mp;

			  try {
			  	// stopPlaying();
			  	// if (mp != null) {
		    //         mp.stop();
		    //         mp.release();
		    //         mp = null;
		    //    }


				  AssetFileDescriptor fileDescriptor = mContext.getAssets().openFd(aud);
	                  mp = new MediaPlayer();

	                  mp.setDataSource(fileDescriptor.getFileDescriptor(), 
	                  fileDescriptor.getStartOffset(), 
	                  fileDescriptor.getLength());
	                  
	                  fileDescriptor.close();
	                  mp.prepare();
	                  mp.start();
			  } catch (IllegalArgumentException e) {
	                          // TODO Auto-generated catch block
	                          e.printStackTrace();
	          	  } catch (IllegalStateException e) {
	                          // TODO Auto-generated catch block
	                          e.printStackTrace();
	          	  } catch (IOException e) {
	                          // TODO Auto-generated catch block
	                          e.printStackTrace();
	          } 
	}

	// private void stopPlaying() {
 //        if (mp != null) {
 //            mp.stop();
 //            mp.release();
 //            mp = null;
 //       }
 //    }
}