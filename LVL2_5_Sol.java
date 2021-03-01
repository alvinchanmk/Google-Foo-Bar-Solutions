package lvl2_5;


public class solution {

    public static int solution(int total_lambs) {
        //Your code here
    	int ans = generous_spending(total_lambs) -stingy_spending(total_lambs);
    	
    	
    	return Math.abs(ans);
    	
    }
	
	
	public static int generous_spending(int lambs) {
		int n,ans;
		double i,j,k;
		i = Math.log(lambs+1);
		j = Math.log(2);
		k = ((i/j));
		n = (int) k;
		
		//ans = (int) Math.pow(2.0, (double) (n+1));
		
		return n;
	}
	
	public static int stingy_spending(int lambs) {
		
		int f1,f2,sum, n, temp;
		
		//sum = 0 ;
		n = 0;
		f1 = 0;
		f2 = 1;
		
		for( sum=0 ; sum < lambs; ) {
			temp = f1 + f2;
			f1 = f2;
			f2 = temp;
			sum += temp;
			n +=1;
			}
		return n;
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(solution(143));
		
		System.out.println(solution(10));
		
		
		
	}

}
