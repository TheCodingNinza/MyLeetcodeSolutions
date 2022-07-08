import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length()-2; i++) {
            String firstBlock = s.substring(0,i);
            if(String.valueOf(Integer.parseInt(firstBlock)).length() != firstBlock.length())
                continue;
            if(Integer.parseInt(firstBlock)>255)
                continue;
            for (int j = i+1; j < s.length()-1; j++) {
                String secondBlock = s.substring(i,j);
                if(String.valueOf(Integer.parseInt(secondBlock)).length() != secondBlock.length())
                    continue;
                if(Integer.parseInt(secondBlock)>255)
                    continue;
                for (int k = j+1; k < s.length(); k++) {
                    String thirdBlock = s.substring(j,k);
                    String fourthBlock = s.substring(k);
//                    System.out.println("firstBlock : "+firstBlock);
//                    System.out.println("secondBlock : "+secondBlock);
//                    System.out.println("thirdBlock : "+thirdBlock);
//                    System.out.println("fourthBlock : "+fourthBlock);
                    if(String.valueOf(Integer.parseInt(thirdBlock)).length() != thirdBlock.length())
                        continue;
                    if(Integer.parseInt(thirdBlock)>255)
                        continue;
                    if(String.valueOf(Integer.parseInt(fourthBlock)).length() != fourthBlock.length())
                        continue;
                    if(Integer.parseInt(fourthBlock)>255)
                        continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(firstBlock);
                    sb.append('.');
                    sb.append(secondBlock);
                    sb.append('.');
                    sb.append(thirdBlock);
                    sb.append('.');
                    sb.append(fourthBlock);
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans;
        ans = restoreIpAddresses("1231231231234");
        System.out.println("======================");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
