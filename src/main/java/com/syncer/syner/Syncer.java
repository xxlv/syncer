package com.syncer.syner;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import lombok.Data;

@Data
public class Syncer {

    private String name;
    private static List<Flow> allFlows = new ArrayList<>();

    static {
        ServiceLoader.load(Flow.class).iterator().forEachRemaining(flow -> {
            allFlows.add(flow);
        });
    }

    /**
     * Dispatch all flows
     */
    public void dispatchAll() {
        List<Flow> flowIterator = allFlows;
        if (flowIterator == null) {
            // warn
            Log.log("迭代器为 null");
            return;
        }
        allFlows.parallelStream().forEach(flow -> {
            Log.log("Flow 迭代遍历运行" + flow.name());
            flow.run();
        });


    }

    // for test
    public void setFlows(List<Flow> flows) {
        allFlows = flows;
    }
}
