import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {

    final static String FILE_PATH = "/home/vithulan/JFRs/JavaMissionControlTutorial/projects/04_JFR_GC/allocation.jfr";

    public static void main(String[] args) {
        Map<Long,MemEvent> eventMap = new LinkedHashMap<Long, MemEvent>();
        FlightRecording recording = FlightRecordingLoader.loadFile(new File(FILE_PATH));
        IView view = recording.createView();

        GCTimeHandler gcTimeHandler = new GCTimeHandler(view,eventMap);
        gcTimeHandler.configureEventGCTime();
        GCMemoryHandler gcMemoryHandler = new GCMemoryHandler(view,eventMap);
        gcMemoryHandler.configureGCMemory();

        StateIdentifier stateIdentifier = new StateIdentifier(eventMap);
        stateIdentifier.configureStates();

    }
}
