
class Node {
    int data;
    Node next, arb;

    Node(int d) {
        data = d;
        next = arb = null; 
    }
}

class Cloning {
    static Node head;

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(Node head, Node res, Node cloned_add,
                              Node generated_add) {

        if (generated_add == cloned_add) return false;

        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
              else if(temp1.arb== null && temp2.arb !=null)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    //   public static void printList()

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            Node generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                Node tempA = head;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                Node tempB = head;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }

                // when both a is greater than N
                if (a <= n) tempA.arb = tempB;
            }

            generated_add = head;
            Clone g = new Clone();
            Node res = g.copyList(head);

            Node cloned_add = res;

            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}*/
// function to copy linked list
class Clone {
    Node copyList(Node start) {
        Node curr = start, temp = null;  
  
        // insert additional node after  
        // every node of original list  
        while (curr != null)  
        {  
            temp = curr.next;  
      
            // Inserting node  
            curr.next = new Node(curr.data);  
            curr.next.next = temp;  
            curr = temp;  
        }  
        curr = start;  
      
        // adjust the random pointers of the  
        // newly added nodes  
        while (curr != null)  
        {  
            if(curr.next != null)  
                curr.next.arb = (curr.arb != null) 
                          ? curr.arb.next : curr.arb;  
      
            // move to the next newly added node by  
            // skipping an original node  
            curr = (curr.next != null) ? curr.next.next  
                                            : curr.next;  
        }  
      
        Node original = start, copy = start.next;  
      
        // save the start of copied linked list  
        temp = copy;  
      
        // now separate the original list and copied list  
        while (original != null && copy != null)  
        {  
            original.next = (original.next != null)?  
                        original.next.next : original.next;  
      
            copy.next = (copy.next != null) ? copy.next.next  
                                                : copy.next;  
            original = original.next;  
            copy = copy.next;  
        }  
        return temp;
    }
}

