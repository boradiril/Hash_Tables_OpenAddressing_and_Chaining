import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		System.out.println("---This is the tester ---");
		
		System.out.println("Running checks");
		Open_Addressing openMap = new Open_Addressing(10, 0, -1);
		Chaining chainingMap = new Chaining(10, 0, -1);
		
		int chain = chainingMap.chain(1);
		System.out.println("Chaining chain check:"+(chain==30));
		
		chainingMap.insertKey(1);
		System.out.println("Chaining insert check:" + ((chainingMap.Table.get(30).size()==1) && (chainingMap.insertKey(1) == 1)));
		
		int probe = openMap.probe(1, 1);
		System.out.println("Open Addressing probe check:"+(probe==31));
		
		// testingOpenAddressing(openMap);
		openMap.insertKey(0);
		System.out.println("Open Addressing insert check:"+(openMap.Table[0]==0));
		
		// testingOpenAddressingRemove(openMap);
	
		openMap.insertKey(1);
		openMap.removeKey(1);
		System.out.println("Open Addressing remove check:"+(openMap.Table[30]!=1));
	}
	public static void testingOpenAddressing(Open_Addressing openMap)
	{
				//30
				System.out.println("------ 30 -------");
				System.out.println("(0,0) : " + openMap.probe(0, 0));
				System.out.println("0 : " + (openMap.insertKey(0)) + " " + (openMap.Table[0] == 0));
				System.out.println();

				System.out.println("(1,0) : " + openMap.probe(1, 0));
				System.out.println("1 : " + (openMap.insertKey(1)) + " " + (openMap.Table[30] == 1));
				System.out.println();

				System.out.println("(61,0) : " + openMap.probe(61,0));
				System.out.println("61 : " + (openMap.insertKey(61)) + " " + (openMap.Table[31] == 61));
				System.out.println();

				System.out.println("(81,0) : " + openMap.probe(81,0));
				System.out.println("81 : " + (openMap.insertKey(81)) + " " + (openMap.Table[1] == 81));
				System.out.println();

				System.out.println(Arrays.toString(openMap.Table));
				System.out.println();

				// 9
				System.out.println("------ 9 -------");
				System.out.println("(54,0) : " + openMap.probe(54,0));
				System.out.println("54 : " + (openMap.insertKey(54)) + " " + (openMap.Table[9] == 54));
				System.out.println();

				System.out.println("(175,0) : " + openMap.probe(175,0));
				System.out.println("175 : " + (openMap.insertKey(175)) + " " + (openMap.Table[10] == 175));
				System.out.println();

				System.out.println(Arrays.toString(openMap.Table));

				System.out.println();

				
				//8
				System.out.println("------ 8 -------");
				System.out.println("(55,0) : " + openMap.probe(55,0));
				System.out.println("55 : " + (openMap.insertKey(55)) + " " + (openMap.Table[8] == 55));
				System.out.println();

				System.out.println(Arrays.toString(openMap.Table));
				System.out.println();

				//5
				System.out.println("------ 5 -------");
				System.out.println("(57,0) : " + openMap.probe(57,0));
				System.out.println("57 : " + (openMap.insertKey(57)) + " " + (openMap.Table[5] == 57));
				System.out.println();


				System.out.println("(197,0) : " + openMap.probe(197,0));
				System.out.println("197 : " + (openMap.insertKey(197)) + " " + (openMap.Table[6] == 197));
				System.out.println();


				System.out.println("(177,0) : " + openMap.probe(177,0));
				System.out.println("177 : " + (openMap.insertKey(177)) + " " + (openMap.Table[7] == 177));
				System.out.println();

				System.out.println(Arrays.toString(openMap.Table));
				System.out.println();

				//3
				openMap.insertKey(58);
				openMap.insertKey(78);
				openMap.insertKey(58);
				System.out.println("------ 3 -------");
				System.out.println("(58,0) : " + openMap.probe(58,0));
				System.out.println("(78,0) : " + openMap.probe(78,0));
				System.out.println();

	}
	
	public static void testingOpenAddressingRemove(Open_Addressing openMap)
	{
		openMap.removeKey(0);
		System.out.println(Arrays.toString(openMap.Table));
		openMap.removeKey(81);
		System.out.println(Arrays.toString(openMap.Table));
		openMap.insertKey(81);
		System.out.println(Arrays.toString(openMap.Table));
		int i = openMap.removeKey(58);
		int j = openMap.removeKey(58);
		System.out.println(i);
		System.out.println(j);
	
	}
}
