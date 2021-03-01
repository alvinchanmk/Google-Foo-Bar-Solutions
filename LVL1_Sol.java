package lvl1;


public class Solution {

	

    public static String solution(String x) {
        // Your code here
        
        String answer = new String();
        
        for(int i = 0; i < x.length(); i++){
        	
        	
            answer = answer +ConvertChar(x.charAt(i));
        }
        
        return answer;
        
    }

    public static char ConvertChar(char c){
        int i = (int) c; // ascii int value of input
        
        if(i>122 || i<97){
            return c;
        }
        
        i=i-97; // a =0 b =1 ...z=49
        i=i-25; // if 
        i=0-i;
        i+=97;
        c = (char)i;
        return c;
    }
	    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(""));
		
	}

}
