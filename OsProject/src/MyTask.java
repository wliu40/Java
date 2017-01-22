
public class MyTask extends Task {
	private String name;
	private long finish_time;
	private long time_serviced;
	public MyTask(String name,long time_arrival, long time_service){
		super(time_arrival, time_service);
		this.setName(name);
		this.finish_time = 0;
		this.time_serviced = 0;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public long getFinishTime() {
        return this.finish_time;
    }

    public void setFinishTime(long time) {
        this.finish_time = time;
    }
    
    public long getServicedTime() {
        return this.time_serviced;
    }

    public void setServicedTime(long time) {
        this.time_serviced = time;
    }

}
