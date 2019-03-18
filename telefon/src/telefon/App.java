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
		int ora = console.readInt("1.feladat: Kérek egy idõpontot. Óra: ");
		int perc = console.readInt("Perc: ");
		int mp = console.readInt("Másodperc: ");
		System.out.println("A megadott idõ "+task.összMp(ora, perc, mp)+" másodperc.");
		System.out.println("2.feladat: Adatok beolvasása");
		System.out.println("3.feladat:\r\n" + task.orankent());
		System.out.println("4.feladat: " + task.maxHiv());
		int o = console.readInt("5.feladat: Kérek egy idõpontot. Óra: ");
		int p = console.readInt("Perc: ");
		int m = console.readInt("Másodperc: ");
		System.out.println(task.idopont(o, p, m));
		System.out.println("6.feladat: " + task.utolso());
		System.out.println("7.feladat: A sikeres.txt elkészítése.");
		writer.printAll(task.bekapcsoltak());
	}

}
