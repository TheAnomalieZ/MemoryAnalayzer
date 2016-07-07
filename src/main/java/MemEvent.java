/**
 * Created by vithulan on 7/7/16.
 */
public class MemEvent {
    private long duration;
    private long gcId;
    private long memory;

    public long getDuration() {
        return duration;
    }

    public long getGcId() {
        return gcId;
    }

    public long getMemory() {
        return memory;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setGcId(long gcId) {
        this.gcId = gcId;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }
}
