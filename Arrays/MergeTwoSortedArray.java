package Arrays;

public class MergeTwoSortedArray {
	public static int[] merge(int arr1[],int arr2[])
	{
		int n = arr1.length;
		int m = arr2.length;
		int i = 0;
		int x = 0;
		int y = 0;
		int[] result = new int[n+m];
		while(x<n && y<m)
		{
			if(arr1[x] < arr2[y])
			{
				result[i] = arr1[x];
				i++;
				x++;
			}
			else{
				result[i] = arr2[y];
				i++;
				y++;
			}
		}
		while(x<n)
		{
			result[i]=arr1[x];
			x++;
			i++;
		}
		while(y<m)
		{
			result[i]=arr2[y];
			y++;
			i++;
		}
		
		return result;
	}
	
	public static void print(int[] arr)
	{
		int n = arr.length;
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String args[])
	{
		int arr1[] = {1,3,5,7};
		int arr2[] = {2,4};
		int[] res = merge(arr1,arr2);
		print(res);
	}
}
