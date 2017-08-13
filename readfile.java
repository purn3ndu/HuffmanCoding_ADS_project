import java.util.*;
import java.io.*;

public class readfile{
    // implement Hashmap instead of Array. If new element is encountered which is not in Hashmap then 
    // add to HashMap else increment the counter/value of that element by 1.

    
    
    public HashMap<Integer,Integer> buildFreTable(String path) throws Exception{
        int readnum;
        int numfreq;
        BufferedReader read = new BufferedReader(new FileReader(new File(path)));
        // Declare HashMap here.
        //Vector<Integer> ve = new Vector<>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();  
        // for (int i = 0; i < 1000000; i++) {
        // 	ve.add(i, 0);
        // }

        //loop over the whole file. read string at each readLine()

        String str = null;
      	while((str = read.readLine()) != null){
        	readnum = Integer.parseInt(str);
            if (hm.containsKey(readnum)){
                // get value of str and increment by 1
                //Integer freq= hm.get(str);
                hm.put(readnum, hm.get(readnum)+1);
            }else{
                //hm.put(100,"Amit");  
                hm.put(readnum, 1);
            }
        	//numfreq = ve.get(readnum);
        	//ve.set(readnum, numfreq + 1);	
        }
        
        return hm;
    }

}