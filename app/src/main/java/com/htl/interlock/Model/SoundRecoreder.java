package com.htl.interlock.Model;

import android.media.MediaRecorder;

import java.io.IOException;

/**
 * Created by Administrator on 2015/4/10.
 */
public class SoundRecoreder {
    public void start()
    {
        MediaRecorder myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile("");

        try {
            myAudioRecorder.prepare();
            myAudioRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
