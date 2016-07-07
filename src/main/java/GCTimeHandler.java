import com.jrockit.mc.flightrecorder.spi.IEvent;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vithulan on 7/7/16.
 */
public class GCTimeHandler {

    final IView view;
    final String EVENT_TYPE = "Garbage Collection";
    public GCTimeHandler(IView view, List<MemEvent> eventList){
        this.view=view;
    }

    public void getGCDuration() {
        for (IEvent event : view) {
            if(EVENT_TYPE.equals(event.getEventType().getName())){
                System.out.println(event.getValue("sumOfPauses").toString());
            }
        }
    }
}
