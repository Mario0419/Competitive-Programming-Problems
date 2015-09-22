import java.util.*;

public class robot{
	robot(){
		Scanner input = new Scanner(System.in);

		while(true){
			int N = input.nextInt();
			if(N == 0) break;

			ArrayList<Target> targets = new ArrayList<Target>();
			targets.add(new Target(0.0, 0.0, 0.0));
			for(int i = 0; i < N; i++)
				targets.add(new Target(input.nextDouble(), input.nextDouble(), input.nextDouble()));

			targets.add(new Target(100.0, 100.0, 0));

			Target curr = new Target(0.0, 0.0, 0.0);

			int i = 0;
			double[][] grid = new double[N+2][N+2];
			for(i = 0; i < N + 2; i++)
				Arrays.fill(grid[i], 0.0);
			double total = 0.0;
			i = 0;
			while(i <= N+1){

				double min = 0.0;
				int minTarget = i + 1;
				double buildUp = 0.0;
				for(int j = i+1; j <= N+1; j++){
					//we can choose to take next path
					// double takePath = curr.distance(targets.get(j)) + 1.0 + buildUp;
					double takePath = distance(targets.get(i), targets.get(j)) + 1.0 + buildUp;
					//we can choose to skip
					buildUp += targets.get(j).P;
					grid[i][j] = takePath;
				}
				i++;
			}


			int source = 0;
			int sink = N + 1;
			double ans = dijkstra(grid, 0, N+1);
			System.out.printf("%.3f\n", ans);

		}
	}

	double dijkstra(double[][] grid, int source, int sink){
		double[] shortest = new double[grid.length];
		boolean[] used = new boolean[grid.length];
		Arrays.fill(shortest, Double.MAX_VALUE);
		Arrays.fill(used, false);

		shortest[source] = 0;

		for(int i = 0; i < grid.length-1; i++){
			int v = 0;
			double min = Double.MAX_VALUE;
			for(int j = 0; j < grid.length; j++){
				if(!used[j] && shortest[j] < min){
					min = shortest[j];
					v = j;
				}
			}
			used[v] = true;

			for(int j = 0; j < grid.length; j++){
				if(grid[v][j] == 0.0)
					continue;
				if(shortest[v] + grid[v][j] < shortest[j]){
					shortest[j] = shortest[v] + grid[v][j];
				}
			}
		}

		return shortest[sink];
	}

	double distance(Target o, Target t){
		return Math.sqrt(Math.pow(o.x-t.x, 2) + Math.pow(o.y-t.y, 2));
	}

	public static void main(String[] args){
		new robot();
	}
}

	
class Target{
	double x;
	double y;
	double P;
	Target(double x, double y, double P){
		this.x = x;
		this.y = y;
		this.P = P;
	}

}

/*


1
50 50 20
3
30 30 90
60 60 80
10 90 100
3
30 30 90
60 60 80
10 90 10
1
0 100 200
0



*/