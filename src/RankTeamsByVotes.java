import java.util.*;

public class RankTeamsByVotes {

    public static class Node{
        char value;
        int[] position;

        public Node(char value) {
            this.value = value;
            this.position = new int[26];
        }
    }

    public static class CustomComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            for (int i = 0; i < o1.position.length; i++) {
                if(o1.position[i]!=o2.position[i]){
                    return o2.position[i] - o1.position[i];
                }
            }
            return o2.value-o1.value;
        }
    }
    public static String rankTeams(String[] votes) {
        Set<Character> setOFChars = new HashSet<>();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length(); j++) {
                setOFChars.add(votes[i].charAt(j));
            }
        }
        HashMap<Character, Node> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length(); j++) {
                if(map.containsKey(votes[i].charAt(j))){
                    Node itr = map.get(votes[i].charAt(j));
                    itr.position[j]++;
                }else{
                    Node itr = new Node(votes[i].charAt(j));
                    itr.position[j]++;
                    map.put(votes[i].charAt(j),itr);
                }
            }
        }
        ArrayList<Node> arr = new ArrayList<>();
        for (Map.Entry<Character, Node> entry: map.entrySet()){
            arr.add(entry.getValue());
        }

        Collections.sort(arr, new CustomComparator());
//        System.out.println("Size : " +arr.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i).value);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String[] votes  = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        System.out.println(rankTeams(votes));
    }
}
