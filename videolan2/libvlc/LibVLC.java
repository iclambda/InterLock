/*****************************************************************************
 * LibVLC.java
 *****************************************************************************
 * Copyright © 2010-2013 VLC authors and VideoLAN
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *****************************************************************************/

package org.videolan.libvlc;

import android.os.Build;
import android.util.Log;
import android.view.Surface;

import java.util.ArrayList;
import java.util.Map;

public class LibVLC {
    public static final int AOUT_AUDIOTRACK_JAVA = 0;
    public static final int AOUT_AUDIOTRACK = 1;
    public static final int AOUT_OPENSLES = 2;
    public static final int VOUT_ANDROID_SURFACE = 0;
    public static final int VOUT_OPEGLES2 = 1;
    public static final int HW_ACCELERATION_AUTOMATIC = -1;
    private int hardwareAcceleration = HW_ACCELERATION_AUTOMATIC;
    public static final int HW_ACCELERATION_DISABLED = 0;
    public static final int HW_ACCELERATION_DECODING = 1;
    public static final int HW_ACCELERATION_FULL = 2;
    private static final String TAG = "VLC/LibVLC";
    //////////////////////////////////////////
    private static LibVLC sInstance;
    /////////////////////////////////////////

    private LibVLC() {

    }
    public  static LibVLC getInstance()
    {
        if(sInstance!=null)
            return sInstance;
        synchronized (LibVLC.class)
        {
            if(sInstance==null)
                sInstance= new LibVLC();
        }
        return sInstance;
    }
    public boolean init(Surface sf) {
        try {
            stop();
            nativeInit();
           attachSurface(sf,new VideoPlayer());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void deinit()
    {
        detachSurface();
        nativeDestroy();
    }
    public void  play(String movie)
    {
        playMRL(0, movie, null);
    }

    public static native String nativeToURI(String path);

    public native static void sendMouseEvent( int action, int button, int x, int y);

    public static native void nativeReadDirectory(String path, ArrayList<String> res);

    public native static boolean nativeIsPathDirectory(String path);

    public native void attachSurface(Surface surface, IVideoPlayer player);

    public native void detachSurface();

    public native void attachSubtitlesSurface(Surface surface);

    public native void detachSubtitlesSurface();

    public native void eventVideoPlayerActivityCreated(boolean created);

    public native void setSurface(Surface f);

    private native int setNativeEqualizer(long mediaPlayer, float[] bands);

    public native float getRate();

    public native void setRate(float rate);

    private native void nativeInit() throws LibVlcException;

    private native void nativeDestroy();

    public native void startDebugBuffer();

    public native void stopDebugBuffer();

    private native void playMRL(long instance, String mrl, String[] mediaOptions);

    public native boolean isPlaying();

    public native boolean isSeekable();

    public native void play();

    public native void pause();

    public native void stop();

    public native int getPlayerState();

    public native int getVolume();

    public native int setVolume(int volume);

    public native long getTime();

    public native long setTime(long time);

    public native float getPosition();

    public native void   setPosition(float pos);

    public native long   getLength();

    public native String version();

    public native String compiler();

    public native String changeset();

    private native byte[] getThumbnail(long instance, String mrl, int i_width, int i_height);

    private native boolean hasVideoTrack(long instance, String mrl);

    //private native TrackInfo[] readTracksInfo(long instance, String mrl);

    //public native TrackInfo[] readTracksInfoInternal();

    public native int getAudioTracksCount();

    public native Map<Integer,String> getAudioTrackDescription();

    public native Map<String, Object> getStats();

    public native int getAudioTrack();

    public native int setAudioTrack(int index);

    public native int getVideoTracksCount();

    public native int addSubtitleTrack(String path);

    public native Map<Integer,String> getSpuTrackDescription();

    public native int getSpuTrack();

    public native int setSpuTrack(int index);

    public native int getSpuTracksCount();

    //private native void setEventHandler(EventHandler eventHandler);

    private native void detachEventHandler();

    public native float[] getBands();

    public native String[] getPresets();

    public native float[] getPreset(int index);

    public native int getTitle();

    public native void setTitle(int title);

    public native int getChapterCountForTitle(int title);

    public native int getTitleCount();

    @Override
    protected void finalize() {
        nativeDestroy();
    }
    static {
        try {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1)
                System.loadLibrary("iomx-gingerbread");
            else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB_MR2)
                System.loadLibrary("iomx-hc");
            else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1)
                System.loadLibrary("iomx-ics");
            else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR2)
                System.loadLibrary("iomx-jbmr2");
            else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT)
                System.loadLibrary("iomx-kk");
        } catch (Throwable t) {
            // No need to warn if it isn't found, when we intentionally don't build these except for debug
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
                Log.w(TAG, "Unable to load the iomx library: " + t);
        }
        try {
            System.loadLibrary("vlcjni");
        } catch (UnsatisfiedLinkError ule) {
            Log.e(TAG, "Can't load vlcjni library: " + ule);
            /// FIXME Alert user
            System.exit(1);
        } catch (SecurityException se) {
            Log.e(TAG, "Encountered a security issue when loading vlcjni library: " + se);
            /// FIXME Alert user
            System.exit(1);
        }
    }

}
class VideoPlayer implements IVideoPlayer
{

    @Override
    public void setSurfaceSize(int width, int height, int visible_width, int visible_height, int sar_num, int sar_den) {

    }
}