import java.util.ArrayList;

public class SumofFibNumbers {
	public int fibsum(int A) {
        if(A<=2){
            return 1;
        }
        int a = 1;
        int b = 1 ;
        int c = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        while(true){
            c = a+b;
            if(c<=A){
                list.add(c);
            }
            else{
                break;
            }
            a = b;
            b = c;
        }
        int count = 0;
        int n = A;
        int i = list.size()-1;
        while(n>0){
            int num = list.get(i);
            if(n>=num){
                count = count+(n/num);
                n = n%num;
            }
            i--;
        }
        return count;
    }
}
