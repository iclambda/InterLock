package com.htl.interlock.Model;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

//Uri uri = Uri.parse("content://com.htl.providers.settingsprovider/")
public class SettingsContentProvider extends ContentProvider {
    public SettingsContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String  path=uri.getPath();
        switch (path)
        {
            case "1":
                break;
            case "2":
                break;
        }
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
/*
ContentResolver resolver =  getContentResolver();
Uri uri = Uri.parse("content://com.ljq.provider.personprovider/person");
//添加一条记录
ContentValues values = new ContentValues();
values.put("name", "linjiqin");
        values.put("age", 25);
        resolver.insert(uri, values);
//获取person表中所有记录
        Cursor cursor = resolver.query(uri, null, null, null, "personid desc");
        while(cursor.moveToNext()){
        Log.i("ContentTest", "personid="+ cursor.getInt(0)+ ",name="+ cursor.getString(1));
        }
//把id为1的记录的name字段值更改新为zhangsan
        ContentValues updateValues = new ContentValues();
        updateValues.put("name", "zhangsan");
        Uri updateIdUri = ContentUris.withAppendedId(uri, 2);
        resolver.update(updateIdUri, updateValues, null, null);
//删除id为2的记录
        Uri deleteIdUri = ContentUris.withAppendedId(uri, 2);
        resolver.delete(deleteIdUri, null, null)
*/