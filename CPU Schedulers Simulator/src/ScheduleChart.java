//THIS CLASSS SPECIFIES PROCESS TIME SPENT IN SCHEDULAR AT A TIME
public class ScheduleChart {
    private IncomingProcess process;
    private int startTime;
    private int endTime;

    public IncomingProcess getProcess() {
        return process;
    }

    public void setProcess(IncomingProcess process) {
        this.process = process;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public ScheduleChart(IncomingProcess process, int startTime, int endTime) {
        this.process = process;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
