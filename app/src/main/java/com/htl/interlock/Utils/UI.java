package com.htl.interlock.Utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2015/4/8.
 */
public class UI {
    public static void  run(Context ctx,Class cls)
    {
        Intent  intent=new Intent(ctx,cls);
        ctx.startActivity(intent);
    }
}
