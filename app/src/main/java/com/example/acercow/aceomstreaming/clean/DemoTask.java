package com.example.acercow.aceomstreaming.clean;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by acercow on 18-8-15.
 */

public class DemoTask extends UseCase<DemoTask.RequestValue, DemoTask.ResponseValue> {

    private final Context mContext;

    public DemoTask(Context context) {
        mContext = context;
    }

    @Override
    public void executeCase(DemoTask.RequestValue  mRequestValue) {
        try {
//            Toast.makeText(mContext, mRequestValue.mMsg, Toast.LENGTH_SHORT).show();
            Thread.sleep(5000);
            getCallback().onSuccess(new ResponseValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static class RequestValue implements UseCase.RequestValue {
        public String mMsg = "Request";

    }

    public static class ResponseValue implements UseCase.ResponseValue {
        public String mMsg = "Response";
    }
}
