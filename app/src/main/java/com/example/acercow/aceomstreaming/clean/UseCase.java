package com.example.acercow.aceomstreaming.clean;

/**
 * Created by acercow on 18-8-15.
 */

public abstract class UseCase<Q extends UseCase.RequestValue, P extends UseCase.ResponseValue> {

    private Q mRequestValue;

    private UseCaseCallback<P> mCallback;


    public void setRequestValue(Q requestValue) {
        this.mRequestValue = requestValue;
    }

    public void setCallback(UseCaseCallback<P> callback) {
        this.mCallback = callback;
    }

    public Q getRequestValue() {
        return mRequestValue;
    }

    public UseCaseCallback<P> getCallback() {
        return mCallback;
    }

    public abstract void executeCase(Q mRequestValue);


    public interface UseCaseCallback<R extends ResponseValue> {
        void onSuccess(R responseValue);
        void onError(R responseValue);
    }


    public interface RequestValue {


    }

    public interface ResponseValue {

    }
}
