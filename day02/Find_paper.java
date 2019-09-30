package day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//DAY 2
public class Find_paper {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> dimensions = new ArrayList<String>();
		
		File file = new File("year2015//Presentlist.txt"); 
		  double totalPaper = 0;
		  double totalRibbon = 0;
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  //populating array
		  String st; 
		  while ((st = br.readLine()) != null) {
			String[] presents = st.split("x");
			double paper = getPaper(presents);
			double ribbon = getRibbon(presents);
			totalRibbon += ribbon;
			totalPaper += paper;
		    dimensions.add(st);
		  }
		  System.out.println("Total Paper: " + totalPaper);
		  System.out.println("Total Ribbon: " + totalRibbon);
		  

	}

	private static double getRibbon(String[] presents) {
		
		double l = Integer.valueOf(presents[0]);
		double w = Integer.valueOf(presents[1]); 
		double h = Integer.valueOf(presents[2]);
		//sort array
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(h);
		list.add(w);
		list.add(l);
		Collections.sort(list);
		double ribbon = (2*list.get(0) + 2*list.get(1) + (h*w*l));
		return ribbon;
	}

	private static double getPaper(String[] presents) {
		
		double l = Integer.valueOf(presents[0]);
		double w = Integer.valueOf(presents[1]); 
		double h = Integer.valueOf(presents[2]);
		double smallestSide = findSmallest(l, w, h);
		double paper = (2*l*w) + (2*w*h) + (2*h*l) + smallestSide;
		return paper;
	}

	private static double findSmallest(double l, double w, double h) {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add((l*w));
		list.add((w*h));
		list.add((h*l));
		Collections.sort(list);
		return list.get(0);
	}

}
