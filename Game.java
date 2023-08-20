
public class Game {

	public int main(float balance) throws ClassNotFoundException {
		double bets = 0.1;
		int spins = 1;
		double bal = balance*100;
		int money = (int)bal;
		double x = bets * 100;
		int bet = (int)x;

		Slot game = new Slot();
		
		int i = 0;
		while(i < spins) {
			i++;
			if (money < bet) {
				System.out.println("Money"+money);
			}
			System.out.println("Money before bet: "+(float)money/100);
			System.out.println("Bet: "+(float)bet/100);
			money = money - bet;
			int won = game.slot();
			money = money + won * bet / 10;
			System.out.println("Money won: "+(float)won/100*bet/10);
			System.out.println("Money after game: "+(float)money/100);
			System.out.println("-------------------------------------------");
		}
		System.out.println("You played "+i+" times!");
		System.out.println("Balance here: "+money);
		return money;
	}

}
