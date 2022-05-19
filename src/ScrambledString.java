import javax.sound.midi.Soundbank;

public class ScrambledString {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "aterg";
        if(s1.length() != s2.length()){
            System.out.println("False");
            return;
        }
        System.out.println(isScrambled(s1,s2));
    }

    public static boolean isScrambled(String s1,String s2){
        System.out.println("s1 is "+s1+" s2 is "+s2);
        if(s1.length() == 1){
            if(s1.equals(s2)){
                return true;
            }else{
                return false;
            }
        }
        if(s1.equals(s2)) return true;
        for(int k=1;k<s1.length()-1;k++){
            int laterIndex = s1.length()-k;
            if(isScrambled(s1.substring(0,k),s2.substring(laterIndex)) && isScrambled(s1.substring(k),s2.substring(0,laterIndex))){
                return true;
            }else if(isScrambled(s1.substring(0,k),s2.substring(0,k)) && isScrambled(s1.substring(k),s2.substring(k))){
                return true;
            }
        }
        return false;
    }
}
