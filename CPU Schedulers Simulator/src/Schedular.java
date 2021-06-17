import java.util.ArrayList;

public class Schedular {
    protected ArrayList<IncomingProcess>mProcesses;//contains proccess to be worked on
    protected ArrayList<ScheduleChart> chartPlanning;//This is the output it includes all processes each one with all the time spent in the schedular
    protected int turnAroundTime;//if needed
    protected int waitingTime;//if needed
    protected int contextSwitchingTime;//if needed
    public void addProccess(IncomingProcess process){
        mProcesses.add(process);
    }
    public void addChart(ScheduleChart chart){
        chartPlanning.add(chart);
    }
//functions included here are to help you in using this class consists of constructor setters and getters


    public ArrayList<IncomingProcess> getProcesses() {
        return mProcesses;
    }

    public void setProcesses(ArrayList<IncomingProcess> processes) {
        mProcesses = processes;
    }

    public ArrayList<ScheduleChart> getChartPlanning() {
        return chartPlanning;
    }

    public void setChartPlanning(ArrayList<ScheduleChart> chartPlanning) {
        this.chartPlanning = chartPlanning;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getContextSwitchingTime() {
        return contextSwitchingTime;
    }

    public void setContextSwitchingTime(int contextSwitchingTime) {
        this.contextSwitchingTime = contextSwitchingTime;
    }

    public Schedular(ArrayList<IncomingProcess> processes, ArrayList<ScheduleChart> chart, int turnAroundTime, int waitingTime, int contextSwitchingTime) {
        mProcesses = processes;
        this.chartPlanning = chart;
        this.turnAroundTime = turnAroundTime;
        this.waitingTime = waitingTime;
        this.contextSwitchingTime = contextSwitchingTime;
    }
}
