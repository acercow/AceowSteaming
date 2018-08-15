package com.example.acercow.aceomstreaming.clean;


import android.os.Handler;
import android.os.Looper;

/**
 * Created by acercow on 18-8-15.
 */

public class SimpleUseCaseScheduler implements UseCaseScheduler {
    private Handler mHandler = new Handler();

    @Override
    public void execute(final Runnable runnable) {
        new Thread() {
            @Override
            public void run() {
                runnable.run();
            }
        }.start();
    }

    @Override
    public <P extends UseCase.ResponseValue> void onResponse(final P responseValue, final UseCase.UseCaseCallback<P> callback) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(responseValue);
            }
        });
    }

    @Override
    public <P extends UseCase.ResponseValue> void onError(final P responseValue, final UseCase.UseCaseCallback<P> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(responseValue);
            }
        });
    }
}
