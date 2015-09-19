import java.util.*;

public class crosswords{
	crosswords(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int N = input.nextInt();
			int M = input.nextInt();

			String[] grid = new String[N];

			for(int i = 0; i < N; i++)
				grid[i] = input.next();

			ArrayList<Cell> list = new ArrayList<Cell>();
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(grid[i].charAt(j) == '.'){
						//check it out
						if(horizontal(grid, i, j, M, N) || vertical(grid, i, j, M, N))
							list.add(new Cell(i + 1, j + 1));
					}
				}
			}

			System.out.println(list.size());
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i).x + " " + list.get(i).y);
			}

		}
	}

	boolean horizontal(String[] grid, int i, int j, int M, int N){
		if((!inBounds(i, j-1, M, N)||(inBounds(i, j-1, M, N) && grid[i].charAt(j-1) == '#')) && inBounds(i, j + 1, M, N) && inBounds(i, j + 2, M, N)){
			if(grid[i].charAt(j+1) == '.' && grid[i].charAt(j+2) == '.')
				return true;
		}



		return false;
	}

	boolean vertical(String[] grid, int i, int j, int M, int N){
		if((!inBounds(i-1, j, M, N)||(inBounds(i-1, j, M, N) && grid[i-1].charAt(j) == '#')) && inBounds(i + 1, j, M, N) && inBounds(i + 2, j, M, N)){
			if(grid[i+1].charAt(j) == '.' && grid[i+2].charAt(j) == '.')
				return true;
		}

		return false;
	}

	boolean inBounds(int i, int j, int M, int N){
		if(i < 0 || i >= N || j < 0 || j >= M){
			return false;
		}

		return true;
	}
	public static void main(String[] args){
		new crosswords();
	}
}

class Cell{
	int x;
	int y;
	Cell(int x, int y){
		this.x = x;
		this.y = y;
	}
}

/*

2
5 3
...
#..
...
..#
.##
4 4
....
.#..
...#
..##








*/