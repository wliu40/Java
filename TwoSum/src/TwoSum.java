import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	
	
	 public int[] solver(int[] nums, int target) {
		    int [] ans = new int[2];
	        Map<Integer, ArrayList<Integer>> multimap = new HashMap<Integer, ArrayList<Integer>>();
	        for (int i = 0; i < nums.length; i++){
	        	if(multimap.containsKey(nums[i])){
	        		multimap.get(nums[i]).add(i);
	        		continue;
	        	}
	        	ArrayList<Integer> indices = new ArrayList<Integer>();
	        	indices.add(i);
	        	multimap.put(nums[i], indices);
	        }
	        
	        int num1, num2;
	        int index1 = 0, index2 = 0;
	        for(Map.Entry<Integer, ArrayList<Integer>> entry : multimap.entrySet()){
	        	num1 = entry.getKey();
	        	num2 = target - num1;
	        	if(num1 == num2 && num1 + num2 == target){
	        		index1 = multimap.get(num1).get(0).intValue();
	        		index2 = multimap.get(num1).get(1).intValue();
	        		break;
	        	}
	        	if(multimap.containsKey(num2)){
	        		index1 = multimap.get(num1).get(0).intValue();
	        		index2 = multimap.get(num2).get(0).intValue();	        		
	        		break;
	        	}

	        }
    		ans[0] = Math.min(index1, index2);
    		ans[1] = Math.max(index1, index2);
	        return ans;
	}
	 
		public static void main(String args[]){
			
			TwoSum ts = new TwoSum();
			int [] nums = {2,4,6,2};
			int [] ans = ts.solver(nums, 4);
			
			for(int i: ans){
				System.out.println(i);
			}
			 
		}
}
	



