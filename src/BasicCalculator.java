import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        Stack<String> stk = new Stack<>();
        List<String> operandsAndOperations;
        String input = "("+s+")";
        int ans = 0;
        String inputInteger = "";
        for (int i = 0; i < input.length(); i++) {
            String currentString = input.substring(i,i+1);
            if(currentString.equals("0") || currentString.equals("1") || currentString.equals("2") || currentString.equals("3") || currentString.equals("4") || currentString.equals("5") || currentString.equals("6") || currentString.equals("7") || currentString.equals("8") || currentString.equals("9") ){
                inputInteger = inputInteger+ currentString;
            }else if(currentString.equals("+") || currentString.equals("-") || currentString.equals("*") || currentString.equals("/") ){

                if(inputInteger.equals("") && currentString.equals("-")){
                    stk.push("-");
                } else if (inputInteger.equals("")) {
                    stk.push(currentString);
                }else if(!inputInteger.equals("")){
                    stk.push(inputInteger);
                    stk.push(currentString);
                    inputInteger = "";
                }
            }else if(currentString.equals(")")){
                if(!inputInteger.equals("")){
                    stk.push(inputInteger);
                    inputInteger = "";
                }
                operandsAndOperations = new ArrayList<>();
                while (!stk.peek().equals("(")){
                    operandsAndOperations.add(stk.pop());
                }
                List<String> operandsInOrder = new ArrayList<>();
                for (int j = operandsAndOperations.size()-1; j >= 0; j--) {
                    operandsInOrder.add(operandsAndOperations.get(j));
                }
                stk.pop();
                int res = doMaths(operandsInOrder);
                if(!stk.empty()){
                    stk.push(String.valueOf(res));
                }else{
                    ans = res;
                    break;
                }
            } else if (currentString.equals("(")) {
                stk.push("(");
            }
        }
        return ans;
    }

    private static int doMaths(List<String> operandsAndOperations) {
        int flag = 0;
        for (int i = 0; i < operandsAndOperations.size(); i++) {
            if(operandsAndOperations.get(i).equals("/") || operandsAndOperations.get(i).equals("*")){
                int a = Integer.parseInt(operandsAndOperations.get(i-1));
                int b = Integer.parseInt(operandsAndOperations.get(i+1));
                int res;
                if(operandsAndOperations.get(i).equals("/")){
                    res = a/b;
                }else{
                    res = a*b;
                }
                flag = 1;
                operandsAndOperations.remove(i-1);
                operandsAndOperations.remove(i-1);
                operandsAndOperations.remove(i-1);
                operandsAndOperations.add(i-1,String.valueOf(res));
                i--;
            }
        }
        for (int i = 0; i < operandsAndOperations.size(); i++) {
            if(operandsAndOperations.get(i).equals("+") || operandsAndOperations.get(i).equals("-")){
                if(operandsAndOperations.get(i).equals("-") && i == 0){
                    operandsAndOperations.remove(0);
                    String index0 = operandsAndOperations.get(0);
                    operandsAndOperations.remove(0);
                    operandsAndOperations.add(0,"-"+index0);
                    continue;
                }
                int a = Integer.parseInt(operandsAndOperations.get(i-1));
                int b = Integer.parseInt(operandsAndOperations.get(i+1));
                int res;
                if(operandsAndOperations.get(i).equals("+")){
                    res = a+b;
                }else{
                    res = a-b;
                }
                flag = 1;
                operandsAndOperations.remove(i-1);
                operandsAndOperations.remove(i-1);
                operandsAndOperations.remove(i-1);
                operandsAndOperations.add(i-1,String.valueOf(res));
                i--;
            }
        }
        if(flag == 1){
            return Integer.parseInt(operandsAndOperations.get(0));
        }else{
            String res = "";
            for (int i = 0; i < operandsAndOperations.size(); i++) {
                res = res+operandsAndOperations.get(i);
            }
            return Integer.parseInt(res);
        }

    }

    public static void main(String[] args) {
        String expression = "(-2)+3";
        System.out.println(calculate(expression));
    }
}
