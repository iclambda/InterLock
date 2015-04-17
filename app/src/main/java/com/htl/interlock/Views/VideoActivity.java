package com.htl.interlock.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.htl.interlock.R;
import com.htl.interlock.Utils.UI;


public class VideoActivity extends Activity {


    ImageButton btn;
    ImageButton btn_files;
    ImageButton btn_setting;
    //PlaceholderFragment media=new PlaceholderFragment();
    //VLCVideoFragment media=new VLCVideoFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        UI.run(this,LoginActivity.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        btn=(ImageButton)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //findViewById(R.id.)
            }
        });
        btn_files=(ImageButton)findViewById(R.id.button_files);
        btn_files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UI.run(VideoActivity.this,FileViewer.class);
            }
        });
        btn_setting=(ImageButton)findViewById(R.id.button_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UI.run(VideoActivity.this,SettingActivity.class);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //media.test();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
