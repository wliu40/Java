import java.util.Vector;

public class TestMain {
    public static void main(String[] args) {       
        
        Vector<MyTask> myTasks = TestCase.getTestCases();
        RRalgorithm(myTasks, 1);
        //first argu is the task vector, second argu is the length of the time slice
        System.out.println("------------------------------------------------");
        Vector<MyTask> myTasks2 = TestCase.getTestCases();
        RRalgorithm(myTasks2, 4);
    }
    
    
    public static void RRalgorithm(Vector<MyTask> myTasks, int time_slice){
        System.out.println("Round-Robin algorithm, q = " + time_slice + ": ");
        Queue<MyTask> myTaskQueue = new Queue<MyTask>();
        Vector <MyTask> MyTaskCollector= new Vector<MyTask>();
        if (myTasks.size() == 0){
        	return;
        }                
        myTaskQueue.enqueue(myTasks.get(0));//add the first task to the queue
        myTasks.remove(0);//remove it from the task vector
               
        int time = 0;
        while (!myTaskQueue.isEmpty()){       	
        	//dequeue the first task in the queue
        	MyTask currentTask = myTaskQueue.dequeue();        	
        	
        	//find the min(time_slice, task_service_time)
        	long min_service_time = time_slice < (currentTask.getTime_service()-currentTask.getServicedTime())? time_slice:currentTask.getTime_service()-currentTask.getServicedTime();
        	
        	//execute the task at this period
        	for (long j = 0; j < min_service_time; j++){        		
            	System.out.print("  " + currentTask.getName());
        	}
        	//in the task vector, check all the tasks whose arrival time is less than current time
        	for(int k = 0; k < myTasks.size(); k++){    			
            	MyTask nextTask = myTasks.get(k);        	
            	if (nextTask.getTime_arrival() <= time+min_service_time){
            		myTaskQueue.enqueue(nextTask);//enqueue all those tasks
            		myTasks.remove(k);//remove it from task vector and update the index
            		k--;
            	}
    		}    
        	//if the task was not finished, then put it back to the end of the queue
        	long serviced_time = currentTask.getServicedTime();
            currentTask.setServicedTime(serviced_time + min_service_time);   
            if(serviced_time < currentTask.getTime_service())
            	myTaskQueue.enqueue(currentTask);
            else{
            	currentTask.setFinishTime(serviced_time);
            	MyTaskCollector.add(currentTask);
            	
            }
            //update the current time
        	time += min_service_time;
        }
        System.out.println();
        System.out.print("Task Name: 	");
        for (int i = 0; i < MyTaskCollector.size(); ++i){        	
        	System.out.print(MyTaskCollector.get(i).getName() + "	");    	        	
        }
        System.out.println();
        System.out.print("Finish T: 	");
        for (MyTask i: MyTaskCollector){        	
        	System.out.print(i.getFinishTime() + "	");    	        	
        }
        System.out.println();
        System.out.print("Service T: 	");
        for (MyTask i: MyTaskCollector){        	
        	System.out.print(i.getTime_service() + "	");    	        	
        }
        System.out.println();
        System.out.print("Tr/Ts: 		");
        for (MyTask i: MyTaskCollector){
        	double ratio = (double)(i.getFinishTime()-i.getTime_arrival())/i.getTime_service();
        	     	
        	System.out.print( String.format("%.2f", ratio) + "	");    	        	
        }
        System.out.println();
    }    
}