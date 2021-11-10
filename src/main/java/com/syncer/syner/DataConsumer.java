package com.syncer.syner;

public interface DataConsumer<T> {

    void accept(SyncerData<T> data);

    // 执行的成功数
    default int successCount() {
        return 0;
    }

    // 执行的失败数
    default int failCount() {
        return 0;
    }

}
