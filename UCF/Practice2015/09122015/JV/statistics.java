import java.util.*;

public class statistics{

	statistics(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 1; cse <= T; cse++){
			int N = input.nextInt();
			int[] scores = new int[N];

			for(int i = 0; i < N; i++)
				scores[i] = input.nextInt();

			Arrays.sort(scores);

			int min = scores[0];
			int max = scores[scores.length - 1];

			int maxDiff = 0;

			for(int i = 1; i < scores.length; i++){
				if(scores[i] - scores[i-1] > maxDiff)
					maxDiff = scores[i] - scores[i-1];
			}

			System.out.println("Class " + cse);
			System.out.println("Max " + max + ", Min " + min + ", Largest gap " + maxDiff);
		}
	}

	public static void main(String[] args){
		new statistics();
	}
}

/*


2
5 30 25 76 23 78
6 25 50 70 99 70 90

*/