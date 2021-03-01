package lvl2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class solution {

    public static String[] solution(String[] l) {
        // Your code here
 
    	int size = l.length;
    	for(int i =0; i<size ; i++) {
    		for(int j =0; j<size-1; j++) {
    			if(isLargerThan(l[j],l[j+1])) {
    				String temp=l[j+1];
    				l[j+1]=l[j];
    				l[j]=temp;
    			}			
    		}    		
    	}
    	return l;
    }
	
    
    public static boolean isLargerThan(String first, String second) {
    	
    	ArrayList<Integer> firstList = stringArrayofFloors(first);
    	ArrayList<Integer> secondList = stringArrayofFloors(second);
    	
    	int i = firstList.size();
    	
    	if(secondList.size()<i) {
    		i=secondList.size();
    	}
    	
    	for(int j=0; j<i;j++) {
    		if(firstList.get(j).equals(secondList.get(j))) {
    			continue;
    		}
    		else if(firstList.get(j)>secondList.get(j)) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	if(firstList.size()>secondList.size()) {
    		return true;
    		}
    	return false;
    }
    
    
    public static int largestNumberofString(String[] l) {
    	int i=0;
    	for(String j : l) {
    		if(numberOfFloors(j)>i) {
    			i=numberOfFloors(j);
    		}
    	}
    	return i;
    }
	
    
    public static ArrayList<Integer> stringArrayofFloors(String s) {
    	String[] list;
    	list = s.split("\\.");
    	ArrayList<Integer> listOfFloorInt = new ArrayList<Integer>();
    	for(String i : list) {
    		listOfFloorInt.add(Integer.parseInt(i));   		
    	}
    	return listOfFloorInt;
    }
	
    public static int numberOfFloors(String s) {
    	String[] list;
    	list = s.split("\\.");
    	return list.length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] list = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};

		System.out.println(Arrays.toString(list));
		
		
		System.out.println(Arrays.toString(solution(list)));
		
	}
    
}
