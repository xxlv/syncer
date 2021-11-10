package com.syncer.syner;

public interface DataSupplier<T> {

    SyncerData<T> get();

    // 当前数据的总条数
    default int count() {
        return 0;
    }
}
