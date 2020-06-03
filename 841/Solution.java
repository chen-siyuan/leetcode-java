class Solution {
	
	public static int n;
	public static ArrayList<Integer>[] al;
	public static boolean[] searched;
	public static boolean answer;
	
	public static void constructGraph(List<List<Integer>> rooms) {
		
		n = 0;
		al = new ArrayList[rooms.size()];
		
		for(List<Integer> room: rooms) al[n++] = new ArrayList<>(room);
	
	}

	public static void BFS() {

		Queue<Integer> queue = new LinkedList<Integer>();
		searched = new boolean[n];

		queue.offer(0);

		while(queue.size() != 0) {

			int curr = queue.poll();
			
			if(searched[curr]) continue;
			searched[curr] = true;

			for(int neighbor: al[curr]) if(!searched[neighbor]) queue.offer(neighbor);		

		}
		
		answer = true;
		for(int i=0; i < n; i++) if(!searched[i]) answer = false;

	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		
		constructGraph(rooms);
		BFS();

		return answer;		
	}

}
