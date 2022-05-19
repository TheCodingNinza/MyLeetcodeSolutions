import java.util.*;

public class Test {
    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int src){
        System.out.println("Value of src : "+src);
        int count = 0;
        if(src == 3)
            return;
        else{
            count++;
            dfs(src+1);
        }
        System.out.println("Value of count : "+count);
    }

}
