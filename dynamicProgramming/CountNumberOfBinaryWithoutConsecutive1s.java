package dynamicProgramming;

public class CountNumberOfBinaryWithoutConsecutive1s {
	public int count(int n)
	{
		int f[] = new int[n+1];
		int i;
		
		/* 0th and 1st number of the series are 0 and 1*/
		f[0] = 0;
		f[1] = 1;
		
		for (i = 2; i <= n; i++)
		{
		/* Add the previous 2 numbers in the series
			and store it */
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	public int fibCount(int n)
	{
		if(n < 2){
			return n;
		}
		return fibCount(n-1) + fibCount(n-2);
	}
	
	  public static void main(String args[]){
	        CountNumberOfBinaryWithoutConsecutive1s cnb = new CountNumberOfBinaryWithoutConsecutive1s();
	        System.out.println(cnb.count(4));
	    }
}
