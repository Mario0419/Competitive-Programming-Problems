import java.util.*;

public class robot{
	robot(){

		Scanner input = new Scanner(System.in);

		while(true){
			int N = input.nextInt();
			if(N == 0)
				break;

			ArrayList<Target> list = new ArrayList<Target>();
			for(int i = 0; i < N; i++){
				double x = input.nextDouble();
				double y = input.nextDouble();
				double P = input.nextDouble();
				list.add(new Target(x, y, P));

			}
			list.add(new Target(100.0, 100.0, 0));
			double currX = 0;
			double currY = 0;
			double points = 0.0;
			int i = 0;
			for(i = 0; i < list.size()-1; i++){
				//we have the option to skip or move on
				//we need to find out what's less. Take it, so calculate dist from curr pos to taret i to target i + 1
				//or just go to target i + 1
				double takeIt = distance(list.get(i), currX, currY) + 1.0 + distance(list.get(i+1), list.get(i).x, list.get(i).y) + 1.0;
				double dontTake = distance(list.get(i+1), currX, currY) + 1.0 + list.get(i).P;
				// System.out.println("take is " + takeIt + " and donttake is " + dontTake);
				if(takeIt < dontTake){
					//add to points only number of points to go to place
					points += distance(list.get(i), currX, currY) + 1.0;
					currX = list.get(i).x;
					currY = list.get(i).y;
				}else{
					// System.out.println("Skipping over " + i + " and going to " + (i+1));
					points += distance(list.get(i + 1), currX, currY) + 1.0 + list.get(i).P;
					currX = list.get(i+1).x;
					currY = list.get(i+1).y;

					
					i++;
				}

			}
			// System.out.println(i + " is i " + list.size());
			if(i == list.size()-1){

				points += distance(list.get(i-1), 100.0, 100.0) + 1.0;
			}

			System.out.printf("%.3f\n", points);

		}
	}

	double distance(Target i , double currX, double currY){
		return Math.sqrt(Math.pow(currX-i.x, 2) + Math.pow(currY - i.y, 2));
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