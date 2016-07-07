public class MemEvent {

    private long gcId;
    private long usedHeap;
    private long startTimestamp;
    private long endTimestamp;

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getGcId() {
        return gcId;
    }

    public long getUsedHeap() {
        return usedHeap;
    }

    public void setGcId(long gcId) {
        this.gcId = gcId;
    }

    public void setUsedHeap(long usedHeap) {
        this.usedHeap = usedHeap;
    }
}
