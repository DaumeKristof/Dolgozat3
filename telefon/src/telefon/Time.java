package telefon;

public class Time {
	
	private final int ora;
	private final int perc;
	private final int mp;
	
	public Time(int ora, int perc, int mp) {
		this.ora = ora;
		this.perc = perc;
		this.mp = mp;
	}

	public int getOra() {
		return ora;
	}

	public int getPerc() {
		return perc;
	}

	public int getMp() {
		return mp;
	}

}
