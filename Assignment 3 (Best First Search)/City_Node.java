/*  
 Assignment No: 3
 Name: Achala Jadhav
 Roll No: 3301
 Problem Statement: Implement Best First Search
 */

package Best_First_Search;

import java.util.*;

public class City_Node 
{

	String city ;
	int id ;
	int h ;
	int visited =0;

	City_Node(int id,String city,int h,int visited)
	{
		this.city= city;
		this.h= h;
		this.id = id;
		this.visited = visited ;
	}
	 
	public static Comparator<City_Node> h_value= new Comparator<City_Node>() {

		public int compare(City_Node n1, City_Node n2) {

		   int h1 = n1.h;
		   int h2 = n2.h;

		   /*For ascending order*/
		   return h1-h2;

		   /*For descending order*/
		   //rollno2-rollno1;
	   }};
	
	 public String toString() {
	        return  "[ID:"+id+" CITY=" + city + ", heuristic=" + h + "visited:"+visited+"]";
	    }
}