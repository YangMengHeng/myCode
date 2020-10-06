class NotSanjiaoException extends Exception{
	NotSanjiaoException(String s){
		super(s);
	}
	void showMess() {
		System.out.println("It's not a triangle!Error Code:1030;");
	}
}

class Sanj{
	private int x;
	private int y;
	private int z;
	Sanj(){}
	Sanj(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	double getArea()throws NotSanjiaoException {
		if((x < 0) || (y < 0) || (z < 0)) {
			throw new NotSanjiaoException("Error!");
		}
		if(((x + y) < z) || ((x + z) < y) || ((y + z) < x)) {
			throw new NotSanjiaoException("Error!");
		}
		return 0.25 * Math.sqrt((x + y + z) * (x + y - z) * (x + z - y) * (y + z - x));
	}
	void showInfo() throws NotSanjiaoException{
		if((x < 0) || (y < 0) || (z < 0)) {
			throw new NotSanjiaoException("Error!");
		}
		if(((x + y) < z) || ((x + z) < y) || ((y + z) < x)){
			throw new NotSanjiaoException("Error!");
		}
		System.out.println("length of triangle:" + this.x);
		System.out.println("width of triangle:" + this.y);
		System.out.println("height of triangle:" + this.z);
	}
}

public class TriangleError {
     public static void main(String[] args) {
        String[] temp1 = {"1", "2", "1"};
		Sanj sanj = new Sanj(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]), Integer.parseInt(temp1[2]));
		double temp;
		
		try {
			sanj.showInfo();
			temp = sanj.getArea();
			System.out.print("the area is " + temp);
		}
		catch(NotSanjiaoException nsj) {
			nsj.showMess();
		}
	}
}