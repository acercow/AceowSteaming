package com.example.acercow.aceomstreaming.component;

/**
 * Created by acercow on 18-8-21.
 */

public class SurfaceController {

    private SurfaceHostCallback mSurfaceHostCallback;

    private SurfaceController(SurfaceHostCallback callback) {
        this.mSurfaceHostCallback = callback;
    }

    public static SurfaceController createController(SurfaceHostCallback callback) {
        return new SurfaceController(callback);
    }


}
