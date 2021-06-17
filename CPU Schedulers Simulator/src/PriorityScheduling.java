import java.util.ArrayList;

public class PriorityScheduling extends Schedular {
    public PriorityScheduling(ArrayList<IncomingProcess> processes, ArrayList<ScheduleChart> chart, int turnAroundTime, int waitingTime, int contextSwitchingTime) {
        super(processes, chart, turnAroundTime, waitingTime, contextSwitchingTime);
    }
}
