import java.util.*;

public class cow{
	cow(){
		Scanner input = new Scanner(System.in);

		int T= input.nextInt();

		for(int cse = 0; cse < T; cse++){
			String grass = input.next();

			int count = 0;
			for(int i = 0; i < grass.length() - 3; i++){

				if(grass.charAt(i) == '(' && grass.charAt(i + 1) == '('){
					for(int j = i + 2; j < grass.length() -1; j++){
						if(grass.charAt(j) == ')' && grass.charAt(j + 1) == ')'){
							count++;
						}
					}
				}
			}

			if(grass.length() < 4)
				System.out.println("0");
			else
			System.out.println(count);
		}
	}

	public static void main(String[] args){
		new cow();
	}
}

/*
4
)((()())())
(((()))
(())
()

*/