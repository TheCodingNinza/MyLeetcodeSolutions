import javax.sound.midi.Soundbank;
import java.util.*;

public class TopKFrequentWords {
    static Map<String, Integer> map;
    static Map<Integer, List<String>> anotherMap;
    public static List<String> topKFrequent(String[] words, int k) {
        map = new HashMap<>();
        anotherMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            List<String> tmp;
            if(anotherMap.containsKey(entry.getValue())){
                tmp = anotherMap.get(entry.getValue());
            }else{
                tmp = new ArrayList<>();
            }
            tmp.add(entry.getKey());
            anotherMap.put(entry.getValue(), tmp);
        }

        Map<Integer, List<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(anotherMap);

        List<String> ans = new ArrayList<>();
        int count = 0;
        for (Map.Entry<Integer, List<String>> entry: sortedMap.entrySet()){
            List<String> tmp = entry.getValue();
            Collections.sort(tmp);
            for (int i = 0; i < tmp.size(); i++) {
                ans.add(tmp.get(i));
                count++;
                if(count == k){
                    break;
                }
            }
            if(count == k){
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> ans = topKFrequent(words,k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+"\t");
        }
        System.out.println("");
    }
}
