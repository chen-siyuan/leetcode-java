import java.util.*;

public class Solution {

    public int ladderLength(String start, String end, List<String> wordList) {
    
        Set<String> words = new HashSet<>(wordList);

        Set<String> searched = new HashSet<>();
        Map<String, Integer> record = new HashMap<>();
        record.put(start, 1);

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        
        while(queue.size() != 0) {
            
            String curr = queue.poll();
            int level = record.get(curr);

            if(searched.contains(curr)) continue;
            searched.add(curr);

            if(end.equals(curr)) return level;

            char[] charArray = curr.toCharArray();

            for(int i=0; i < charArray.length; i++) {
                
                char temp = charArray[i];

                for(int j=0; j < 26; j++) {
                    
                    charArray[i] = (char)(j + (int)'a');
                
                    String word = String.valueOf(charArray);

                    if(words.contains(word) && !searched.contains(word) && !record.containsKey(word)) {
                        record.put(word, level + 1);
                        queue.offer(word);
                    }
                
                }
            
                charArray[i] = temp;
            
            }
        
        }

        return 0;
    }

}
