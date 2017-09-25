package Arrays;

public class BinarySearch {
	public static int binarySearch(int[] arr, int num){
		//write your code here
      return binarysearchHelper(arr,0,arr.length,num);
	}
  public static int binarysearchHelper(int[] arr,int start,int end,int num)
  {
	 if(num > arr[arr.length-1])
		 return -1;
	 if(num < arr[0])
		 return -1;
	 
    if(start<=end)
    {
      int mid = start + (end-start)/2;
      if(arr[mid] == num)
        return 1;
      else if(arr[mid]>num)
        return binarysearchHelper(arr,start,mid-1,num);
      else
        return binarysearchHelper(arr,mid+1,end,num);
    }
    return -1;
  }
  public static void main(String args[])
  {
	  int arr[] = {1,2,3,4,5,6,7,8};
	  BinarySearch exm = new BinarySearch();
	  int result = exm.binarySearch(arr, 0);
	  System.out.println(result);
  }
}
