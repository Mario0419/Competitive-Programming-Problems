import java.util.*;

public class walking{
	walking(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 1; cse <= T; cse++){
			int N = input.nextInt();
			int[] heights = new int[N];
			for(int i = 0; i < N; i++)
				heights[i] = input.nextInt();

			int conn = input.nextInt();
			int[][] adj = new int[N][N];
			for(int i = 0; i < N; i++){
				Arrays.fill(adj[i], Integer.MAX_VALUE);
				adj[i][i] = 0;
			}

			for(int i = 0; i < conn; i++){
				String c1 = input.next();
				String c2 = input.next();
				int s = Integer.parseInt(c1.substring(1, c1.length()-1));
				int f = Integer.parseInt(c2.substring(0, c2.length()-1));
				s--;
				f--;
				adj[s][f] = Math.abs(heights[f] - heights[s]);
				adj[f][s] = Math.abs(heights[f]-heights[s]);
			}

			floyd(adj);

			N = input.nextInt();

			int[] loc = new int[N];
			for(int i = 0; i < N; i++)
				loc[i] = input.nextInt() - 1;
			int total = 0;
			int pos = loc[0];
			for(int i = 1; i < N; i++){
				total += adj[loc[i]][pos];
				pos = loc[i];
			}
			System.out.println("The least amount of work on trip " + cse + " is: " + total);
		}
	}

	void floyd(int[][] adj){


		for(int k = 0; k < adj.length; k++)
			for(int i = 0; i < adj.length; i++)
				for(int j = 0; j < adj.length; j++){
					if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE){
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
	}
	public static void main(String[] args){
		new walking();
	}
}

/*


1
4
30
45
20
55
4
(1, 3)
(2, 4)
(4, 1)
(3, 2)
4
1
2
3
4


*/