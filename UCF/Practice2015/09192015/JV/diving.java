import java.util.*;

public class diving{

	diving(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int Ft = input.nextInt();

			if(Ft <= 30){
				System.out.println((60 - (Ft/10)*2) + " minute(s) at " + Ft + " feet");
			}else{
				int numStops = (Ft - 30) / 10;
				int total = 6 + numStops;
				total += 2*((Ft-30)/10);

				total = 60 - total;

				if(total <= 0)
					System.out.println("0 minute(s) at " + Ft + " feet");
				else
					System.out.println(total + " minute(s) at " + Ft + " feet");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		new diving();
	}
}

/*

6
90
20
1000
0
20
30

*/