import java.util.*;

public class cables{

	cables(){
		Scanner input = new Scanner(System.in);

		while(true){
			int N = input.nextInt();
			if(N == 0) break;
			Vertex[] v = new Vertex[N];
			for(int i = 0; i < N; i++){
				v[i] = new Vertex(input.nextInt(), input.nextInt());
			}
			ArrayList<Edge> elist = new ArrayList<Edge>();
			for(int i = 0; i < N -1; i++){
				for(int j = i + 1; j < N; j++){
					elist.add(new Edge(i, j, v[i].distance(v[j])));
				}
			}
			Collections.sort(elist);
			double total = 0.0;
			int count = 0;
			DisjointSet dj = new DisjointSet(N);
			while(count < N -1){

				Edge t = elist.get(0);
				elist.remove(0);
				if(dj.find(t.s) == dj.find(t.f))
					continue;
				dj.union(t.s, t.f);
				total += t.distance;
				count++;
			}

			System.out.printf("%.2f\n", total);
		}
	}
	public static void main(String[] args){
		new cables();
	}
}

class Edge implements Comparable<Edge>{
	int s;
	int f;
	double distance;
	Edge(int s, int f, double distance){
		this.s = s;
		this.f = f;
		this.distance = distance;
	}

	@Override
	public int compareTo(Edge other){
		if(this.distance < other.distance){
			return -1;
		}else
			return 1;
	}
}

class Vertex{
	int x, y;
	Vertex(int x, int y){
		this.x = x;
		this.y = y;

	}
	double distance(Vertex other){
		return Math.sqrt(Math.pow(other.x-this.x,2) + Math.pow(other.y-this.y,2));
	}
}

class DisjointSet{
	int[] parent;
	DisjointSet(int N){
		parent = new int[N];
		for(int i = 0; i < N; i++)
			parent[i] = i;

	}

	int find(int N){
		return N == parent[N] ? N : find(parent[N]);
	}

	void union(int n1, int n2){
		int p1 = find(n1);

		while(n2 != parent[n2]){
			int temp = parent[n2];
			parent[n2] = p1;
			n2 = temp;
		}
		parent[n2] = p1;
	}
}