//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int N, List<List<Integer>> adj) {
        // Your code here
        
        List<List<Integer>> adj1=new ArrayList<>();
        for(int i=0; i<N; i++){
            adj1.add(new ArrayList<>());
        }
        int[] indegree=new int[N];
        for(int i=0; i<N; i++){
            for(int j: adj.get(i)){
                adj1.get(j).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        
        for(int i=0; i<N;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(int j: adj1.get(node)){
                indegree[j]--;
                if(indegree[j]==0) q.add(j);
            }
        }
        Collections.sort(list);
        return list;
    }
}
