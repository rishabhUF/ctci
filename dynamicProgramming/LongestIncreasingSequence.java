package dynamicProgramming;

// Solution:
// Dynamic Programming is used to solve the question.
// O(n*n) 
public class LongestIncreasingSequence {

	public int LongestIncreasingSequenceSol(int arr[])
	{
		int T[] = new int[arr.length];
		// Initialize all the elements to 1 
		for(int i=0;i<arr.length;i++)
		{
			T[i] = 1;
		}
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j] < arr[i])
				{
					// check this condition
					if(T[j]+1 > T[i])
						T[i] = T[j] + 1;
				}
			}
		}
		
		//find the index of max number in T[]
		int maxIndex=0;
		for(int i=0;i<T.length;i++)
		{
			if(T[i] > T[maxIndex])
			{
				maxIndex = i;
			}
		}
		
		return T[maxIndex];
	}
	public int longestSubsequenceRecursive(int arr[]){
        int maxLen = 0;
        for(int i=0; i < arr.length-1; i++){
            int len = longestSubsequenceRecursive(arr,i+1,arr[i]);
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen + 1;
    }
	private int longestSubsequenceRecursive(int arr[], int pos, int lastNum){
        if(pos == arr.length){
            return 0;
        }
        int t1 = 0;
        if(arr[pos] > lastNum){
            t1 = 1 + longestSubsequenceRecursive(arr, pos+1, arr[pos]);
        }
        int t2 = longestSubsequenceRecursive(arr, pos+1, lastNum);
        return Math.max(t1, t2);
    }
	
	public static void main(String args[])
	{
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		System.out.println(lis.LongestIncreasingSequenceSol(arr));
		System.out.println(lis.longestSubsequenceRecursive(arr));
	}
}
