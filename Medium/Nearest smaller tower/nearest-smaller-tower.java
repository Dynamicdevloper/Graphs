//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int value;
    int index;
    
    Pair(int value, int index){
        this.value=value;
        this.index=index;
    }
}

class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int n=arr.length;
		Pair[] left=new Pair[n];
		Pair[] right=new Pair[n];
		int[] output=new int[n];
		left=nearestSmallestLeft(arr, n);
		right=nearestSmallestRight(arr, n);
		
		for(int i=0; i<n; i++){
		    
		    int leftIndex=left[i].index;
		    int rightIndex=right[i].index;
		    int leftValue=left[i].value;
		    int rightValue=right[i].value;
		    
		    
		    if(left[i].index==-1 && right[i].index==-1){
		        
		        output[i]=-1;
		        
		    }else if(left[i].index==-1){
		        
		        output[i]=right[i].index;
		    
		    }else if(right[i].index==-1){
		        
		        output[i]=left[i].index;
		        
		    }else if(Math.abs(leftIndex-i) < Math.abs(rightIndex-i) ){
		        output[i]=leftIndex;
		    }else if(Math.abs(leftIndex-i) > Math.abs(rightIndex-i) ){
		        output[i]=rightIndex;
		    }else{
		        if(leftValue<rightValue){
		             output[i]=leftIndex;
		        }else{
		             output[i]=rightIndex;
		        }
		    }
		}
		
		return output;
 	}
 	
 	
 	Pair [] nearestSmallestLeft(int[] arr, int n){
 	    
 	    Stack<Pair> stack= new Stack<>();
 	    Pair[] output=new Pair[n];
 	    for(int i=n-1; i>=0; i--){
 	        if(stack.isEmpty()){
 	            output[i]=new Pair(i,-1);
 	        }else if(!stack.isEmpty() && stack.peek().value >= arr[i]){
 	            while(!stack.isEmpty() && stack.peek().value>=arr[i]){
 	                stack.pop();
 	            }
 	            
 	            if(stack.isEmpty()){
 	                output[i]=new Pair(i,-1);
 	            }else{
 	                output[i]=new Pair(stack.peek().value,stack.peek().index);
 	            }
 	        }else{
 	            output[i]=new Pair(stack.peek().value,stack.peek().index);
 	        }
 	        stack.push(new Pair(arr[i], i));
 	    }
 	    return output;
 	}
 	
 	
 	 	Pair [] nearestSmallestRight(int[] arr, int n){
 	    
 	    Stack<Pair> stack= new Stack<>();
 	    Pair[] output=new Pair[n];
 	    for(int i=0; i<n; i++){
 	        if(stack.isEmpty()){
 	            output[i]=new Pair(i,-1);
 	        }else if(!stack.isEmpty() && stack.peek().value >= arr[i]){
 	            while(!stack.isEmpty() && stack.peek().value>=arr[i]){
 	                stack.pop();
 	            }
 	            
 	            if(stack.isEmpty()){
 	                output[i]=new Pair(i,-1);
 	            }else{
 	                output[i]=new Pair(stack.peek().value,stack.peek().index);
 	            }
 	        }else{
 	            output[i]=new Pair(stack.peek().value,stack.peek().index);
 	        }
 	        stack.push(new Pair(arr[i], i));
 	    }
 	    return output;
 	}
}