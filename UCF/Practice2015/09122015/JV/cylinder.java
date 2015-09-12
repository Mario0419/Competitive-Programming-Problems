import java.util.*;
import java.lang.*;

public class cylinder{
	cylinder(){
		Scanner input = new Scanner(System.in);

		while(true){
			double w = input.nextInt();
			double h = input.nextInt();

			if(w == 0 && h == 0) break;
			double nh = 0.0;
			double nw = 0.0;
			double radius = 0.0;
			if(w < h){
				nh = h  /2;
				nw = w;
				radius = nh/ 2;
			}else{
				nw = w / 2;
				nh = h;
				radius = nw/2;
			}

			// double radius = Math.min(nw/2.0, nh/2.0);
			// System.out.println(radius + " Is Radius " );
			double circumference = radius*2.0*Math.PI;

			double perimeterWithWidth = nw;
			double perimeterWithHeight = nh;
			double volumeWidth = 0.0;
			double volumeHeight = 0.0;
			System.out.println(circumference);
			// System.out.println(perimeterWithHeight + "  and " + perimeterWithWidth);
			// if(perimeterWithWidth >=  circumference){
				volumeWidth = nh*radius*radius*Math.PI;
			// }
			// if(perimeterWithHeight >= circumference){
				volumeHeight = nw*radius*radius*Math.PI;
			// }

			System.out.println(volumeHeight + " also is " + volumeWidth);
			// System.out.printf("%.3f\n", Math.max(volumeWidth, volumeHeight));


		}
	}

	public static void main(String[] args){
		new cylinder();
	}
}

/*

10 10
10 50
10 30
0 0




*/