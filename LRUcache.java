import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



// design the class in the most optimal way

class LRUCache
{
    static private LinkedHashMap<Integer, Integer> map; 
    static private int CAPACITY; 
    public LRUCache(int capacity) 
    { 
        CAPACITY = capacity; 
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) { 
            protected boolean removeEldestEntry(Map.Entry eldest) 
            { 
                return size() > CAPACITY; 
            } 
        }; 
    }

    public static int get(int key)
    {
        return map.getOrDefault(key, -1); 
    }

    public static void set(int key, int value)
    {
        map.put(key, value);
    }
}
