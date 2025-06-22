package java96414;

public class StatCal {
	private int[] number = new int[20];

	public void enter(int i, int value) {
		number[i] = value;
	}

	public int getCount() {
		return number.length;
	}

	public int getSum() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum = sum + number[i];
		}
		return sum;
	}

	public double getMean() {
		double average = (double) getSum() / getCount();
		return average;
	}

	public double getStdDeviation() {
		double summation = 0;
		double average = getMean();

		for (int i = 0; i < number.length; i++) {
			summation = summation + Math.pow(number[i] - average, 2);
		}
		double sd = Math.sqrt(summation / number.length);
		return sd;
	}
}
