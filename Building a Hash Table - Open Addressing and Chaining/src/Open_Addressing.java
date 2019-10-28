import java.io.*;
import java.util.*;

public class Open_Addressing {
     public int m; // number of SLOTS AVAILABLE
     public int A; // the default random number
     int w;
     int r;
     public int[] Table;

     protected Open_Addressing(int w, int seed, int A) {

         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
         }
        else{
            this.A = A;
        }
         this.Table = new int[m];
         for (int i =0; i<m; i++) {
             Table[i] = -1;
         }
         
     }
     
                 /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;
     }
        /**Implements the hash function g(k)*/
        public int probe(int key, int i) {
        	//g(k, i) = (h(k) + i) mod 2r
        int 	chainValue = ((this.A * key) % (power2(this.w))) >> (this.w - this.r);
        int hashValue = (chainValue + i) % (power2(this.r));        	
        	
        return hashValue;
     }
     
     
     /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int insertKey(int key){
        	int collisionCounter = 0;
        	
        	for (int j = 0; j < this.Table.length; j++)
        	{
        		int hashValue = probe(key, j);
        		if (this.Table[hashValue] < 0)
        		{
        			// the slot is free to be populated
        			this.Table[hashValue] = key;
        			break;	
        		}
        		else
        		{
        			// the slot is not free so we keep checking
        			collisionCounter++;
        		}
        	}
        		

            return collisionCounter;  
        }
        
        /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
        public int insertKeyArray (int[] keyArray){
            int collision = 0;
            for (int key: keyArray) {
                collision += insertKey(key);
            }
            return collision;
        }
            
         /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int removeKey(int key){
        		
        		// ask for the hashcode
        		// for loop i < thisTable.length
        		// if key == table[hashcode], then set to -2, cc++
        		// else if table[hc] == -2, then keep going. cc++
        		// else if table[hc] == -1, then stop looking (however this is also a slot visited, so cc++)
        		// else, we keep looking since the slot is occupied by some other key
        	
        		int collisionCounter = 0;
          	
            	for (int j = 0; j < this.Table.length; j++)
            	{
            		int hashValue = probe(key, j);
            		if (this.Table[hashValue] == key)
            		{
            			// we have found our target element, 
            			// we can replace value with -2 to indicate deletion
            			this.Table[hashValue] = -2;
            			break;	
            		} 
            		else if (this.Table[hashValue] == -2)
            		{
            			// this is a deleted element so we need to keep looking
            			
            			collisionCounter++;
            		}
            		else if (this.Table[hashValue] == -1)
            		{
            			collisionCounter++;
            			break;
            		}
            		else
            		{
            			collisionCounter++;
            		}
            		
            	}
        	
            return collisionCounter;
        }
}
