import java.util.*;

public class nowin{
	nowin(){
		Scanner input = new Scanner(System.in);


		while(true){
			String hand = input.next();
			if(hand.equals("JOKER")) break;

			String player = "" + hand.charAt(0) + hand.charAt(2);
			String dealer = "" + hand.charAt(1) + hand.charAt(3);
			int p = 0;
			int d = 0;

			
			p += get(hand.charAt(0), p);
			p += get(hand.charAt(2), p);
			d += get(hand.charAt(1), d);
			d += get(hand.charAt(3), d);
		
				if(play(p, d, hand, 4, true) || play(p, d, hand, 4, false))
					System.out.println("Yes");
				else
					System.out.println("No");
			

		}
	}

	boolean play(int p, int d, String hand, int i, boolean playerTurn){
		if(i == hand.length()){
			if(d > 21)//if dealer went over 21 you win
				return true;
			if(p > 21)//if player went over 21 you lose
				return false;

			return p >= d;//if none is true, there are no cards to pick at this point just return who is higher

		}

		if(d > 21) return true;
		if(p > 21) return false;
		if(d >= 17 && !playerTurn) return p >= d;

		if(playerTurn){
			//we have several choices
			//take the card and give up our turn
			//leave the card and give up our turn
			//take the card and choose the next turn
			int T = get(hand.charAt(i), p);
			//if T is 'A' we can choose 1 or 11. Make sure of this possibility
			if(play(p + T, d, hand, i + 1, true))//take the card, and we want to take next turn
				return true;
			if(play(p + T, d, hand, i + 1, false))//take the card, stop taking cards
				return true;
			if(play(p, d, hand, i, false))//don't take card and let dealer go
				return true;

		}else{
			int T = get(hand.charAt(i), d);

			if(play(p, d + T, hand, i + 1, false))//let dealer take the card
				return true;
		}

		return false;
	}

	int get(Character c, int player){
		switch(c){
			case 'T':
				return 10;
			case 'K':
				return 10;
			case 'J':
				return 10;
			case 'Q':
				return 10;
			case 'A':
				return player < 11 ? 11 : 1;
			default:
				return c - '0';
		}
	}

	
	public static void main(String[] args){
		new nowin();
	}
}

/*


Q649T
T34K35
AA2T34A5KKQAJ
5756K8
AAAAAAQAAAAAAAAAAAA
T34K35
JOKER


*/
