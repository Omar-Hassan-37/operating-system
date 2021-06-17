import java.util.ArrayList;

public class ShortestRemainingTimeFirst extends Schedular {
    public ShortestRemainingTimeFirst(ArrayList<IncomingProcess> processes, ArrayList<ScheduleChart> chart, int turnAroundTime, int waitingTime, int contextSwitchingTime) {
        super(processes, chart, turnAroundTime, waitingTime, contextSwitchingTime);
    }
}
