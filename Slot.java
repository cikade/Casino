import java.util.Random;

public class Slot {

	static String symbols[] = { "10       ", "Jack     ", "Queen    ", "King     ", "Ace      ", "Scarab   ",
			"Bird     ", "Mummy    ", "Explorer ", "Book     " };
	static int won2[] = { 0, 0, 0, 0, 0, 5, 5, 5, 10, 0 };
	static int won3[] = { 5, 5, 5, 5, 5, 30, 30, 40, 100, 20 };
	static int won4[] = { 25, 25, 25, 25, 25, 100, 100, 400, 1000, 200 };
	static int won5[] = { 100, 100, 100, 100, 100, 750, 750, 2000, 5000, 2000 };

	public int slot() {

		String row1[] = new String[5];
		String row2[] = new String[5];
		String row3[] = new String[5];
		Random rand = new Random();
		int money = 0;

		for (int i = 0; i <= 4; i++) {
			row1[i] = symbols[rand.nextInt(10)];
			row3[i] = symbols[rand.nextInt(10)];
			row2[i] = symbols[rand.nextInt(10)];
		}

		// 1
		if (row2[0].equals(row2[1])) {
			if (row2[0].equals(row2[2])) {
				if (row2[0].equals(row2[3])) {
					if (row2[0].equals(row2[4])) {
						money += checkItemValue(checkItemID(row2[0]), 5);
					} else money += checkItemValue(checkItemID(row2[0]), 4);
				} else money += checkItemValue(checkItemID(row2[0]), 3);
			} else money += checkItemValue(checkItemID(row2[0]), 2);
		}

		// 2
		if (row1[0].equals(row1[1])) {
			if (row1[0].equals(row1[2])) {
				if (row1[0].equals(row1[3])) {
					if (row1[0].equals(row1[4])) {
						money += checkItemValue(checkItemID(row1[0]), 5);
					} else money += checkItemValue(checkItemID(row1[0]), 4);
				} else money += checkItemValue(checkItemID(row1[0]), 3);
			} else  money += checkItemValue(checkItemID(row1[0]), 2);
		}

		// 3
		if (row3[0].equals(row3[1])) {
			if (row3[0].equals(row3[2])) {
				if (row3[0].equals(row3[3])) {
					if (row3[0].equals(row3[4])) {
						money += checkItemValue(checkItemID(row3[0]), 5);
					} else money += checkItemValue(checkItemID(row3[0]), 4);
				} else money += checkItemValue(checkItemID(row3[0]), 3);
			} else money += checkItemValue(checkItemID(row3[0]), 2);
		}

		// 4
		if (row1[0].equals(row2[1])) {
			if (row1[0].equals(row3[2])) {
				if (row1[0].equals(row2[3])) {
					if (row1[0].equals(row1[4])) {
						money += checkItemValue(checkItemID(row1[0]), 5);
					} else money += checkItemValue(checkItemID(row3[0]), 4);
				} else money += checkItemValue(checkItemID(row3[0]), 3);
			} else money += checkItemValue(checkItemID(row3[0]), 2);
		}
		
		// 5
		if (row3[0].equals(row2[1])) {
			if (row3[0].equals(row1[2])) {
				if (row3[0].equals(row2[3])) {
					if (row3[0].equals(row3[4])) {
						money += checkItemValue(checkItemID(row3[0]), 5);
					} else money += checkItemValue(checkItemID(row3[0]), 4);
				} else money += checkItemValue(checkItemID(row3[0]), 3);
			} else money += checkItemValue(checkItemID(row3[0]), 2);
		}
		
		// 6
		if (row2[0].equals(row3[1])) {
			if (row2[0].equals(row3[2])) {
				if (row2[0].equals(row3[3])) {
					if (row2[0].equals(row2[4])) {
						money += checkItemValue(checkItemID(row2[0]), 5);
					} else money += checkItemValue(checkItemID(row2[0]), 4);
				} else money += checkItemValue(checkItemID(row2[0]), 3);
			} else money += checkItemValue(checkItemID(row2[0]), 2);
		}

		// 7
		if (row2[0].equals(row1[1])) {
			if (row2[0].equals(row1[2])) {
				if (row2[0].equals(row1[3])) {
					if (row2[0].equals(row2[4])) {
						money += checkItemValue(checkItemID(row2[0]), 5);
					} else money += checkItemValue(checkItemID(row2[0]), 4);
				} else money += checkItemValue(checkItemID(row2[0]), 3);
			} else money += checkItemValue(checkItemID(row2[0]), 2);
		}

		// 8
		if (row3[0].equals(row3[1])) {
			if (row3[0].equals(row2[2])) {
				if (row3[0].equals(row1[3])) {
					if (row3[0].equals(row1[4])) {
						money += checkItemValue(checkItemID(row3[0]), 5);
					} else money += checkItemValue(checkItemID(row3[0]), 4);
				} else money += checkItemValue(checkItemID(row3[0]), 3);
			} else money += checkItemValue(checkItemID(row3[0]), 2);
		}

		// 9
		if (row1[0].equals(row1[1])) {
			if (row1[0].equals(row2[2])) {
				if (row1[0].equals(row3[3])) {
					if (row1[0].equals(row3[4])) {
						money += checkItemValue(checkItemID(row1[0]), 5);
					} else money += checkItemValue(checkItemID(row1[0]), 4);
				} else money += checkItemValue(checkItemID(row1[0]), 3);
			} else money += checkItemValue(checkItemID(row1[0]), 2);
		}

		// 10
		if (row3[0].equals(row2[1])) {
			if (row3[0].equals(row2[2])) {
				if (row3[0].equals(row2[3])) {
					if (row3[0].equals(row1[4])) {
						money += checkItemValue(checkItemID(row3[0]), 5);
					} else money += checkItemValue(checkItemID(row3[0]), 4);
				} else money += checkItemValue(checkItemID(row3[0]), 3);
			} else money += checkItemValue(checkItemID(row3[0]), 2);
		}

		if (money > 0)

		{
			for (int i = 0; i <= 4; i++)
				print(row1[i] + "");
			println("");
			for (int i = 0; i <= 4; i++)
				print(row2[i] + "");
			println("");
			for (int i = 0; i <= 4; i++)
				print(row3[i] + "");
			println("");
		}
		return (money);

	}

	public static void print(String str) {
		System.out.print(str);
	}

	public static void println(String str) {
		System.out.println(str);
	}

	public static int checkItemID(String str) {
		for (int i = 0; i < 10; i++) {
			if (symbols[i].equals(str))
				return i;
		}
		return -1;
	}

	public static int checkItemValue(int itemID, int itemQuantity) {
		int x = 0;
		if (itemQuantity == 2)
			x = won2[itemID];
		if (itemQuantity == 3)
			x = won3[itemID];
		if (itemQuantity == 4)
			x = won4[itemID];
		if (itemQuantity == 5)
			x = won5[itemID];
		return x;
	}

}
