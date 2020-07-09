import java.util.*;


class Celebrity_Problem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new Celebrity().getId(M,N));
		t--;
		}
	}
}
// } Driver Code Ends


class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        Stack <Integer> stack = new Stack <>();
        for (int i = 0; i < n; i++)  
        { 
            stack.push(i); 
        } 
        while(stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(knows(a, b, M)){
                stack.push(b);
            }else{
                stack.push(a);
            }
        }
        int c = stack.pop();
        
        for (int i = 0; i < n; i++)  
        { 
            // If any person doesn't 
            //  know 'c' or 'a' doesn't  
            // know any person, return -1 
            if (i != c && (knows(c, i, M) ||  
                          !knows(i, c, M))) 
                return -1; 
        } 
        return c;
    }
    boolean knows(int a, int b, int M[][]){
        return (M[a][b] == 1) ? true : false;
    }
}
