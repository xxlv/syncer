package com.syncer.syner;

public interface Flow<T> {

    default String name() {
        return "FLOW";
    }

    DataSupplier<T> supplier();

    DataConsumer<T> consumer();

    default void run() {
        Log.log("正在执行任务Flow ");
        DataConsumer<T> consumer = consumer();
        DataSupplier<T> supplier = supplier();
        consumer.accept(supplier.get());
        if (consumer.failCount() > 0) {
            Log.log("处理数据失败条目 " + consumer.failCount());
        }
        Log.log(consumer.toString() + " Accept " + supplier.toString() + " 's data");
    }
}
