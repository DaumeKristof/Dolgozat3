package telefon;

import java.util.List;

import org.w3c.dom.ls.LSInput;

public class Task {
	
	private final List<Call> hivasok;
	
	public Task(List<Call> c)  {
		this.hivasok = c;
	}
	
	public int összMp(int ora, int perc, int mp ) {
		return (60 * 60 * ora + 60 * perc + mp);
	}
	
	public String orankent() {
		int[] darab = new int[24];
		for (int i = 0; i < hivasok.size(); i++) {
			darab[hivasok.get(i).getStart().getOra()]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < darab.length; i++) {
			if (darab[i] != 0) {
				String x = i + " óra: " + darab[i] + " db";
				sb.append(x);
				sb.append("\r\n");
			}
		}
		
		return sb.toString();
	}
	
	public String maxHiv() {
		int id = 0;
		int hossz = 0;
		for (int i = 0; i < hivasok.size(); i++) {
			int h = this.összMp(hivasok.get(i).getEnd().getOra(), hivasok.get(i).getEnd().getPerc(), hivasok.get(i).getEnd().getMp()) - this.összMp(hivasok.get(i).getStart().getOra(), hivasok.get(i).getStart().getPerc(), hivasok.get(i).getStart().getMp());
			
			if(h > hossz)  {
				hossz = h;
				id = i+1;
			}
		}
		
		return "Hívás sorszáma: " + id + ", hossza: " + hossz;
	}
	
	public String idopont(int o, int p, int m) {
		
		int input = this.összMp(o, p, m);
		int id1 = 0;
		int id2 = 0;
		String valasz = null;
		
		for (int i = 0; i < hivasok.size(); i++) {
			
			int s = this.összMp(hivasok.get(i).getStart().getOra(), hivasok.get(i).getStart().getPerc(), hivasok.get(i).getStart().getMp());
			int e = this.összMp(hivasok.get(i).getEnd().getOra(), hivasok.get(i).getEnd().getPerc(), hivasok.get(i).getEnd().getMp());
			
			if(input >= s && input <= e) {
				
				if(id1 == 0) {
					id1 = i+1;
				}
				else  {
					id2 = i+1;
				}
				
			}
			
		}
		
		if(id1 == 0) {
			valasz = "Nem volt beszélõ.";
		}
		else {
			if (id2 == 0) {
				valasz = "A " + id1 + ". hívóval beszélt az alkalmazott és nem vártak a vonalra.";
			}
			else {
				valasz = "A " + id1 + ". hívóval beszélt az alkalmazott és " + (id2-id1) + "-en/-an vártak a vonalra.";
			}
		}
		
		return valasz;
	}
	
	
	
	public String utolso() {
		int id = 0;
		int del = this.összMp(12, 0, 0);
		int i = 0;
		int sKov = 0;
		int sJel = 0;
		int maxEnd = 0;
		int maxEnd2 = 0;
		
		while (sKov < del) {

			sKov = this.összMp(hivasok.get(i+1).getStart().getOra(), hivasok.get(i+1).getStart().getPerc(), hivasok.get(i+1).getStart().getMp());
			int s = this.összMp(hivasok.get(i).getStart().getOra(), hivasok.get(i).getStart().getPerc(), hivasok.get(i).getStart().getMp());
			int e = this.összMp(hivasok.get(i).getEnd().getOra(), hivasok.get(i).getEnd().getPerc(), hivasok.get(i).getEnd().getMp());
			
			if (e > maxEnd) {
				maxEnd = e;
				id = i;
				sJel = s;
			}
				
			i++;
			
		}
		
		i = 0;
		
		
		while (i < id) {
			int e = this.összMp(hivasok.get(i).getEnd().getOra(), hivasok.get(i).getEnd().getPerc(), hivasok.get(i).getEnd().getMp());
			
			if (e > maxEnd2) {
				maxEnd2 = e;
			}
			i++;
		}
		
		return "A hívó azonosítója: "+ (id+1) + ", várakozási ideje: " + (maxEnd2-sJel) + ".";	
	}
	
	public String bekapcsoltak() {
		
		
		return null;
	}
}
