package b04_oop_java.baitap.b02_stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        this.startTime = System.currentTimeMillis();
    }

    public StopWatch(long startTime, long endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime(){
        return startTime;
    }

    public void setStartTime(long startTime){
        this.startTime = startTime;
    }

    public long getEndTime(){
        return endTime;
    }

    public void setEndTime(long endTime){
        this.endTime = endTime;
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }
}
