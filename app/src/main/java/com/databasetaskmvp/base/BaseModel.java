package com.databasetaskmvp.base;


import com.databasetaskmvp.data.DataManager;

import java.lang.ref.SoftReference;


public abstract class BaseModel<T extends BaseModelListener> {

    private static final int NO_NETWORK = 999;
    private SoftReference<T> listener;
    protected DataManager mDataManager;

    public BaseModel(T listener) {
        this.listener = new SoftReference<>(listener);
        this.mDataManager = DataManager.getInstance();
    }

    public void attachListener(T listener) {
        this.listener = new SoftReference<>(listener);
    }

    public void detachListener() {
        this.listener = null;
    }

    public T getListener() {
        return (listener != null) ? listener.get() : null;
    }

    public abstract void init();

    public DataManager getDataManager() {
        return DataManager.getInstance();
    }
}