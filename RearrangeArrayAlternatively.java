import java.util.*;
import java.lang.*;
import java.io.*;

class Rearrange {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
		
		while(t-- >0)
		{
		    int n = Integer.parseInt(read.readLine());
		    int[] temp= new int[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    for(int i=0;i<n;i++)
		        temp[i] = Integer.parseInt(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    RearrangeAlternate obj = new RearrangeAlternate();
		    
		    obj.rearrange(temp, n);
		    StringBuffer sb = new StringBuffer();
		    for(int i =0; i < n; i++)
		     sb.append(temp[i] + " ");
		    System.out.println(sb);
		}
	}
}



// } Driver Code Ends


class RearrangeAlternate{
    
    // This function wants you to rearrange the temp array as required
    // and returns a StringBuffer with all elements of modified temp array
    // appended to it.
    // temp: input array
    // n: size of array
    public static void rearrange(int arr[], int n){
        int temp[] = new int[n];
        int small = 0, large = n-1;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            if(flag){
                temp[i] = arr[large--];
            }
            else{
                temp[i] = arr[small++];
            }
            flag = !flag;
        }
        // for(int i: temp){
        //     System.out.print(i+" ");
        // }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }
}


