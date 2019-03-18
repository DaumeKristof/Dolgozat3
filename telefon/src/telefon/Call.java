package telefon;

public class Call {
	
	private final Time start;
	private final Time end;
	
	public Call(Time start, Time end) {
		this.start = start;
		this.end = end;
	}

	public Time getStart() {
		return start;
	}

	public Time getEnd() {
		return end;
	}

}
