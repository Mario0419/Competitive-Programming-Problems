import java.util.*;


public class inequality{
	inequality(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			long P = input.nextInt();
			int N = input.nextInt();

			long[] arr = new long[N];

			for(int i = 0; i < N; i++)
				arr[i] = input.nextLong();

			long low = findLow(arr, P);
			long high = findHigh(arr, P);

			System.out.println(high - low+1);
		}
	}

	long calculate(long[] arr, long X){

		long ans = 0;

		for(int i = 0; i < arr.length; i++){
			ans += Math.abs(arr[i] - X);
		}

		return ans;
	}

	boolean isTrue(long cal, long P){
		return cal <= P ? true :false;
	}

	long findLow(long[] arr, long P){

		long low = -1000000;
		long high = 1000000;
		long mid = 0;
		while(low <= high){

			if(isTrue(calculate(arr, mid), P)){
				high = mid - 1;
				mid = (high + low) / 2;
			}else{

				low = mid + 1;
				mid = (high + low) /2;
			}
		}

		return mid;


	}

	long findHigh(long[] arr, long P){

		long low = -1000000;
		long high = 1000000;
		long mid = 0;
		while(low <= high){

			if(isTrue(calculate(arr, mid), P)){
				low = mid + 1;
				mid = (high + low) / 2;
			}else{

				high = mid - 1;
				mid = (high + low) /2;
			}
		}

		return mid;

	}
	public static void main(String[] args){
		new inequality();
	}
}

/*
3
6 3
1 2 3
42 5
10 30 15 -1 17
6495 6
0 1 2 2 3






*/