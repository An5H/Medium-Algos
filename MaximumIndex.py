
#Complete this function
def maxIndexDiff(arr, n): 
    index = dict()  
    for i in range(n): 
        if arr[i] in index: 
      
            #append to list (for duplicates) 
            index[arr[i]].append(i)   
        else: 
      
            #if first occurrence 
            index[arr[i]] = [i]    
      
    #sort the input array 
    arr.sort()      
    maxDiff = 0
      
    # Temporary variable to keep track of minimum i 
    temp = n      
    for i in range(n): 
        if temp > index[arr[i]][0]: 
            temp = index[arr[i]][0] 
        maxDiff = max(maxDiff, index[arr[i]][-1]-temp)
    return maxDiff
#{ 
#  Driver Code Starts
#Initial Template for Python 3

import math

def main():
        T=int(input())
        while(T>0):
            
            n=int(input())
            
            arr=[int(x) for x in input().strip().split()]
            print(maxIndexDiff(arr,n))
            
            
            T-=1


if __name__ == "__main__":
    main()
# } Driver Code Ends
