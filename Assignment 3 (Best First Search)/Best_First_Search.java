/*  
 Assignment No: 3
 Name: Achala Jadhav
 Roll No: 3301
 Problem Statement: Implement Best First Search
 */

package Best_First_Search;

import java.util.*;

public class Best_First_Search
{

	public static ArrayList<City_Node> list = new ArrayList<City_Node>(); //contains cityname,heuristic value,visited or not-used for creating graph
	public static int connected[][] ; //connectivity between cities, used for creating graph
	public static ArrayList<City_Node> openlist = new ArrayList<City_Node>();//temporary storage of nodes
	public static int visited[] ; //temporal visited array
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of cities:");
		int n= scan.nextInt();
		
		connected = new int[n][n];
		visited = new int[n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				connected[i][j] = 0;
		
		for(int i=0;i<n;i++)
			visited[i] = 0;
		
		for(int i=0;i<n;i++)  //entering cities and their heuristic values
		{
			System.out.println("Enter the city "+i+" :");
			String city = scan.next();
			System.out.println("Enter its heuristic value for city "+i+" :");
			int h = scan.nextInt();
			list.add(new City_Node(i,city,h,0));
		}
		for(City_Node c:list)
		{
			System.out.println("City id:"+c.id+"\t"+"City:"+c.city+"\t"+"Heuristic value:"+c.h+"\t"+"Visited status:"+c.visited);
		}
		for(City_Node c:list) //entering connectivity between cities
		{
			int flag = 0;
			while(true)
			{
				System.out.println("City "+c.city+" is connected to city no ?");
				int no = scan.nextInt();
				connected[c.id][no] = 1;
				System.out.println("Is it connected to more cities?(yes =1,no=0)");
				flag = scan.nextInt();
				if(flag == 0)
				break ;
			}
		}
		
		System.out.println("Enter the starting city id:"); //starting with algorithm
		int id = scan.nextInt();
		for(City_Node c: list)
		{
			if(c.id == id)
			{
				openlist.add(new City_Node(c.id,c.city,c.h,1));
				visited[id] = 1;
			}
		}
		Best_FS(id,n);
		scan.close();
	}

	static void Best_FS(int id,int nc)
	{
		int idd =id ;
		int flag= 0; 
		while(true)
		{
		for(City_Node c:list)
		{
			if(c.id == idd)
			{
				System.out.println("City id:"+c.id+" City:"+c.city+" Heuristic value:"+c.h);
				for(int i=0;i<nc;i++)
				{
					if(connected[idd][i] ==1 && visited[i]==0)
						traversal(i); 
				}
				
				break ;
			}
		}
		
		Collections.sort(openlist, City_Node.h_value);
		
		for(City_Node n :openlist)
		{
			if(n.visited == 0)
			{
			   n.visited = 1 ;
			   visited[n.id]=1;
			   idd = n.id ;
			   break ;
			}
			if(n.h ==0)
				flag =1;
		}
		
		if(flag ==1)
			break ;
		}
	}
	static void traversal(int id)
	{
		for(City_Node c: list)
		{
			if(c.id == id )
			{
				openlist.add(new City_Node(c.id,c.city,c.h,0));
				break ;
			}
		}	
	}
}

/*
OUTPUT :
Enter the no of cities:
11
Enter the city 0 :
S
Enter its heuristic value for city 0 :
15
Enter the city 1 :
A
Enter its heuristic value for city 1 :
11
Enter the city 2 :
B
Enter its heuristic value for city 2 :
5
Enter the city 3 :
C
Enter its heuristic value for city 3 :
9
Enter the city 4 :
D
Enter its heuristic value for city 4 :
9
Enter the city 5 :
E
Enter its heuristic value for city 5 :
4
Enter the city 6 :
F
Enter its heuristic value for city 6 :
2
Enter the city 7 :
G
Enter its heuristic value for city 7 :
0
Enter the city 8 :
H
Enter its heuristic value for city 8 :
7
Enter the city 9 :
I
Enter its heuristic value for city 9 :
3
Enter the city 10 :
J
Enter its heuristic value for city 10 :
3
City id:0	 City:S	 Heuristic value:15	 Visited status:0
City id:1	 City:A	 Heuristic value:11	 Visited status:0
City id:2	 City:B	 Heuristic value:5	 Visited status:0
City id:3	 City:C	 Heuristic value:9	 Visited status:0
City id:4	 City:D	 Heuristic value:9	 Visited status:0
City id:5	 City:E	 Heuristic value:4	 Visited status:0
City id:6	 City:F	 Heuristic value:2	 Visited status:0
City id:7	 City:G	 Heuristic value:0	 Visited status:0
City id:8	 City:H	 Heuristic value:7	 Visited status:0
City id:9	 City:I	 Heuristic value:3	 Visited status:0
City id:10	 City:J	 Heuristic value:3	 Visited status:0
City S is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
1
City S is connected to city no ?
2
Is it connected to more cities?(yes =1,no=0)
0
City A is connected to city no ?
3
Is it connected to more cities?(yes =1,no=0)
1
City A is connected to city no ?
4
Is it connected to more cities?(yes =1,no=0)
0
City B is connected to city no ?
5
Is it connected to more cities?(yes =1,no=0)
1
City B is connected to city no ?
6
Is it connected to more cities?(yes =1,no=0)
0
City C is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
0
City D is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
0
City E is connected to city no ?
8
Is it connected to more cities?(yes =1,no=0)
1
City E is connected to city no ?
9
Is it connected to more cities?(yes =1,no=0)
0
City F is connected to city no ?
7
Is it connected to more cities?(yes =1,no=0)
1
City F is connected to city no ?
10
Is it connected to more cities?(yes =1,no=0)
0
City G is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
0
City H is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
0
City I is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
0
City J is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
0
Enter the starting city id:
0
City id:0 City:S Heuristic value:15
City id:2 City:B Heuristic value:5
City id:6 City:F Heuristic value:2
City id:7 City:G Heuristic value:0
*/



/*
 =======================================================================
 						OUTPUT
 =======================================================================
 Enter the no of cities:
5
Enter the city 0 :
S
Enter its heuristic value for city 0 :
7
Enter the city 1 :
A
Enter its heuristic value for city 1 :
6
Enter the city 2 :
B
Enter its heuristic value for city 2 :
2
Enter the city 3 :
C
Enter its heuristic value for city 3 :
1
Enter the city 4 :
D
Enter its heuristic value for city 4 :
0
City id:0	City:S	Heuristic value:7	Visited status:0
City id:1	City:A	Heuristic value:6	Visited status:0
City id:2	City:B	Heuristic value:2	Visited status:0
City id:3	City:C	Heuristic value:1	Visited status:0
City id:4	City:D	Heuristic value:0	Visited status:0
City S is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
1
City S is connected to city no ?
2
Is it connected to more cities?(yes =1,no=0)
0
City A is connected to city no ?
0
Is it connected to more cities?(yes =1,no=0)
1
City A is connected to city no ?
2
Is it connected to more cities?(yes =1,no=0)
1
City A is connected to city no ?
3
Is it connected to more cities?(yes =1,no=0)
1
City A is connected to city no ?
4
Is it connected to more cities?(yes =1,no=0)
0
City B is connected to city no ?
0
Is it connected to more cities?(yes =1,no=0)
1
City B is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
1
City B is connected to city no ?
3
Is it connected to more cities?(yes =1,no=0)
0
City C is connected to city no ?
2
Is it connected to more cities?(yes =1,no=0)
1
City C is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
1
City C is connected to city no ?
4
Is it connected to more cities?(yes =1,no=0)
0
City D is connected to city no ?
1
Is it connected to more cities?(yes =1,no=0)
1
City D is connected to city no ?
3
Is it connected to more cities?(yes =1,no=0)
0
Enter the starting city id:
0
City id:0 City:S Heuristic value:7
City id:2 City:B Heuristic value:2
City id:3 City:C Heuristic value:1
City id:4 City:D Heuristic value:0

*/