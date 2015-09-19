import java.util.*;

public class organize{
	organize(){
		Scanner input = new Scanner(System.in);
		int cse = 1;
		while(true){
			int[] arr = new int[3];
			for(int i = 0; i < 3; i++)
				arr[i] = input.nextInt();
			int N = input.nextInt();

			if(N == 0 && arr[0] == 0 && arr[1] == 0 && arr[2] == 0)break;

			int heightDisc = 2 * N;
			int diameter = 120;

			if(doesFit(arr, N)){
				System.out.println("Box " + cse + ": Stack of " + N + " discs fits!");
			}else{
				System.out.println("Box " + cse + ": Stack of " + N + " discs does not fit.");
			}

			cse++;
		}
	}

	boolean doesFit(int[] arr, int N){
		int heightDisc = 2 * N;
		int diameter = 120;

		

		//three scnarios 0 and 1 with height = 2

		if(arr[0] >= heightDisc){
			if(arr[1] >= 120 && arr[2] >= 120)
				return true;
		}
		if(arr[1] >= heightDisc){
			if(arr[0] >= 120 &&  arr[2] >= 120)
				return true;
		}
		if(arr[2] >= heightDisc){
			if(arr[0] >= 120 && arr[1] >= 120)
				return true;
		}

		return false;
		
	}
	public static void main(String[] args){
		new organize();
	}
}

/*

120 200 600 300
40 400 100 25
100 150 150 12
0 0 0 0


*/