import java.util.*;

public class Solution {

    public static int[] parent;

    public static int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }

    public static void union(int node1, int node2) {
        parent[find(node1)] = find(node2);
    }

    public boolean equationsPossible(String[] equations) {

        parent = new int[26];
        for(int i=0; i < 26; i++) parent[i] = i;

        for(String edge: equations) if(edge.charAt(1) == '=') union(edge.charAt(0) - 'a', edge.charAt(3) - 'a');
        for(String edge: equations) if(edge.charAt(1) == '!') if(find(edge.charAt(0) - 'a') == find(edge.charAt(3) - 'a')) return false;

        return true;
    }

}
