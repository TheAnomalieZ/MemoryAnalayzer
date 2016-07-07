import com.jrockit.mc.flightrecorder.FlightRecording;
import com.jrockit.mc.flightrecorder.FlightRecordingLoader;
import com.jrockit.mc.flightrecorder.spi.IView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vithulan on 7/7/16.
 */
public class Application {

    final static String FILE_PATH = "/home/vithulan/JFRs/JavaMissionControlTutorial/projects/04_JFR_GC/allocation.jfr";

    public static void main(String[] args) {
        List <MemEvent> eventList = new ArrayList<MemEvent>();
        FlightRecording recording = FlightRecordingLoader.loadFile(new File(FILE_PATH));
        IView view = recording.createView();
        GCTimeHandler gcTimeHandler = new GCTimeHandler(view,eventList);
        gcTimeHandler.getGCDuration();
    }
}
