import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class CaptureRegions {
	public void solve(ArrayList<ArrayList<Character>> a) {
	    if(a==null || a.size()==0 || a.get(0).size()==0){
	        return;
	    }
	    int m = a.size();
	    int n = a.get(0).size();
	    for(int j=0;j<n;j++){
	        if(a.get(0).get(j)=='O'){
	            bfs(a,0,j);
	        }
	    }
	    for(int i=0;i<m;i++){
	        if(a.get(i).get(n-1)=='O'){
	            bfs(a,i,n-1);
	        }
	    }
	    for(int j=0;j<n;j++){
	        if(a.get(m-1).get(j)=='O'){
	            bfs(a,m-1,j);
	        }
	    }
	    for(int i=0;i<m;i++){
	        if(a.get(i).get(0)=='O'){
	            bfs(a,i,0);
	        }
	    }
	    for (int i=0; i<m;i++) {
	        for (int j=0;j<n;j++) {
	            if (a.get(i).get(j)=='O') {
	                a.get(i).set(j,'X');
	            } else if (a.get(i).get(j)=='#') {
	                a.get(i).set(j,'O');
	            }
	        }
	    }
	}
	private void bfs(ArrayList<ArrayList<Character>> a, int row, int col) {
	    int m = a.size();
	    int n = a.get(0).size();

	    int index = row*n + col;
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(index);
	    a.get(row).set(col,'#');

	    while (!queue.isEmpty()) {
	        index = queue.remove();
	        int r = index/n;
	        int c = index%n;

	        if (r>0 && a.get(r-1).get(c)=='O') {
	            a.get(r-1).set(c,'#');
	            queue.add((r-1)*n + c);
	        }
	        if (c<n-1 && a.get(r).get(c+1)=='O') {
	            a.get(r).set(c+1,'#');
	            queue.add(r*n + (c+1));
	        }
	        if (r<m-1 && a.get(r+1).get(c)=='O') {
	            a.get(r+1).set(c,'#');
	            queue.add((r+1)*n + c);
	        }
	        if (c>0 && a.get(r).get(c-1)=='O') {
	            a.get(r).set(c-1,'#');
	            queue.add(r*n + (c-1));
	        }
	    }
	}
}
