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
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int size, int k) {
        // Your code here
        int n=flights.length;
        int[] dist= new int[size+1];
        Arrays.fill(dist, (int)1e9);
        ArrayList<ArrayList<Pair>> adj =new ArrayList<>();
        
        for(int i=0; i<=size; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<Pair> q=new LinkedList<>();
        
        q.add(new Pair(k, 0));
        dist[k]=0;
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int src= p.src;
            int distance=p.dist;
            
            for(Pair pair: adj.get(src)){
                int newSrc= pair.src;
                int newDist=pair.dist;
                
                if(distance+newDist< dist[newSrc]){
                    dist[newSrc]=distance+newDist;
                    q.add(new Pair(newSrc, dist[newSrc]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1; i<=size; i++){
            max=Math.max(max, dist[i]);
        }
        
        if(max==(int)1e9) return -1;
        return max;
    }
}



class Pair{
    
    int src;
    int dist;
    
    Pair(int src, int dist){
        this.src=src;
        this.dist=dist;
    }
}





















