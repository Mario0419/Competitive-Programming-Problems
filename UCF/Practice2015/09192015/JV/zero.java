import java.util.*;

public class zero{
	zero(){
		Scanner input = new Scanner(System.in);
		int cse = 1;
		while(true){
			int N = input.nextInt();
			if(N == 0)
				break;

			String guitar = input.next();
			int score = 0;
			for(int i = 0; i < N; i++){
				if(guitar.charAt(i) == '+')
					score++;
				else
					score--;
			}

			if(score > 0)
				System.out.println("Song " + cse + ": Shreddin");
			else
				System.out.println("Song " + cse + ": Guitar Zero");
			cse++;
		}
	}

	public static void main(String[] args){
		new zero();
	}
}

/*

10
+-+-++-+-+
10
---+----+-
5
+---+
11
+++++++++-+
0

*/