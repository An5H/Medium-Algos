import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class MergeLL
{
   static Node head;
    public static void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} 
		else
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
    public static void printList(Node node)
    {
        if(node == null)
          return;
          while(node != null)
          {
              System.out.print(node.data + " ");
              node = node.next;
          }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            Node []a=new Node[N];
            for(int i = 0; i < N; i++)
              {
                  int n = sc.nextInt();
                  int p = sc.nextInt();
                  Node start=null,cur=null;
                Node head = new Node(p);
                start=head;
                cur=head;
                    for(int j = 1; j < n; j++)
                    {
                        int a1 = sc.nextInt();
                        Node ptr=new Node(a1);
                        cur.next=ptr;
                        cur=ptr;
                    }
                    a[i]=start;
              }
             Node start=a[0];
             Merge g = new Merge();
             
             Node res = g.mergeKList(a,N);
             if(res!=null)
             printList(res);
             System.out.println();
            
        }
        
    }
}// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
/*a is an array of Nodes of the heads of linked lists
  and N is size of array a*/
class Merge
{
    Node mergeKList(Node[]arr,int k)
    {
        Node head = null, last = null; 
  
        // priority_queue 'pq' implemeted as min heap with the 
        // help of 'compare' function 
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() { 
            public int compare(Node a, Node b) 
            { 
                return a.data - b.data; 
            } 
        }); 
  
        // push the head nodes of all the k lists in 'pq' 
        for (int i = 0; i < k; i++) 
            if (arr[i] != null) 
                pq.add(arr[i]); 
  
        // loop till 'pq' is not empty 
        while (!pq.isEmpty()) { 
            // get the top element of 'pq' 
            Node top = pq.peek(); 
            pq.remove(); 
  
            // check if there is a node next to the 'top' node 
            // in the list of which 'top' node is a member 
            if (top.next != null) 
                // push the next node in 'pq' 
                pq.add(top.next); 
  
            // if final merged list is empty 
            if (head == null) { 
                head = top; 
                // points to the last node so far of 
                // the final merged list 
                last = top; 
            } 
            else { 
                // insert 'top' at the end of the merged list so far 
                last.next = top; 
                // update the 'last' pointer 
                last = top; 
            } 
        } 
        // head node of the required merged list 
        return head;
    }
}
