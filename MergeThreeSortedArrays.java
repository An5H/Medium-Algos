//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    static void printSorted(ArrayList<Integer> list)
    {
        for(Integer x : list)
        System.out.print(x + " ");
    }
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    
		    int A[] = new int[a];
		    int B[] = new int[b];
		    int C[] = new int[c];
		    
		    for(int i = 0; i < a; i++)
		      A[i] = sc.nextInt();
		      
		    for(int i = 0; i < b; i++)
		      B[i] = sc.nextInt();
		      
		    for(int i = 0; i < c; i++)
		      C[i] = sc.nextInt();
		    
		    printSorted(new MergeThree().merge3sorted(A, B, C));
		    System.out.println();
		    
		}
	}
}// } Driver Code Ends


//User function Template for Java

class MergeThree
{
    // Function to merge three sorted arrays
    // A[], B[], C[]: input arrays
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        ArrayList <Integer> arr = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while(i < A.length && j < B.length && k < C.length){
            if((A[i] < B[j]) && (A[i] < C[k])){
                arr.add(A[i++]);
            }
            else if((B[j] < A[i]) && (B[j] < C[k])){
                arr.add(B[j++]);
            }
            else{
                arr.add(C[k++]);
            }
        }
        while(i < A.length){
            arr.add(A[i++]);
        }
        while(j < B.length){
            arr.add(B[j++]);
        }
        while(k < C.length){
            arr.add(C[k++]);
        }
        Collections.sort(arr);
        return arr;
    }
}
