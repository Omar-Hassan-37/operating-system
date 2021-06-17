import java.util.ArrayList;

public class ShortestJobFirst extends Schedular {

    public ShortestJobFirst(ArrayList<IncomingProcess> processes, ArrayList<ScheduleChart> chart, int turnAroundTime, int waitingTime, int contextSwitchingTime) {
        super(processes, chart, turnAroundTime, waitingTime, contextSwitchingTime);
        
        int startTime = 0;
        for(IncomingProcess process : processes ) {
        	 process.getArrivalTime();
        	 process.getBurstTime();
        	 
        }
    }
}
