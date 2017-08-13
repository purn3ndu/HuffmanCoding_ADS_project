import java.util.HashMap;
import java.util.Vector;
import java.io.*;
public class BuildCodeTable {
	File codeTable;
	PrintWriter p;
	Vector<String> table = new Vector<>(1000000);
	// Declare HashMap instead
	String[] string;
	public void buildCodeTable(String path) throws Exception {
		readfile file = new readfile();
        buildtree b = new buildtree();
		HashMap<Integer, Integer> freqtable = file.buildFreTable(path);
		
		// use HashMap here
				for (int i = 0; i < 1000000; i++) {
		        	table.add(i, "0");
		        }		

		b.buildtreef(freqtable);
		Node rootNode = b.fH.findMin();
		String str = "";
		codeTable = new File("code_table.txt");
		codeTable.createNewFile();
		p = new PrintWriter(codeTable);
		trav(rootNode, str, " ");
		p.close();
	}

	public void trav(Node node, String str, String num) {
		if (node.leftChild == null && node.rightChild == null) {
			str = node.number + str + num;
			p.println(str);
			string = str.split(" ");
			table.set(node.number, string[1]);
			return;
		}
		str = str + num;
		trav(node.leftChild, str, "0");
		trav(node.rightChild, str, "1");
	}
}