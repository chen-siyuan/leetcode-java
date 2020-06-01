import java.util.*;

public class Main {

    public static int n;
    public static HashMap<String, Integer> strToInt;
    public static ArrayList<Neighbor>[] al;
    
    public static void translate(List<List<String>> pairs) {
        
        HashSet<String> strs = new HashSet<>();

        for(List<String> pair: pairs) strs.addAll(pair);
        
        n = 0;
        strToInt = new HashMap<>();

        for(String str: strs) strToInt.put(str, n++);
        
    }
    
    public static void constructGraph(List<List<String>> edges, double[] values) {
        
        al = new ArrayList[n];
        for(int i=0; i < n; i++) al[i] = new ArrayList<>();
        
        int count = 0;
        
        for(List<String> edge: edges) {
            
            al[strToInt.get(edge.get(0))].add(
                new Neighbor(strToInt.get(edge.get(1)), values[count]));
            
            al[strToInt.get(edge.get(1))].add(
                new Neighbor(strToInt.get(edge.get(0)), 1. / values[count++]));
            
        }
        
    }
    
    public static double BFS(String s0, String s1) {
        
        if(!strToInt.containsKey(s0) || !strToInt.containsKey(s1)) return -1.;
        
        Queue<Neighbor> queue = new LinkedList<Neighbor>();
        HashSet<Integer> searched = new HashSet<>();
        
        queue.offer(new Neighbor(strToInt.get(s0), 1.));
        
        while(queue.size() != 0) {
            
            Neighbor curr = queue.poll();
            
            if(searched.contains(curr.getNode())) continue;
            searched.add(curr.getNode());
            
            if(curr.getNode() == strToInt.get(s1)) return curr.getVal();
            
            for(Neighbor neighbor: al[curr.getNode()])
                if(!searched.contains(neighbor.getNode()))
                    queue.offer(new Neighbor(
                        neighbor.getNode(),
                        curr.getVal() * neighbor.getVal()));
            
        }
        
        return -1.;
    }
    
    public static double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        
        translate(equations);
        constructGraph(equations, values);
        
        double[] answer = new double[queries.size()];
        int count = 0;
        
        for(List<String> query: queries)
            answer[count++] = BFS(query.get(0), query.get(1));
        
        return answer;
    }
   
    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();

        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] answers = calcEquation(equations, values, queries);

        System.out.println(Arrays.toString(answers));

    }

 
}

class Neighbor {
    
    private final int node;
    private final double val;
    
    public Neighbor(int node, double val) {
        this.node = node;
        this.val = val;
    }
    
    public int getNode() {
        return node;
    }
    
    public double getVal() {
        return val;
    }
    
}
