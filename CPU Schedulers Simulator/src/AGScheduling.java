import java.util.ArrayList;

public class AGScheduling extends Schedular {
    public AGScheduling(ArrayList<IncomingProcess> processes, ArrayList<ScheduleChart> chart, int turnAroundTime, int waitingTime, int contextSwitchingTime) {
        super(processes, chart, turnAroundTime, waitingTime, contextSwitchingTime);
    }
}
