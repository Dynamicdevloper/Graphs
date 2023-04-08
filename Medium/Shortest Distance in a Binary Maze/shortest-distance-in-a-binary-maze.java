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
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        
        if(source[0] == destination[0] && source[1]==destination[1]) return 0;
        
        int n= grid.length;
        int m= grid[0].length;
        Queue<Tuple> q=new LinkedList<>();
        int[][] dist=new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j]=(int)1e9;
            }
        }
        
        int[] delRow={0,1,0,-1};
        int[] delCol={1,0,-1,0};
        
        q.add(new Tuple(source[0], source[1], 0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int row= t.row;
            int col= t.col;
            int distance=t.dist;
            
            for(int i=0; i<4; i++){
                int adjRow=row+delRow[i];
                int adjCol= col+delCol[i];
                
                if(isValid(adjRow, adjCol, n, m)){
                    if(grid[adjRow][adjCol]==1 && distance+1 <dist[adjRow][adjCol]){
                        if(adjRow==destination[0] && adjCol==destination[1]) return distance+1;
                        dist[adjRow][adjCol]=distance+1;
                        q.add(new Tuple(adjRow, adjCol, distance+1));
                    }
                }
            }
            
        }
        
        return -1;
    }
    
    public boolean isValid(int row, int col, int n, int m){
        
        if(row<0 || row>=n || col<0 || col>=m) return false;
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


















