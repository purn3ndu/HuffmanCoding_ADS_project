import java.util.*;
import java.io.*;
public class encoder {
	public void encoder(String path) throws Exception{
		int readnum;
		Vector<Character> buffer = new Vector<>();
		Vector<String> table;
		BuildCodeTable codeTable = new BuildCodeTable();
		codeTable.buildCodeTable(path);
		table = codeTable.table;
		//System.out.println(table);
		BufferedReader read = new BufferedReader(new FileReader(new File(path)));
		File encoded = new File("encoded.bin");
		encoded.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(encoded);
		String str = null;
      	while((str = read.readLine()) != null){
        	readnum = Integer.parseInt(str);
        	//System.out.println(readnum);
        	for (int i = 0; i < table.get(readnum).length(); i++) {
        		buffer.add(table.get(readnum).charAt(i));
        	}

        	while (buffer.size() >= 8) {
        		String temp = "";
        		for(int i = 0; i < 8; i++) {
        			temp += buffer.get(0);
        			buffer.remove(0);
        		}
        		outputStream.write(Integer.valueOf(temp+"", 2).byteValue());
        	}
        	
        }
        //For the remaining character in the buffer
        if (buffer.size() > 0) {
        	String temp = "";
			for (int i = 0; i < 8; i++) {
				if (buffer.size() > 0) {
					temp += buffer.get(0);
					buffer.remove(0);
				} else {
					temp += "0";
				}	
			}
			outputStream.write(Integer.valueOf(temp+"", 2).byteValue());
        }
        outputStream.close();
	}

	public static void main(String[] args) throws Exception{
		encoder encode1 = new encoder();
		encode1.encoder(args[0]);
	}
}