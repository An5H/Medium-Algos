// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            solver x = new solver();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class solver
{
    static void doRemoveLoop(Node loop, Node head) 
    { 
        Node ptr1 = loop; 
        Node ptr2 = loop; 
  
        // Count the number of nodes in loop 
        int k = 1, i; 
        while (ptr1.next != ptr2) { 
            ptr1 = ptr1.next; 
            k++; 
        } 
  
        // Fix one pointer to head 
        ptr1 = head; 
  
        // And the other pointer to k nodes after head 
        ptr2 = head; 
        for (i = 0; i < k; i++) { 
            ptr2 = ptr2.next; 
        } 
  
        /*  Move both pointers at the same pace, 
         they will meet at loop starting node */
        while (ptr2 != ptr1) { 
            ptr1 = ptr1.next; 
            ptr2 = ptr2.next; 
        } 
  
        // Get pointer to the last node 
        while (ptr2.next != ptr1) { 
            ptr2 = ptr2.next; 
        } 
  
        /* Set the next node of the loop ending node 
         to fix the loop */
        ptr2.next = null; ; 
    }
    public static void removeLoop(Node head){
        Node slow = head, fast = head; 
        while (slow != null && fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
  
            // If slow and fast meet at same point then loop is present 
            if (slow == fast) { 
                doRemoveLoop(slow, head); 
                return; 
            } 
        } 
        return;
    }
}
