package com.htl.interlock.Service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

public class FileTransferService extends Service {
    public FileTransferService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    class Uploader extends AsyncTask<Void,Void,Boolean>{
        @Override
        protected Boolean doInBackground(Void... params) {
            return null;
        }
/*
 StringBuilder sb = new StringBuilder();
            sb.append( "HTTP/1.1 200 OK\r\n");
            sb.append( "Content-Type: audio/mpeg\r\n");
            sb.append( "Connection: close\r\n" );
            sb.append( "Accept-Ranges: bytes\r\n" );
            sb.append( "Content-Length: " + 10_000_000 + "\r\n" );
            sb.append( "Content-Disposition: inline; filename=xxxxx.mp3\r\n\r\n");
            Uri uri=Uri.parse("http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3");
            try {

                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                player.setDisplay(surface.getHolder());
                player.setDataSource(this.getActivity(),uri);
                player.prepareAsync();
            } catch (IllegalStateException e) {
                //Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                //Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            }
        String url = "http://192.168.2.108:8080/LiteHttpServer/ReceiveFile";
        FileInputStream fis = new FileInputStream(new File("sdcard/1.jpg"));
        Request req = new Request(url);
        req.setMethod(HttpMethod.Post)
                .addParam("lite", new File("sdcard/lite.jpg"), "image/jpeg")
                .addParam("feiq", new File("sdcard/feiq.exe"), "application/octet-stream");
        if (fis != null) req.addParam("meinv", fis, "sm.jpg", "image/jpeg");
        Response res = client.execute(req);
        */
    }
}
