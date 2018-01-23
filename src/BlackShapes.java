
public class BlackShapes {
	boolean[][] ans;
    int count = 0;
    int row[] = new int[]{1,-1,0,0};
    int col[] = new int[]{0,0,1,-1};
    String[] A;
	public int black(String[] A) {
	    if(A.length==0){
	        return count;
	    }
	    int m = A.length;
	    int n = A[0].length();
	    ans = new boolean[A.length][A[0].length()];
	    this.A = A;
	    for(int i=0;i<A.length;i++){
	        for(int j=0;j<A[i].length();j++){
	            if(ans[i][j] == false && A[i].charAt(j)=='X'){
	                dfs(i,j,m,n);
	                count++;
	            }
	        }
	    }
	    return count;
	}
	public void dfs(int i, int j, int m, int n){
	    ans[i][j] = true;
	    for(int k=0;k<4;k++){
	        int i1 = i+row[k];
	        int j1 = j+col[k];
	        if(isValid(i1,j1,m,n) && !ans[i1][j1]){
	            dfs(i1,j1,m,n);
	        }
	    }
	}
	public boolean isValid(int i, int j, int m , int n){
	    if(i<0 || i>=m || j<0 || j>=n){
	        return false;
	    }  
	    if(A[i].charAt(j)!='X'){
	        return false;
	    }
	    return true;
	}
}
