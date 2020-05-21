import java.io.*;
import java.util.*;

class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Trap obj = new Trap();
		    
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends




class Trap{
    
    static int trappingWater(int arr[], int n){
        
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        
        int water = 0;
        
        lmax[0] = arr[0];
        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }
        
        rmax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            rmax[i] = Math.max(arr[i], rmax[i+1]);
        }
        
        for(int i = 1; i < n-1; i++){
            water += Math.min(lmax[i], rmax[i]) - arr[i];
        }
        
        return water;
    } 
}

