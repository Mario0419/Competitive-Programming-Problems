import java.util.*;
import java.lang.Math.*;

public class triangle{
	triangle(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 1; cse <= T; cse++){

			double[] sides = new double[3];
			for(int i = 0; i < 3; i++)
				sides[i] = input.nextDouble();
			Arrays.sort(sides);
			double a = sides[0];
			double b = sides[1];
			double c = sides[2];

			double angleC = Math.acos((c*c-a*a-b*b)/(-2*a*b));
			double angleB = Math.acos((b*b-a*a-c*c)/(-2*a*c));
			double angleA = Math.acos((a*a-b*b-c*c)/(-2*b*c));

			angleC = (angleC*180.0/Math.PI);
			angleB = (angleB*180.0/Math.PI);
			angleA = (angleA*180.0/Math.PI);

			// System.out.println(angleA + " " + angleB + " " + angleC);
			if(Math.abs((angleA +angleB + angleC) - 180.0) <= 1e-9 && (angleA != 0 && angleB != 0 && angleC != 0)){
				System.out.println("Case #" + cse + ": " + solve(angleA, angleB, angleC, sides));
			}else{
				System.out.println("Case #" + cse + ": invalid!");
			}
			// System.out.println(angle);
			// System.out.println((angle*180.0)/Math.PI);


		}
		
	}

	String solve(double A, double B, double C, double[] sides){

		if(sides[0] == sides[1] && sides[0] == sides[2])
			return "equilateral";
		else if(sides[0] == sides[1] && sides[0] != sides[2])
			return "isosceles";
		else if(sides[0] != sides[1] && sides[0] == sides[2])
			return "isosceles";
		else if(sides[1] == sides[2] && sides[1] != sides[0])
			return "isosceles";
		else
			return "scalene";
	}

	public static void main(String[] args){
		new triangle();
	}
}

/*


3
3 3 4
6 4 2
3 4 5


*/