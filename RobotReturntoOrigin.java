public class RobotReturntoOrigin {

	public static void main(String[] args) {
		RobotReturntoOrigin obj = new RobotReturntoOrigin();
		System.out.println(obj.judgeCircle("UDLR"));
		System.out.println(obj.judgeCircle("UU"));
		System.out.println(obj.judgeCircle("UDLL"));
	}

	public boolean judgeCircle(String s) {
		int x = 0; 
		int y = 0;

		for (char move : s.toCharArray()) {
			if (move == 'U') 
				y--;
			else if (move == 'D') 
				y++;
			else if (move == 'L') 
				x--;
			else if (move == 'R') 
				x++;
		}

		return x == 0 && y == 0;
	}	
}
