import java.util.*;

public class sweet{
    sweet(){
        Scanner input = new Scanner(System.in);

        int T= input.nextInt();
        for(int cse = 1; cse <= T; cse++){
            int N = input.nextInt();
            int money = 0;
            System.out.println("Scenario " + cse + ":");
            for(int i = 0; i < N; i++){
                int M = input.nextInt();


                money += M;

                if(money >= 50){
                    money -= 50;
                    System.out.println("Sweet!");
                }else{
                    System.out.println("Bummer, I need to wait.");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        new sweet();
    }
}

/*

2
1
25
3
30
30
40


*/