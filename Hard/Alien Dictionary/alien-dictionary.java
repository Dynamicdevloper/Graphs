//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            String str1=dict[i];
            String str2=dict[i+1];
            int len= Math.min(str1.length(), str2.length());
            for(int j=0; j<len; j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        int[] indegree=new int[K];
        for(int i=0; i<K; i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        String ans="";
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<K; i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(int j: adj.get(node)){
                indegree[j]--;
                if(indegree[j]==0) q.add(j);
            }
        }
        
        for(int i: list){
            ans= ans+ (char)(i+(int)('a'));
        }
        //System.out.println(ans);
        return ans;
    }
}














