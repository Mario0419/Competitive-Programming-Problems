
import java.util.*;


public class airways{
	airways(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int N = input.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<String, Integer> numTop = new HashMap<>();
			int flightNum = 0;

			ArrayList<Edge> elst = new ArrayList<Edge>();
			ArrayList<Integer> queue = new ArrayList<Integer>();
			ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();

			for(int i = 0; i < N; i++){
				String s = input.next();
				String f = input.next();
				int flight = input.nextInt();

				if(!map.containsKey(s)){
					map.put(s, flightNum++);
					adj.add(new ArrayList<Edge>());
				}
				if(!map.containsKey(f)){
					map.put(f, flightNum++);
					adj.add(new ArrayList<Edge>());
				}

				if(!numTop.containsKey(s)){
					numTop.put(s, 0);
				}
				if(!numTop.containsKey(f)){
					numTop.put(f, 1);
				}else{
					int te = numTop.get(f);
					numTop.put(f, te + 1);
				}
				elst.add(new Edge(map.get(s), map.get(s), flight));
				adj.get(map.get(s)).add(elst.get(elst.size() - 1));

			}

			for(int i = 0; i < adj.size(); i++)
				Collections.sort(adj.get(i));
			
			for(String key : numTop.keySet()){
				if(numTop.get(key) == 0)
					queue.add(map.get(key));
			}

			ArrayList<Edge> q = new ArrayList<Edge>();
			for(int i = 0; i < queue.size(); i++){
				int pos = queue.get(i);
				for(int j = 0; j < adj.get(pos).size(); j++){
					q.add(adj.get(pos).get(j));
				}
			}
			ArrayList<Edge> answer = new ArrayList<Edge>();
			Collections.sort(q);
			while(!q.isEmpty()){
				
				Edge pop = q.remove(0);
			}

		}
	}

	public static void main(String[] args){
		new airways();
	}
}

class Edge implements Comparable<Edge>{
	int s;
	int f;
	int flight;
	Edge(int s, int f, int flight){
		this.s = s;
		this.f = f;
		this.flight = flight;
	}

	@Override
	public int compareTo(Edge other){
		return other.flight-this.flight;
	}
}