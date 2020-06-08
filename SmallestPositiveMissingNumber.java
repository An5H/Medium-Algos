import java.util.*;


 // } Driver Code Ends


class Missing{
    
    // function to find first positive missing number
    static int missingNumber(int arr[], int size)
    {
        int n = size;
        boolean[] present = new boolean[n + 1]; 
  
        for (int i = 0; i < n; i++) { 
            if (arr[i] > 0 && arr[i] <= n) 
                present[arr[i]] = true; 
        } 
  
        for (int i = 1; i <= n; i++) 
            if (!present[i]) 
                return i; 
        return n + 1; 
    }
}


// { Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Missing obj = new Missing();
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

  // } Driver Code Ends
