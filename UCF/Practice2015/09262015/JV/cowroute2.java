import java.util.*;

public class cowroute2{
	cowroute2(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int A= input.nextInt();
			int B = input.nextInt();
			int N = input.nextInt();
			int minCost = Integer.MAX_VALUE;
			int goTo = 2*N;
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

			for(int i = 0; i < N; i++)
				list.add(new ArrayList<Integer>());

			ArrayList<Integer> cost = new ArrayList<Integer>();

			for(int i = 0; i < N; i++){
				int C = input.nextInt();
				int number = input.nextInt();

				int[] arr = new int[number];
				for(int j = 0; j < arr.length; j++)
					list.get(i).add(input.nextInt());

				cost.add(C);
			}

			for(int i = 0; i < N; i++){
				int temp = canDo(list, A, B, i, cost);
				if(minCost > temp){
					minCost = temp;
				}

			}


			if(A == B){
				System.out.println("0");
			}else if(minCost != Integer.MAX_VALUE){
				System.out.println(minCost);
			}else{
				System.out.println("-1");
			}
		
		}
	}

	int canDo(ArrayList<ArrayList<Integer>> arr, int A, int B, int pos, ArrayList<Integer> cost){

		boolean ans = false;
		int minCost = Integer.MAX_VALUE;

		for(int i = 0; i < arr.get(pos).size(); i++){
			if(arr.get(pos).get(i) == A){
				for(int j = i  + 1; j < arr.get(pos).size(); j++){
					if(arr.get(pos).get(j) == B){
						if(minCost > cost.get(pos)){
							minCost = cost.get(pos);
						}
					}else{


						for(int k = 0; k < arr.size(); k++){
							if(k == pos) continue;

							for(int m = 0; m < arr.get(k).size(); m++){
								if(arr.get(k).get(m) == arr.get(pos).get(j)){

									for(int n = m + 1; n < arr.get(k).size(); n++){
										if(arr.get(k).get(n) == B){
											if(minCost > cost.get(pos) + cost.get(k)){
												minCost = cost.get(pos) + cost.get(k);

												}
											}
										}
									}
								}
							}
						}


				}


			}
		}


		return minCost;
	}
	public static void main(String[] args){
		new cowroute2();
	}
}

/*

2
1 2 3
3 3
3 2 1
4 4
2 1 4 3
8 5
4 1 7 8 2


*/