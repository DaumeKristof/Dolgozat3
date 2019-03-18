package telefon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
	
	public List<Call> getData(String fileName) {
		return convert(read(fileName));
	}
	
	private List<Call> convert(List<String> lista) {
		List<Call> lista2 = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			
			String[] sor = lista.get(i).split(" ");
			Time k = new Time(Integer.parseInt(sor[0]), Integer.parseInt(sor[1]), Integer.parseInt(sor[2]));
			Time v = new Time(Integer.parseInt(sor[3]), Integer.parseInt(sor[4]), Integer.parseInt(sor[5]));
			Call c = new Call(k,v);
			
			lista2.add(c);
		}
		
		return lista2;
	}
	
	private List<String> read(String fileName) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
