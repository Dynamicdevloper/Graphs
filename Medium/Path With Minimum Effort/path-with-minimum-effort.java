//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)-> x.dist-y.dist);
        pq.add(new Tuple(0, 0, 0));
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j]=(int)1e9;
            }
        }
        
        dist[0][0]=0;
        int[] delRow={0,1,0,-1};
        int[] delCol={1,0,-1,0};
        
        while(!pq.isEmpty()){
            Tuple t= pq.poll();
            int row= t.row;
            int col=t.col;
            int diff=t.dist;
            
            if(row==n-1 && col==m-1) return diff;
            
            for(int i=0; i<4; i++){
                int adjRow= row+delRow[i];
                int adjCol= col+delCol[i];
                
                if(isValid(adjRow, adjCol, n, m)){
                    int effort= Math.abs(heights[row][col]-heights[adjRow][adjCol]);
                    int newEffort= Math.max(diff, effort);
                    if(newEffort<dist[adjRow][adjCol]){
                        dist[adjRow][adjCol]=newEffort;
                        pq.add(new Tuple(adjRow, adjCol, newEffort));
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean isValid(int row, int col, int n, int m){
        if(row<0 || col<0 || row>=n || col>=m) return false;
        return true;
    }
}


class Tuple{
    
    int row;
    int col;
    int dist;
    
    Tuple(int row, int col, int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}

























