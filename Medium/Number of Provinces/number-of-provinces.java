//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class DisjointSet{
    
    ArrayList<Integer> rank= new ArrayList<>();
    ArrayList<Integer> parent= new ArrayList<>();
    ArrayList<Integer> sizet=new ArrayList<>();
    
    DisjointSet(int size){
        for(int i=0; i<size; i++){
            rank.add(0);
            sizet.add(1);
            parent.add(i);
        }
    }
    
    public int ultParent(int node){
        if(node==parent.get(node)) return node;
        int ultp= ultParent(parent.get(node));
        parent.set(node, ultp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v){
        int ultp_u=ultParent(u);
        int ultp_v=ultParent(v);
        if(ultp_u == ultp_v) return;
        
        int rank_u=sizet.get(ultp_u);
        int rank_v=sizet.get(ultp_v);
        
        if( sizet.get(ultp_u) < sizet.get(ultp_v) ){
            parent.set(ultp_u, ultp_v);
            rank.set(ultp_v, rank_u+rank_v);
        }else{
            parent.set(ultp_v, ultp_u);
            rank.set(ultp_u, rank_u+rank_v);
        }
    }
}

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds=new DisjointSet(V);
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j)==1){
                    ds.unionByRank(i, j);
                }
            }
        }
        
        int count=0; 
        
        for(int i=0; i<V; i++){
            if(ds.parent.get(i)==i) count++;
        }
        
        return count;
    }
};
























