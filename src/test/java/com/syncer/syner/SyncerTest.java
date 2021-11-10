package com.syncer.syner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class SyncerTest {

    class MyFlow implements Flow<String> {

        @Override
        public DataSupplier<String> supplier() {
            return () -> null;
        }

        @Override
        public DataConsumer<String> consumer() {
            return data -> {
            };
        }

    }

    @Test
    void dispatchAll() {
        Syncer syncer = new Syncer();
        List<Flow> flows = new ArrayList<>();
        MyFlow myFlow = Mockito.mock(MyFlow.class);
        when(myFlow.supplier()).thenReturn(Mockito.mock(DataSupplier.class));
        when(myFlow.consumer()).thenReturn(Mockito.mock(DataConsumer.class));

        doCallRealMethod().when(myFlow).run();
        flows.add(myFlow);

        List<Flow> flowList = new ArrayList<>();
        flows.listIterator().forEachRemaining(flow -> {
            flowList.add(flow);
        });
        syncer.setFlows(flowList);
        syncer.dispatchAll();
        verify(myFlow.consumer()).accept(any());
        verify(myFlow.supplier(), times(1)).get();
        verify(myFlow, times(1)).run();
    }
}