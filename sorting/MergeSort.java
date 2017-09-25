package sorting;

public class MergeSort {

	void sort(int arr[],int start, int end)
	{
		if(start<end)
		{
			int mid = start + (end - start)/2;
			
			sort(arr,start,mid);
			sort(arr,mid+1,end);
			
			merge(arr,start,end,mid);
		}
	}
	public void merge(int[] arr,int start,int end,int mid)
	{
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		//create two temp arrays
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		//copy data to temp arrays
		for(int i=0;i<n1;i++)
		{
			L[i] = arr[start+i];
		}
		for(int j=0;j<n2;j++)
		{
			R[j] = arr[mid + j +1];
		}
		
		/* Merge the two temp array*/
		int i = 0,j=0;
		int k = start;
		while(i<n1 &&j<n2)
		{
			if(L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
	}
}
