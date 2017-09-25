package dynamicProgramming;

public class MaxSumForNonAdjacentElements {
	public int MaxSum(int arr[])
	{
		int inclusive = 0;
		int exclusive = 0;
		int temp=0;
		for(int i=0;i<arr.length;i++)
		{
			temp = inclusive;
			inclusive = Math.max(inclusive, (exclusive+arr[i]));
			exclusive = temp;
		}
		return inclusive;
	}
	
	public static void main(String args[]) {
        MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        System.out.println(msn.MaxSum(arr));

    }
}
