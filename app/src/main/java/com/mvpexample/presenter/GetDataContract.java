package com.mvpexample.presenter;

import android.content.Context;

import com.mvpexample.model.JsonResponse;
import com.mvpexample.model.Record;

import java.util.List;

public interface GetDataContract {
    interface View{
        void onGetDataSuccess(String message, List<Record> list);
        void onGetDataFailure(String message);
    }
    interface Presenter{
        void getDataFromURL(Context context, String url);
    }
    interface Interactor{
        void initRetrofitCall(Context context, String url);

    }
    interface onGetDataListener{
        void onSuccess(String message, List<Record> list);
        void onFailure(String message);
    }
}
