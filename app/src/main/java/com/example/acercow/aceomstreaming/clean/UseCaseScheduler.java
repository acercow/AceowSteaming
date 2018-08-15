package com.example.acercow.aceomstreaming.clean;

import com.example.acercow.aceomstreaming.R;

/**
 * Created by acercow on 18-8-15.
 */

public interface UseCaseScheduler {

    void execute(Runnable runnable);

    <P extends UseCase.ResponseValue> void onResponse(P responseValue, UseCase.UseCaseCallback<P> callback);

    <P extends UseCase.ResponseValue> void onError(P responseValue, UseCase.UseCaseCallback<P> callback);
}
