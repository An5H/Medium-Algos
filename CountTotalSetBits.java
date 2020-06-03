
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


 // } Driver Code Ends


//User function Template for Java

class CountBits{
    
    // Function to count number of set bits
    public static int countSetBits(int n){
        int bitCount = 0; 
      
        for (int i = 1; i <= n; i++) 
            bitCount += countSetBitsUtil(i); 
      
        return bitCount;
    }
    public static int countSetBitsUtil( int x) 
    { 
        if (x <= 0) 
            return 0; 
        return (x % 2 == 0 ? 0 : 1) +  
               countSetBitsUtil(x / 2); 
    } 
}

// { Driver Code Starts.

// Driver code
class BitWise {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();

		    CountBits obj = new CountBits();

		    System.out.println(obj.countSetBits(n));
		}
	}
}
  // } Driver Code Ends
