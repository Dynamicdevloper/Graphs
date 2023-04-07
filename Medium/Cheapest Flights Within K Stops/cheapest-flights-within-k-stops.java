//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        ArrayList<ArrayList<Pair>> adj =new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] distance= new int[n];
        
        for(int i=0; i<n; i++){
            distance[i]=(int)1e9;
        }
        
        while(!q.isEmpty()){
            Tuple tuple=q.remove();
            int stop=tuple.stop;
            int node=tuple.node;
            int dist=tuple.dist;
            
            if(stop > k) continue;
            for(Pair pair: adj.get(node)){
                int adjNode= pair.node;
                int adjDist= pair.dist;
                
                if(adjDist+dist<distance[adjNode] && stop<=k){
                    distance[adjNode]=adjDist+dist;
                    q.add(new Tuple(stop+1, adjNode, distance[adjNode]));
                }
            }
            
        }
        
        if(distance[dst]==(int)1e9) return -1;
        return distance[dst];
    }
}


class Tuple{
    
    int stop;
    int node;
    int dist;
    
    Tuple(int stop, int node, int dist){
        this.stop=stop;
        this.node=node;
        this.dist=dist;
    }
}


class Pair{
    int node;
    int dist;
    
    Pair(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
}

















