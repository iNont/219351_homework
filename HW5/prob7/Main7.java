import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main7 {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("web-Google.txt"))) {
			
//		    StringBuilder sb = new StringBuilder();
			HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		    String line = br.readLine();
		    String word1 = "";
		    String word2 = "";
		    int i = 0;
		    
		    //Problem 7
		    while (line != null) {
		    	StringTokenizer itr = new StringTokenizer(line);
		    	while (itr.hasMoreTokens()) {
		    		word1 = itr.nextToken();
		    		ArrayList<String> list = new ArrayList<String>();
		    		if(word1.equals("#")){
		    			break;
		    		}
		    		word2 = itr.nextToken();
		    		
		    		if(hm.get(word1) != null){
		    			hm.get(word1).add(word2);
		    		}
		    		else{
		    			list.add(word2);
		    			hm.put(word1, list);
		    		}
//		    		System.out.println(word1+"       "+word2+"         "+hm.get(word1));
		    	}
		        line = br.readLine();
		        
		    }
//		    
//		    ArrayList arr = hm.get("35701");
//		    System.out.println(arr.toString());
//		    String everything = sb.toString();
//		    Set<String> set = new HashSet();
//		    set.add("A");
//		    set.add("B");
//		    set.add("C");
//		    set.add("D");
//		    set.removeAll()
		    PrintWriter writer = new PrintWriter("Problem7.txt", "UTF-8");
		    Iterator it = hm.entrySet().iterator();
		    while (it.hasNext()) {
		        HashMap.Entry<String, ArrayList<String>> pair = (HashMap.Entry)it.next();
		        writer.print(pair.getKey()+" : ");
		        Set<String> set = new HashSet();
		        for(String s: pair.getValue()){
		        	if(hm.get(s) != null){
		        	for(String t: hm.get(s)){
		        		if(t != null){
		        			set.add(t);
		        		}
		        	}
		        	}
		        }
		        set.remove(pair.getKey());
		        set.addAll(pair.getValue());
		        writer.print(set);
		        writer.println();
//		        System.out.println(pair.getKey() + " = " + pair.getValue());
////		        it.remove(); // avoids a ConcurrentModificationException
		        
		        
		    }
		    writer.close();
		    
		}
	}
	
}
