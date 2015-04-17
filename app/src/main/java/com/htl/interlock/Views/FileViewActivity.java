package com.htl.interlock.Views;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.htl.interlock.R;

public class FileViewActivity extends Activity {


    ViewPager switcher;
    PlaceholderFragment tree1;
    PlaceholderFragment tree2;
    View bottomLayout1;
    View bottomLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_view);
        if (savedInstanceState == null) {
            tree1=new PlaceholderFragment(1);
            tree2=new PlaceholderFragment(2);
            getFragmentManager().beginTransaction()
                    .add(R.id.container, tree1)
                    .commit();

        }
        bottomLayout1=findViewById(R.id.bottomLayout1);
        bottomLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, tree1)
                        .commit();
            }
        });
        bottomLayout2=findViewById(R.id.bottomLayout2);
        bottomLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, tree2)
                        .commit();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file_view, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        int idx;
        public PlaceholderFragment(int idx) {
            this.idx=idx;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_file_view, container, false);
            TextView t=(TextView)rootView.findViewById(R.id.listView2);
            t.setText(String.valueOf(idx));
            return rootView;
        }
    }
}
