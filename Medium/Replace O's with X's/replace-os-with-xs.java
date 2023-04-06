//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        
        vis=fillBoundaries(a, vis, n, m);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] =='X'){
                    q.add(new Pair(i,j));
                }
            }
        }
        
        int[] delRow={1,0,-1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row= p.row;
            int col= p.col;
            
            for(int i=0; i<4; i++){
                int adjRow=row+delRow[i];
                int adjCol=col+delCol[i];
                if(isValid(adjRow, adjCol, n, m)){
                    if(a[adjRow][adjCol]=='O' && vis[adjRow][adjCol]!=1){
                        a[adjRow][adjCol]='X';
                        q.add(new Pair(adjRow, adjCol));
                    }
                }
            }
        }
        return a;
    }
    
    public static boolean isValid(int row, int col, int n, int m){
        if(row<=0 || row>=n-1 || col<=0 || col>=m-1 ) return false;
        return true;
    }
    
    public static int[][] fillBoundaries(char[][] a, int[][] vis, int n, int m){
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0; i<n; i++){
            if(a[i][0]=='O'){
                q.add(new Pair(i,0));
            }
        }
        
        for(int i=0; i<n; i++){
            if(a[i][m-1]=='O'){
                q.add(new Pair(i,m-1));
            }
        }
        
        for(int i=0; i<m; i++){
            if(a[0][i]=='O'){
                q.add(new Pair(0,i));
            }
        }
        
        for(int i=0; i<m; i++){
            if(a[n-1][i]=='O'){
                q.add(new Pair(n-1,i));
            }
        }
        
        int[] delRow={1,0,-1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row= p.row;
            int col= p.col;
            
            for(int i=0; i<4; i++){
                int adjRow=row+delRow[i];
                int adjCol=col+delCol[i];
                if(isValid(adjRow, adjCol, n, m)){
                    if(a[adjRow][adjCol]=='O' && vis[adjRow][adjCol]!=1){
                        vis[adjRow][adjCol]=1;
                        q.add(new Pair(adjRow, adjCol));
                    }
                }
            }
        }
        return vis;
    }
}
class Pair{
    int row;
    int col;
    
    Pair(int row, int col){
        this.col=col;
        this.row=row;
    }
}













