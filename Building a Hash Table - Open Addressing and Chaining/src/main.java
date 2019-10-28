import java.io.*;
import java.util.*;


public class main {     
	
	public static int power2(int w) {
         return (int) Math.pow(2, w);
     }

    public static int findW(int A)
    {
    		int currW = 0;
    		while((A - power2(currW)) > 0)
    		{
    			currW++;
    		}	
    	
    		return currW;
    }
    
    public static void chainEmIn(int A, int w, int [] array)
    {
	    	Chaining chainMap = new Chaining(w, 0, A);
	    	//System.out.println(chainMap.Table.toString());
	    	int collisions = chainMap.insertKeyArray(array);
	    	System.out.println("collisions : " + collisions);
	    //	System.out.println(chainMap.Table.toString());
    }
    
    public static void openEmIn(int A, int w, int [] array)
    {
    		Open_Addressing openMap = new Open_Addressing(w, 0, A);
		//System.out.println(Arrays.toString(openMap.Table));
    		int collisions = openMap.insertKeyArray(array);
    		//System.out.println(Arrays.toString(openMap.Table));
        	System.out.println("collisions : " + collisions);	
    }
    
    public static void main(String[] args) {
   // Builds the hash table and inserts keys using the insertKeyArray function.
   // 	(1018, '{52, 71, 34, 95, 68, 25, 44, 38, 47, 77, 92, 84, 94, 12, 61, 9, 89, 56, 28, 75}')
   // 	(590, '{79, 13, 45, 64, 32, 95, 67, 27, 78, 18, 41, 69, 15, 29, 72, 57, 81, 50, 60, 14}')
    	
    	int Ax = 1018;
    	int wX = findW(Ax);
    	int [] listX = new int [] {52, 71, 34, 95, 68, 25, 44, 38, 47, 77, 92, 84, 94, 12, 61, 9, 89, 56, 28, 75};
    	System.out.println("--- chain X ---");
    	chainEmIn(Ax, wX, listX);
   	System.out.println("--- open X ---");
    	openEmIn(Ax, wX, listX);
   	
    	
    	int Ay = 590;
    	int wY = findW(Ay);
    	int [] listY = new int [] {79, 13, 45, 64, 32, 95, 67, 27, 78, 18, 41, 69, 15, 29, 72, 57, 81, 50, 60, 14};
    	System.out.println("--- chain Y ---");
    	chainEmIn(Ay, wY, listY);
    	System.out.println("--- open Y ---");
    	openEmIn(Ay, wY, listY);
    	
    }
    
   
}