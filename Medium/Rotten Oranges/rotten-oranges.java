//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        
        Queue<Tuple> q=new LinkedList<>();
        int cntFresh=0;
        int[][] visited= new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                
                if(grid[i][j]==2){
                    q.add(new Tuple(i,j,0));
                    visited[i][j]=2;
                }
                
                if(grid[i][j]==1) cntFresh++;
            }
        }
        
        int ans=0;
        int count=0;
        int[] delRow={0, -1, 0, 1};
        int[] delCol={-1, 0, 1, 0};
        
        while(!q.isEmpty()){
            
            Tuple t= q.remove();
            int row= t.row;
            int col= t.col;
            int time= t.time;
            ans=Math.max(time,ans);
            
            for(int i=0; i<4; i++){
                int adjRow= row+delRow[i];
                int adjCol= col+delCol[i];
                
                if(isValid(adjRow, adjCol, grid.length, grid[0].length)){
                    
                    if(grid[adjRow][adjCol]==1 && visited[adjRow][adjCol]==0){
                        
                        q.add(new Tuple(adjRow, adjCol, time+1));
                        visited[adjRow][adjCol]=2;
                        count++;
                    
                    }
                }
                
            }
        }
        if(count!=cntFresh) return -1;
        
        return ans;
    }
    
    public boolean isValid(int row, int col, int n, int m){
        
        if(row<0 || row>=n || col<0 || col>=m) return false;
        
        return true;
    }
}


class Tuple{
    
    int row;
    int col;
    int time;
    
    Tuple(int row, int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}