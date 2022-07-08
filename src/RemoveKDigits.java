import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        int count = 0;
        stk.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            Character itr = stk.peek();
            if(itr <= num.charAt(i)){
                stk.push(num.charAt(i));
            }else{
                while ((count < k) && !stk.isEmpty() && (stk.peek() > num.charAt(i)) ){
                    stk.pop();
                    count++;
                }
                stk.push(num.charAt(i));
            }
        }
        Character[] arr = stk.toArray(stk.toArray(new Character[stk.size()]));
        char[] charArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            charArr[i] = arr[i];
        }
        String ans = String.copyValueOf(charArr,0,k-count+1);
        ans = removeZero(ans);
        if(ans.length() == 0){
            return "0";
        }else{
            return ans;
        }
    }

    private static String removeZero(String str)
    {
        int i = 0;

        while (i < str.length() && str.charAt(i) == '0')
            i++;

        StringBuffer sb = new StringBuffer(str);
        sb.replace(0, i, "");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("100",1));
    }
}
