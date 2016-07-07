import com.jrockit.mc.flightrecorder.spi.IEvent;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.util.Map;

public class GCMemoryHandler {
    private final IView view;
    private final Map<Long, MemEvent> eventMap;
    private final String EVENT_TYPE = "Heap Summary";

    public GCMemoryHandler(IView view, Map<Long, MemEvent> eventMap) {
        this.view = view;
        this.eventMap = eventMap;
    }

    public void configureGCMemory() {
        for (IEvent event : view) {
            if (EVENT_TYPE.equals(event.getEventType().getName())) {
                if(event.getValue("when").toString().equals("Before GC")){
                    long gcID = Long.parseLong(event.getValue("gcId").toString());
                    if (eventMap.containsKey(gcID)){
                        MemEvent memEvent = eventMap.get(gcID);
                        memEvent.setUsedHeap(Long.parseLong(event.getValue("heapUsed").toString()));
                    }
                    else {
                        System.out.println("gcID doesn't exist!");
                    }
                }
            }
        }
    }
}
