package com.example.acercow.aceomstreaming.clean;

/**
 * Created by acercow on 18-8-15.
 */

public class UseCaseHandler {

    private static UseCaseHandler INSTANCE;

    private final UseCaseScheduler mScheduler;

    public static UseCaseHandler getInstance(UseCaseScheduler scheduler) {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler(scheduler);
        }

        return INSTANCE;
    }

    private UseCaseHandler(UseCaseScheduler scheduler) {
        this.mScheduler = scheduler;
    }

    public <Q extends UseCase.RequestValue, P extends UseCase.ResponseValue> void
    execute(final UseCase<Q, P> useCase, final Q requestValue, UseCase.UseCaseCallback<P> callback) {
        useCase.setRequestValue(requestValue);
        useCase.setCallback(new UiUseCaseCallback<>(callback, this));
        mScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.executeCase(requestValue);
            }
        });
    }

    <P extends UseCase.ResponseValue> void notifyResponse(P responseValue, UseCase.UseCaseCallback<P> callback) {
        mScheduler.onResponse(responseValue, callback);
    }

    <P extends UseCase.ResponseValue> void notifyError(P responseValue, UseCase.UseCaseCallback<P> callback) {
        mScheduler.onError(responseValue, callback);
    }



    private static class UiUseCaseCallback<P extends UseCase.ResponseValue> implements UseCase.UseCaseCallback<P> {
        private UseCaseHandler mHandler;
        private UseCase.UseCaseCallback<P> mCallback;

        public UiUseCaseCallback(UseCase.UseCaseCallback<P> callback, UseCaseHandler handler) {
            this.mCallback = callback;
            this.mHandler = handler;
        }

        @Override
        public void onSuccess(P responseValue) {
            mHandler.notifyResponse(responseValue, mCallback);
        }

        @Override
        public void onError(P responseValue) {
            mHandler.notifyError(responseValue, mCallback);
        }
    }

}
