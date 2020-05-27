import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Solution {

    public List<String> wordBreak(String string, List<String> components) {

        int n = string.length();

        ArrayList<ArrayList<Integer>>[] dp = new ArrayList[n + 1];

        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());

        for(int i=1; i < n + 1; i++) {

            dp[i] = new ArrayList<>();

            int count = 0;

            for(String component: components) {

                int l = component.length();

                if(i - l >= 0 && component.equals(string.substring(i - l, i)))
                    for(ArrayList<Integer> list: dp[i - l]) {

                        ArrayList<Integer> temp = new ArrayList<>(list);
                        temp.add(count);

                        dp[i].add(temp);

                    }

                count++;

            }

        }

        ArrayList<String> answer = new ArrayList<>();

        for(ArrayList<Integer> list: dp[n]) {

            StringJoiner sj = new StringJoiner(" ");

            for(int index: list) sj.add(components.get(index));

            answer.add(sj.toString());

        }

        return answer;
    }

    public static void main(String[] args) {

        String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        ArrayList<String> components =
                new ArrayList<>(Arrays.asList(
                        "a",
                        "aa",
                        "aaa",
                        "aaaa",
                        "aaaaa",
                        "aaaaaa",
                        "aaaaaaa",
                        "aaaaaaaa",
                        "aaaaaaaaa",
                        "aaaaaaaaaa"));

//        String string = "catsandog";
//        ArrayList<String> components =
//                new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        Solution solution = new Solution();

        System.out.println(solution.wordBreak(string, components).size());

    }

}