package com.syncer.job;

import com.syncer.syner.Log;
import com.syncer.syner.Syncer;
import java.util.Date;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BroadcastProcessor;

@Component
public class SyncerJob implements BroadcastProcessor {

    private static final Syncer SYNCER = new Syncer();

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        Log.log("准备执行任务");
        SYNCER.dispatchAll();
        Log.log("执行任务完毕");

        return new ProcessResult(true, new Date().toString());
    }
}
