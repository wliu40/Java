public class Task {

    private long time_arrival;
    private long time_service;

    
    public Task(long time_arrival, long time_service) {
    	
    	
        this.time_arrival = time_arrival;
        this.time_service = time_service;
    }

    public long getTime_arrival() {
        return time_arrival;
    }

    public void setTime_arrival(long time_arrival) {
        this.time_arrival = time_arrival;
    }

    public long getTime_service() {
        return time_service;
    }

    public void setTime_service(long time_service) {
        this.time_service = time_service;
    }
    

    
}
