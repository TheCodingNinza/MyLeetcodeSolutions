import java.util.HashMap;
import java.util.Map;

public class VowelsOfAllSubstrings {
    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static Map<String,Node> dp = new HashMap<>();
    public static void main(String[] args) {
        String s = "noosabasboosa";
        int ans = solve(s,0,s.length()-1);
        System.out.println("The answer is : "+ans);
    }

    public static int solve(String s, int start, int end){
        System.out.println("Substring is "+s);
        System.out.println("Start "+start+" and end "+end);
        if(dp.containsKey(s)){
            System.out.println("here");
            if(dp.get(s).start == start && dp.get(s).end == end){
                return 0;
            }
        }
        if(start == end){
            if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u'){
                dp.put(s,new Node(start,end));
                return 1;
            }else{
                return 0;
            }
        }
        int ans = 0;
        for (int k = 1; k < s.length(); k++) {
            System.out.println("In loop");
            int solve1 = 0;
            int solve2 = 0;
            if(dp.containsKey(s.substring(0,k))){
                System.out.println("here");
                if(dp.get(s.substring(0,k)).start == start && dp.get(s.substring(0,k)).end == start+k-1){
                    solve1 = 0;
                }else{
                    solve1 = solve(s.substring(0,k),start,start+k-1);
                }
            }else{
                solve1 = solve(s.substring(0,k),start,start+k-1);
            }
            if(dp.containsKey(s.substring(k))){
                System.out.println("here");
                if(dp.get(s.substring(k)).start == start+k && dp.get(s.substring(k)).end == end){
                    solve2= 0;
                }else{
                    solve2 = solve(s.substring(k),start+k,end);
                }
            }else{
                solve2 = solve(s.substring(k),start+k,end);
            }
             ans += solve1+solve2;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                count+=1;
            }
        }
        ans += count;
        dp.put(s,new Node(start,end));
        return ans;
    }
}
