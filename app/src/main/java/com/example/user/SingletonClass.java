package com.example.user;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

// Volley is an HTTP library that makes networking for Android apps easier and most importantly, faster.
public class SingletonClass {

    private static SingletonClass anInstance;
    private RequestQueue aRequestQueue;
    private Context ctx;

    public SingletonClass(Context ctx) {
        this.ctx = ctx;
        aRequestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (aRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            Cache cache = new DiskBasedCache(ctx.getCacheDir(), 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            aRequestQueue = new RequestQueue(cache, network);
            aRequestQueue = Volley.newRequestQueue(ctx.getApplicationContext());

        }

        return aRequestQueue;

    }

    public static synchronized SingletonClass getInstance(Context context) {
        if (anInstance == null) {
            anInstance = new SingletonClass(context);
    }
    return anInstance;
}

public <T> void addToRequestQueue(Request <T> request) {

        aRequestQueue.add(request);
    }
}
