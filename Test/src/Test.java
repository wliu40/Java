import java.util.*;

public class Test {

    public boolean isAnagram(String s_string, String t_string) {
        if( s_string.length() != t_string.length() )
            return false;
        char[] s = s_string.toCharArray();
        char[] t = t_string.toCharArray();
        Map<Character, Integer> mp_s = new HashMap<Character, Integer>();
        Map<Character, Integer> mp_t = new HashMap<Character, Integer>();
        for(Character c : s){
            if( mp_s.containsKey(c) )
               mp_s.put(c, mp_s.get(c)+1);
            else
                mp_s.put(c, 1);
        }
        for(Character c : t){
            if( mp_t.containsKey(c) )
               mp_t.put(c, mp_t.get(c)+1);
            else
                mp_t.put(c, 1);
        }
        for(Character c : s){
            if ( mp_s.get(c) != mp_t.get(c) )
            {
            	System.out.println(c + ": " + mp_s.get(c));
            	return false;
            }
                
        }
        return true;
        
    }	
	
	public static void main(String args[]){
		Test test = new Test();
		String s1 = "abcdefgaabenn";
		String s2 = "bdcaegbfaafnn";
		
		//System.out.println( test.isAnagram(s1, s2) );
		
		int[][] arr1 = new int[2][13];
		int rows = arr1.length;
		int cols = arr1[0].length;
		//System.out.print("" + rows + ", " +cols);
		for (int i =0 ; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
				System.out.print(""+arr1[i][j]+",");
			System.out.println();
		}
		int i = 0, j = 10;
		
	}
}
