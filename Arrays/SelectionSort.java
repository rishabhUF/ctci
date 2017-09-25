package Arrays;

public class SelectionSort {
	public void sort(int[] arr)
	{
		int n = arr.length;
		//traverse to find min
		for(int i=0;i<n;i++)
		{
			int min_index = i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[min_index])
				{
					min_index=j;
				}
			}
			//swap
			int temp = arr[i];
			arr[i]=arr[min_index];
			arr[min_index] = temp;
		}
	}
		
		void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	 
	    // Driver code to test above
	    public static void main(String args[])
	    {
	        SelectionSort ob = new SelectionSort();
	        int arr[] = {64,25,12,22,11};
	        ob.sort(arr);
	        System.out.println("Sorted array");
	        ob.printArray(arr);
	    }
	}
