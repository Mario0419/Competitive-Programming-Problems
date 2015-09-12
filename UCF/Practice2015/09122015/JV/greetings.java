import java.util.*;


public class greetings{
	greetings(){
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for(int cse = 0; cse < T; cse++){
			int B = input.nextInt();
			int E = input.nextInt();

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int time = 1;
			int pos = 0;
			int direct = 0;
			for(int i = 0; i < B; i++){
				int t = input.nextInt();
				String direction = input.next();

				
				if(direction.equals("R"))
					direct = 1;
				else
					direct = -1;

				for(int j = 0; j < t; j++){

					pos += direct;
					map.put(time, pos);
					time++;
				}
			}

			int lastPos = pos;
			int count = 0;
			pos = 0;
			time = 1;
			boolean areApart = false;

			for(int i = 0; i < E; i++){
				int t = input.nextInt();
				String direction = input.next();

				if(direction.equals("R"))
					direct = 1;
				else
					direct = -1;

				for(int j = 0; j < t; j++){

					pos += direct;
					if(map.containsKey(time)){
						
						if(map.get(time) == pos && areApart){
							areApart = false;
							count++;
						}else if(map.get(time) == pos && !areApart){
							areApart = false;
						}else{
							areApart = true;
						}
					}else if(pos == lastPos && areApart){
						areApart = false;
						count++;
					}else if(pos == lastPos && !areApart){
						
					}else{
						areApart = true;
					}
					time++;
				

				}
			}
			System.out.println(count);
		}
	}

	public static void main(String[] args){
		new greetings();
	}
}


/*


2
4 5
3 L
5 R
1 L
2 R
4 R
1 L
3 L
4 R
2 L
3 7
1 R
2 R
3 R
3 R
2 R
1 R
1 R
1 L
0 R
0 R




*/