import javax.sound.midi.Soundbank;
import java.util.*;

public class MaximumCompatibilityScoreSum {

    public static Map<String, Integer> dp;
    public static int count = 0;

    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        dp = new HashMap();
        int answer = solveByRecursion(students,mentors,new HashSet(),new HashSet());
        return answer;
    }
    public static int solveByRecursion(int[][] students, int[][] mentors, HashSet<Integer> studentRow, HashSet<Integer> mentorRow){
        count++;
        if(studentRow.size() == students.length && mentorRow.size() == mentors.length)
            return 0;
        String s = studentRow.toString() + "_" + mentorRow.toString();
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < students.length; i++) {
            if(!studentRow.contains(i)){
                int perPairCompatibility = 0;
                int otherSubProblems = 0;
                for (int j = 0; j < mentors.length; j++) {
                    if(!mentorRow.contains(j)){
                        perPairCompatibility = computeCompatibility(students[i],mentors[j]);
                        HashSet<Integer> newStudentRow = new HashSet<>(studentRow);
                        HashSet<Integer> newMentorRow = new HashSet<>(mentorRow);
                        newStudentRow.add(i);
                        newMentorRow.add(j);
                        otherSubProblems = solveByRecursion(students,mentors,newStudentRow,newMentorRow);
                    }
                }
                if(ans < (perPairCompatibility + otherSubProblems))
                    ans = (perPairCompatibility + otherSubProblems);
            }

        }
        dp.put(s,ans);
        return ans;
    }

    private static int computeCompatibility(int[] student, int[] mentor) {
        int count = 0;
        for (int i = 0; i < student.length; i++) {
                if(student[i] == mentor[i])
                    count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] students = {{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentors = {{1,0,0},{0,0,1},{1,1,0}};
        System.out.println(maxCompatibilitySum(students,mentors));
        System.out.println("The total count : "+count);
    }
}
