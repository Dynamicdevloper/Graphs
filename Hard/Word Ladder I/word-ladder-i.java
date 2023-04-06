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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord, 1));
        
        Set<String> set=new HashSet<>();
        for(int i=0; i<wordList.length; i++){
            set.add(wordList[i]);
        }
        
        set.remove(startWord);
        
        while(!q.isEmpty()){
            Pair p=q.remove();
            String str= p.str;
            int steps= p.steps;
            
            if(str.equals(targetWord)) return steps;
            
            for(int i=0; i<str.length(); i++){
                for(char j='a'; j<='z'; j++){
                    char[] ch= str.toCharArray();
                    ch[i]=j;
                    String newStr= new String(ch);
                    if(set.contains(newStr)){
                        q.add(new Pair(newStr, steps+1));
                        set.remove(newStr);
                    }
                }
            }
        }
        
        return 0;
    }
}

class Pair{
    int steps;
    String str;
    
    Pair(String str, int steps){
        this.str=str;
        this.steps=steps;
    }
}