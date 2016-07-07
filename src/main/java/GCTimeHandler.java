import com.jrockit.mc.flightrecorder.spi.IEvent;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.util.Map;

public class GCTimeHandler {

    private final IView view;
    private final Map<Long,MemEvent> eventMap;
    private final String EVENT_TYPE = "Garbage Collection";
    public GCTimeHandler(IView view, Map<Long,MemEvent> eventMap){
        this.eventMap = eventMap;
        this.view = view;
    }

    public void configureEventGCTime() {
        for (IEvent event : view) {
            if(EVENT_TYPE.equals(event.getEventType().getName())){
                MemEvent memEvent = new MemEvent();
                memEvent.setStartTimestamp(event.getStartTimestamp());
                memEvent.setEndTimestamp(event.getEndTimestamp());
                memEvent.setGcId(Long.parseLong(event.getValue("gcId").toString()));
                if(!eventMap.containsKey(memEvent.getGcId())){
                    eventMap.put(memEvent.getGcId(),memEvent);
                }
                else {
                    System.out.println("gcID already exists!");
                }
            }
        }
    }
}
