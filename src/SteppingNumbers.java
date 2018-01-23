import java.util.ArrayList;
import java.util.Arrays;

public class SteppingNumbers {
	public int[] stepnum(int A, int B) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<=9;i++){
            dfs(list,A,B,i);
        }
        int n = list.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
        	ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
    public void dfs(ArrayList<Integer> list, int A, int B, int num){
        if(num<=B && num>=A){
            list.add(num);
        }
        if(num==0 || num>B){
            return;
        }
        int lastDigit = num%10;
        int num1 = num*10 + (lastDigit-1);
        int num2 = num*10 + (lastDigit+1);
        if(lastDigit==0){
            dfs(list,A,B,num2);
        }
        else if(lastDigit==9){
            dfs(list,A,B,num1);
        }
        else{
            dfs(list,A,B,num1);
            dfs(list,A,B,num2);
        }
    }
}
