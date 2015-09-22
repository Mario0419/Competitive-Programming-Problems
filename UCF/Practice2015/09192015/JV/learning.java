import java.util.*;


public class learning{
	learning(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int N = input.nextInt();
			int A = input.nextInt();
			int B = input.nextInt();
			int count = 0;
			Cow[] cows = new Cow[N];

			for(int i = 0; i < N; i++){
				String spot = input.next();
				int weight = input.nextInt();
				boolean hasSpot = spot.equals("S") ? true : false;
				if(spot.equals("S"))
					count++;

				cows[i] = new Cow(hasSpot, weight);
			}

			for(int i = 0; i < N-1; i++){
				if(cows[i].spots && cows[i+1].spots){
					if(cows[i].weight == cows[i+1].weight)
						count--;
				}else if((cows[i].spots && !cows[i+1].spots) || (!cows[i].spots && cows[i].spots)){
					if(cows[i].weight == cows[i+1].weight){
						cows[i+1].spots = true;
						cows[i].spots = true;
					}
				}
			}
			Arrays.sort(cows);

			// int index = A;

			for(int i = 0; i < cows.length-1; i++){
				boolean isOdd = (cows[i].weight + cows[i+1].weight)%2 == 1;
				int mid = (cows[i].weight + cows[i+1].weight)/2;

				if(isOdd){
					//mid is stop at the left
					if(cows[i].spots){
						count += mid - cows[i].weight;
					}
					if(cows[i+1].spots){
						count += (cows[i+1].weight-mid+1);
					}

				}else{
					//mid checks the right for spot
					if(cows[i+1].spots){
						count += (cows[i+1].weight-mid);
					}else{
						count += (mid - 1 - cows[i].weight);
					}
				}

			}

			if(A < cows[0].weight){
				if(cows[0].spots){
					count += cows[0].weight - A;
				}
			}

			if(B > cows[cows.length-1].weight){
				if(cows[cows.length-1].spots){
					count += B - cows[cows.length-1].weight;
				}
			}

			System.out.println(count);


		}
	}

	public static void main(String[] args){
		new learning();
	}
}

class Cow implements Comparable<Cow>{
	boolean spots;
	int weight;
	Cow(boolean s, int w){
		spots = s;
		weight = w;
	}
	@Override
	public int compareTo(Cow other){
		return this.weight - other.weight;
	}
}


/*

6
3 1 10
S 10
NS 4
S 1
2 1 10
NS 4
S 5
1 1 10
S 5
2 1 1
S 1
NS 1
2 1 5
S 3
NS 3
1 1 2
NS 1




*/