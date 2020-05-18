import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	     BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
	     int t = Integer.parseInt(ob.readLine());
	     while(t-- > 0){
	         int size = Integer.parseInt(ob.readLine());
	         String[] str = ob.readLine().trim().split("\\s+");
	         int arr[] = new int[size];
	         for(int i = 0; i < size; i++){
	             arr[i] = Integer.parseInt(str[i]);
	         }
	         int element = Integer.parseInt(ob.readLine());
	         new check().compute(arr, element);
	         System.out.println();
	     }
	 }
}
class check{
    public static void compute(int arr[], int element){
        Arrays.sort(arr);
        System.out.print(arr[element-1]);
    }
}
