import java.util.*;

//make a route class

public class cowroute2_2{

	cowroute2_2(){
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int A = input.nextInt();
			int B = input.nextInt();
			int N = input.nextInt();
			int minCost = Integer.MAX_VALUE;
			ArrayList<Route> list = new ArrayList<Route>();

			for(int i = 0; i < N; i++){
				int C = input.nextInt();
				int numCities = input.nextInt();
				int[] arr = new int[numCities];
				for(int j = 0; j < arr.length; j++)
					arr[j] = input.nextInt();

				list.add(new Route(arr, C));
			}

			for(int i = 0; i < N; i++){
				int cost = solve(list, A, B, i);
				if(cost < minCost)
					minCost = cost;
			}

			System.out.println(minCost);
		}
	}

	int solve(ArrayList<Route> routes, int A, int B, int pos){

		int minCost = Integer.MAX_VALUE;

		if(routes.get(pos).hasA(A)){

			int indexA = routes.get(pos).getA(A);

			if(routes.get(pos).hasB(A, B)){
				//return cost
				int newCost = routes.get(pos).cost;
				if(newCost < minCost)
					minCost = newCost;

			}else{

				for(int j = indexA + 1; j < routes.get(pos).getSize(); j++){

					int pivot = routes.get(pos).route.get(j);

					for(int i = 0; i < routes.size(); i++){
						if(i == pos)
							continue;

						if(routes.get(i).hasB(pivot, B)){
							//return new cost if lower than min
							int newCost = routes.get(i).cost + routes.get(pos).cost;
							if(newCost < minCost)
								minCost = newCost;
						}
					}
				}
			}
			

		}

		return minCost;
	}
	public static void main(String[] args){
		new cowroute2_2();
	}
}


class Route{

	ArrayList<Integer> route;
	int cost;
	Route(int[] arr, int cost){
		this.cost = cost;
		route = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++)
			route.add(arr[i]);

	}

	boolean hasA(int A){
		for(int i = 0; i < route.size(); i++)
			if(route.get(i) == A)
				return true;
		return false;
	}

	int getA(int A){
		for(int i = 0; i < route.size(); i++)
			if(route.get(i) == A)
				return i;
		return -1;
	}

	int getSize(){
		return route.size();
	}

	boolean hasB(int pivot, int B){
		int pivotIndex = getPivotIndex(pivot);
		for(int i = pivotIndex + 1; i < route.size(); i++){
			if(route.get(i) == B)
				return true;
		}

		return false;
	}

	int getPivotIndex(int pivot){
		for(int i = 0; i < route.size(); i++)
			if(route.get(i) == pivot)
				return i;
		return -1;
	}
}