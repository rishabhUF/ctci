package dynamicProgramming;

public class CountNumberOfTreesInBST {
	public int countTrees(int n)
	{
		int[] t = new int[n+1];
		t[0]=1;
		t[1]=1;
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				t[i] = t[i] + t[j]*t[i-j-1]; 
			}
		}
		return t[n];
	}
	public static void main(String args[])
	{
		CountNumberOfTreesInBST cnt = new CountNumberOfTreesInBST();
		System.out.println(cnt.countTrees(5));
	}
}
