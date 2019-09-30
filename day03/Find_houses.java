package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//DAY 3
public class Find_houses {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> dimensions = new ArrayList<String>();
		
		File file = new File("year2015//Route.txt"); 
		  int housesVisited = 1;
		  int x1 = 0;
		  int y1 = 0;
		  int x2 = 0;
		  int y2 = 0;
		  dimensions.add("(0,0)");
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  //populating array
		  String st = br.readLine();
		  for(int i = 0; i < st.length(); i++){
			String character = st.substring(i, i+1);
			String point;
			if (i%2 == 0) { //santa
				switch(character) {
				case ">": x1++;break;
				case "<": x1--;break;
				case "^": y1++;break;
				case "v": y1--;break;	
				}
				point = "(" + x1 + "," + y1 + ")";
			}
			else {//clone
				switch(character) {
				case ">": x2++;break;
				case "<": x2--;break;
				case "^": y2++;break;
				case "v": y2--;break;	
				}
				point = "(" + x2 + "," + y2 + ")";
			}
			
			if(!(dimensions.contains(point))) {
				//doesnt contains point, so we update house countand add new point
				dimensions.add(point);
				housesVisited++;
			}
		  }
		  System.out.println("Total houses visited: " + housesVisited);
		  

	}

}
