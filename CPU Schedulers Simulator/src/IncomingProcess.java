public class IncomingProcess {
    private String processName;
    private String color;// data type might changed later
    private int arrivalTime;
    private int priorityNumber;
    private int burstTime;
    private int numOfProcesses;

    public void incrementPriorityNumber(int value){
        priorityNumber+=value;
    }
    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    private int quantumTime;

    public int getQuantumTime() {
        return quantumTime;
    }

    public void setQuantumTime(int quantumTime) {
        this.quantumTime = quantumTime;
    }

    public IncomingProcess(String processName, String color, int arrivalTime, int priorityNumber, int burstTime) {
        this.processName = processName;
        this.color = color;
        this.arrivalTime = arrivalTime;
        this.priorityNumber = priorityNumber;
        this.burstTime = burstTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }
    
    public void setNumOfProcesses(int numOfProcesses) {
    	this.numOfProcesses = numOfProcesses;
    }
    
    public int getNumOfProcesses() {
    	return numOfProcesses;
    }
}
