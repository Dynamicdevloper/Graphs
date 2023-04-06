//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        // Your code here
        
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis= grid;
        Queue<Pair> q=new LinkedList<>();
        for(int row=0; row<n; row++){
            if(grid[row][0]==1){
                vis[row][0]=0;
                q.add(new Pair(row, 0));
            }
        }
        for(int row=0; row<n; row++){
            if(grid[row][m-1]==1){
                vis[row][m-1]=0;
                q.add(new Pair(row, m-1));
            }
        }
        for(int col=0; col<m; col++){
            if(grid[0][col]==1){
                vis[0][col]=0;
                q.add(new Pair(0, col));
            }
        }
        for(int col=0; col<m; col++){
            if(grid[n-1][col]==1){
                vis[n-1][col]=0;
                q.add(new Pair(n-1, col));
            }
        }
        int[] delRow={0,-1,0,1};
        int[] delCol={1,0,-1,0};
        while(!q.isEmpty()){
            Pair p= q.poll();
            int row=p.row;
            int col=p.col;
            vis[row][col]=0;
            for(int i=0; i<4; i++){
                int adjRow=delRow[i]+row;
                int adjCol=delCol[i]+col;
                
                if(isValid(adjRow, adjCol, n, m)){
                    if(grid[adjRow][adjCol]==1 && vis[adjRow][adjCol]!=0){
                        vis[adjRow][adjCol]=0;
                        q.add(new Pair(adjRow, adjCol));
                    }
                }
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                if(vis[i][j]==1)
                    count++;
        }
        
        return count;
    }
    public boolean isValid(int row, int col, int n, int m){
        if(row<0 || row>=n || col<0 || col>=m) return false;
        
        return true;
    }
}

class Pair{
    int row;
    int col;
    
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}








