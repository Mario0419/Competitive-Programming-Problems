import java.util.*;

public class relatives{
	relatives(){
		Scanner input = new Scanner(System.in);
		int cse = 1;
		while(true){
			int N = input.nextInt();
			int C = input.nextInt();
			if(N == 0 && C == 0) break;
			HashMap<String, Integer> map = new HashMap<>();
			int[][] adj = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					{
						Arrays.fill(adj[i], 100);
						adj[i][i] = 0;
					}
			int count = 0;
			for(int i = 0; i < C; i++){
				String s = input.next();
				String f = input.next();
				if(!map.containsKey(s)){
					map.put(s, count++);
				}
				if(!map.containsKey(f)){
					map.put(f, count++);
				}

				adj[map.get(s)][map.get(f)] = 1;
				adj[map.get(f)][map.get(s)] = 1;
			}

			floyd(adj);
		
			int ans = get(adj);
			if(ans == -1)
				System.out.println("Network " + (cse++) + ": DISCONNECTED");
			else
				System.out.println("Network " + (cse++) + ": " + ans);
			// System.out.println("Network " + (cse++) + ": " + get(adj));
			System.out.println();
		}
	}

	int get(int[][] adj){
		for(int i = 0; i < adj.length; i++)
			for(int j = 0; j < adj.length; j++)
				if(i != j && adj[i][j] == 100)
					return -1;

		int max = 0;

		for(int i = 0; i < adj.length; i++){
			for(int j = 0; j < adj.length; j++){
				if(max < adj[i][j] && adj[i][j] != 100)
					max = adj[i][j];
			}
		}

		return max;

	}

	void floyd(int[][] adj){
		for(int k = 0; k < adj.length; k++)
			for(int i = 0; i < adj.length; i++)
				for(int j = 0; j < adj.length; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
	}
	public static void main(String[] args){
		new relatives();
	}
}

/*


4 4
Ashok Kiyoshi Ursala Chun Ursala Kiyoshi Kiyoshi Chun
4 2
Ashok Chun Ursala Kiyoshi
6 5
Bubba Cooter Ashok Kiyoshi Ursala Chun Ursala Kiyoshi Kiyoshi Chun
0 0 


*/