package telefon;


public class App {
	
	private final DataReader data;
	private final Console console;
	private final Task task;
	private final DataWriter writer;
	
	public App() {
		console = new Console();
		data = new DataReader();
		task = new Task(data.getData("hivas.txt"));
		writer = new DataWriter("sikeres.txt");
	}

	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		int ora = console.readInt("1.feladat: K�rek egy id�pontot. �ra: ");
		int perc = console.readInt("Perc: ");
		int mp = console.readInt("M�sodperc: ");
		System.out.println("A megadott id� "+task.�sszMp(ora, perc, mp)+" m�sodperc.");
		System.out.println("2.feladat: Adatok beolvas�sa");
		System.out.println("3.feladat:\r\n" + task.orankent());
		System.out.println("4.feladat: " + task.maxHiv());
		int o = console.readInt("5.feladat: K�rek egy id�pontot. �ra: ");
		int p = console.readInt("Perc: ");
		int m = console.readInt("M�sodperc: ");
		System.out.println(task.idopont(o, p, m));
		System.out.println("6.feladat: " + task.utolso());
		System.out.println("7.feladat: A sikeres.txt elk�sz�t�se.");
		writer.printAll(task.bekapcsoltak());
	}

}
