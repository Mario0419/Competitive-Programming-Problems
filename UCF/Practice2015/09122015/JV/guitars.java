import java.util.*;

public class guitars{


	guitars(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 1; cse <= T; cse++){
			int N = input.nextInt();
			int M = input.nextInt();
			DisjointSet dj = new DisjointSet(N);

			ArrayList<Edge> elist = new ArrayList<Edge>();

			for(int i = 0; i < M; i++){
				int s = input.nextInt();
				int f = input.nextInt();
				int w = input.nextInt();
				elist.add(new Edge(s-1, f-1, w));

			}

			Collections.sort(elist);

			int countEdges = 0;
			int countMoney = 0;

			while(countEdges < N-1 && !elist.isEmpty()){
				Edge e = elist.remove(0);

				int ps = dj.find(e.s);
				int pf = dj.find(e.f);

				if(ps == pf)
					continue;
				else{
					dj.union(e.s, e.f);
					countEdges++;
					countMoney += e.weight;
				}
			}

			if(countEdges== N - 1)
				System.out.println(countMoney);
			else
				System.out.println("-1");

		}
	}

	public static void main(String[] args){
		new guitars();
	}
}

class DisjointSet{

	int[] p;
	DisjointSet(int N){
		p = new int[N];
		for(int i = 0; i < N; i++)
			p[i] = i;
	}

	int find(int N){
		return N == p[N] ? N : find(p[N]);
	}

	void union(int s, int f){

		int ps = find(s);

		while(f != p[f]){
			int of = p[f];
			p[f] = ps;
			f = of;
		}
		p[f] = ps;

		while(s != p[s])
		{
			int os = p[s];
			p[s] = ps;
			s = os;
		}
		p[s] = ps;
	}


}

class Edge implements Comparable<Edge>{
	int s;
	int f;
	int weight;
	Edge(int s, int f, int weight){
		this.s = s;
		this.f = f;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge other){
		return this.weight - other.weight;
	}
}

/*
3
5 10
1 2 88
1 3 37
1 4 73
1 5 58
2 3 59
2 4 0
2 5 98
3 4 0
3 5 85
4 5 82
3 3
1 2 6
1 3 4
2 3 1
3 1
1 3 56




*/