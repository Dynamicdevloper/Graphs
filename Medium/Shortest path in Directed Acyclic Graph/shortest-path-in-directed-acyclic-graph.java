//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<Pair>> adj=new ArrayList<>();
		
		for(int i=0; i<N; i++){
		    adj.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++){
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		boolean visited[] =new boolean[N];
		Stack<Integer> st=new Stack<>();
		for(int i=0; i<N; i++){
		    if(!visited[i]){
		        topoSort(i, adj, st, visited);
		    }
		}
		int[] dist= new int[N];
		for(int i=1; i<N; i++){
		    dist[i]=(int)1e9;
		}
		while(!st.isEmpty()){
		    int node=st.pop();
		    
		    for(int i=0; i<adj.get(node).size(); i++){
		        int v=adj.get(node).get(i).element;
		        int wt= adj.get(node).get(i).weight;
		        if(dist[node]+wt<dist[v]){
		            dist[v]=dist[node]+wt;
		        }
		    }
		}
		
		for(int i=0; i<N; i++){
		    if(dist[i]==(int)1000000000){
		        dist[i]=-1;
		    }
		}
		return dist;
	}
	
	public void topoSort(int node, List<List<Pair>> adj, Stack<Integer> stack, boolean[] visited){
	    visited[node]=true;
	    
	    for(int i=0; i<adj.get(node).size(); i++){
	        int v= adj.get(node).get(i).element;
	        if(!visited[v]){
	            topoSort(v, adj, stack, visited);
	        }
	    }
	    stack.push(node);
	}
}


class Pair{
    
    int element;
    int weight;
    
    Pair(int element, int weight){
        this.element=element;
        this.weight=weight;
    }
    
}