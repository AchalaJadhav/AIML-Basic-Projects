/*
 Assignment No: 1
 Name: Achala Jadhav
 Roll No: 3301
 Problem Statement: A Salesman must visit each of the cities. There is a road between every pair of cities and the corresponding distances are given. The problem is to find a minimal path that he visits each of city only once and returns to the starting city.
 */

import java.util.*;

class City
{
	String name;							//declaration
	City(String s)							//parameterized constructor
	{
		name=s;
	}
}
class Cities
{
	//initialization and declaration
	int n,start;
	City cities[];
	int distance[][];
	//parameterized constructor
	Cities(int s)
	{
		n=s;
		cities=new City[n];
		distance =new int[n][n];
	}
	//function for accept cities
	public void acceptCities()
	{
		//scanner class
		Scanner scan=new Scanner(System.in);
		System.out.println("____________________________________");
		System.out.println("\nEnter Names of "+n+" Cities\t");
		for(int i=0;i<n;i++)
		{
			System.out.print("\nCITY "+(i+1)+":\t");
			String s=scan.next();
			cities[i]=new City(s);
		}
		System.out.println("____________________________________");
		System.out.println("Enter the distance \t:");
		for(int i=0;i<n;i++)
		{
			System.out.println("-------------------------------------");
			System.out.print("CITY"+(i+1)+":\t");
			for(int j=0;j<n;j++)
			{
				if(i==j)
				{
					
				}
				else
				{
					System.out.print("\nFrom "+cities[i].name+" to "+cities[j].name+":\t");
					distance[i][j]=scan.nextInt();
				}	
			}
		}
		System.out.println("____________________________________");
		int f=0;
		do
		{
			System.out.print("Enter the index of start CITY: ");
			start=scan.nextInt();
			System.out.println("____________________________________");
			
			if(start>=1&&start<=n)
			{
				f=1;
			}
			start=start-1;
		}while(f==0);
		
		
	}
	//function for display
	public void displayMatrix()
	{
		for(int k=0;k<n;k++)
		{
			System.out.print(cities[k].name+"\t");
		}
		System.out.println("\n");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(distance[i][j]+"\t");
			}
			System.out.println();
		}
	}
	//function of DFS
	public void DFS_1()
	{
		//initialization and declaration
		int visited[]=new int[n];
		int dist=-1;
		int index;
		System.out.println("\nROUTE\t:");
		index=DFS(visited,start,dist);
		//if distance between current node and start node is not 0
		if(distance[index][start]!=0)
		{
			//print start city
			System.out.println(cities[start].name);
			dist=visited[index]+distance[index][start]+1;
			System.out.println("TOTAL DISTANCE:\t"+dist);
		}
		else
		{
			System.out.println("NO PATH FURTHER");
			dist=visited[index]+1;
			System.out.println("TOTAL DISTANCE IS "+dist);
		}
	}
	public int DFS(int visited[],int i,int dist)
	{
		//create object of cities
		City c=cities[i];
		int r=i;
		System.out.print(cities[i].name+" ---> ");
		visited[i]=dist;
		for(int j=0;j<n;j++)
		{
			//if distance is not 0 and node is not visited
			if(distance[i][j]!=0 && visited[j]==0)
			{
				//add distance 
				dist=dist+distance[i][j];
				r=DFS(visited,j,dist);
			}
		}
		return r;
	}
	//function for BFS
	public void hillClimbing_1()
	{
		//initialization and declaration
		int visited[]=new int[n];
		int dist=1;
		int index;
		System.out.println("\nROUTE\t:");
		index=DFS_hill(visited,start,dist);
		//if distance between current node and start node is not 0
		if(distance[index][start]!=0)
		{
			//print start city
			System.out.println(cities[start].name);
			dist=visited[index]+distance[index][start]-1;
			System.out.println("TOTAL DISTANCE:\t"+dist);
		}
		else
		{
			System.out.println("NO PATH FURTHER");
			dist=visited[index]-1;
			System.out.println("TOTAL DISTANCE IS "+dist);
		}
	}
	public int DFS_hill(int visited[],int i,int dist)
	{
		//create object of cities
		City c=cities[i];
		int r=i;
		System.out.print(cities[i].name+" ---> ");
		visited[i]=dist;
		int min=Integer.MAX_VALUE;
		int min_Index=-1;
		int j=0;
		for(j=0;j<n;j++)
		{
			//if distance is not 0 and node is not visited
			if(distance[i][j]!=0 && visited[j]==0)
			{
				//if distance is less than min
				if(distance[i][j]<min)
				{
					//new min distance will be min
					min=distance[i][j];
					min_Index=j;
				}
				
			}
		}
		//if index is not -1
		if(min_Index!=-1)
		{
			//add distance
			dist=dist+distance[i][min_Index];
			r=DFS_hill(visited,min_Index,dist);
		}
		return r;
	}
}
public class TSP{

	public static void main(String[] args) {
		//declaration and initialization
		int choice,ans;
		Scanner scan=new Scanner(System.in);
		System.out.println("____________________________________");
		System.out.print("Enter the total number of cities\t:\t");
		int n=scan.nextInt();
		Cities object=new Cities(n);
		do
		{
			System.out.println("____________________________________");
			System.out.println("\n...MENU...: "
					+ "\n1. Accept start city"
					+ "\n2. Display matrix"
					+ "\n3. Using DFS"
					+ "\n4. Using BFS"
					+ "\n5. Exit");
			System.out.println("\nEnter your choice: ");
			choice=scan.nextInt();
			System.out.println("____________________________________");
			switch(choice)
			{
			
				case 1:
					System.out.println("ACCEPT CITIES");
					object.acceptCities();
					break;
				case 2:
					System.out.println("____________________________________");
					System.out.println("DISPLAY MATRIX");
					object.displayMatrix();
					System.out.println("____________________________________");
					break;
				case 3:
					System.out.println("____________________________________");
					System.out.println("USING DFS");
					object.DFS_1();
					System.out.println("____________________________________");
					break;
				case 4:
					System.out.println("____________________________________");
					System.out.println("USING BFS");
					object.hillClimbing_1();
					System.out.println("____________________________________");
					break;
				case 5:
					break;	
			}
			System.out.println("Do you want to continue?? Press 1 for YES and 0 for NO.");
			ans=scan.nextInt();
			
		}while(ans==1);
		
		
	}

}

/*
 
 ================================================================================ 
  									OUTPUT
 ================================================================================ 

____________________________________
Enter the total number of cities	:	5
____________________________________

...MENU...: 
1. Accept start city
2. Display matrix
3. Using DFS
4. Using BFS
5. Exit

Enter your choice: 
1
____________________________________
ACCEPT CITIES
____________________________________

Enter Names of 5 Cities	

CITY1:	A

CITY2:	B

CITY3:	C

CITY4:	D

CITY5:	E
____________________________________
Enter the distance 	:
-------------------------------------
CITY1:	
From A to B:	7

From A to C:	6

From A to D:	10

From A to E:	13
-------------------------------------
CITY2:	
From B to A:	7

From B to C:	7

From B to D:	10

From B to E:	10
-------------------------------------
CITY3:	
From C to A:	6

From C to B:	7

From C to D:	5

From C to E:	9
-------------------------------------
CITY4:	
From D to A:	10

From D to B:	10

From D to C:	5

From D to E:	6
-------------------------------------
CITY5:	
From E to A:	13

From E to B:	10

From E to C:	9

From E to D:	6
____________________________________
Enter the index of start CITY:1
____________________________________
Do you want to continue?? Press 1 for YES and 0 for NO.
1
____________________________________

...MENU...: 
1. Accept start city
2. Display matrix
3. Using DFS
4. Using BFS
5. Exit

Enter your choice: 
2
____________________________________
____________________________________
DISPLAY MATRIX
A	B 	C 	D 	E  

0	7	6	10	13	
7	0	7	10	10	
6	7	0	5	9	
10	10	5	0	6	
13	10	9	6	0	
____________________________________
Do you want to continue?? Press 1 for YES and 0 for NO.
1
____________________________________

...MENU...: 
1. Accept start city
2. Display matrix
3. Using DFS
4. Using BFS
5. Exit

Enter your choice: 
3
____________________________________
____________________________________
USING DFS

ROUTE	:
A ---> B ---> C ---> D ---> E ---> A
TOTAL DISTANCE:	38
____________________________________
Do you want to continue?? Press 1 for YES and 0 for NO.
1
____________________________________

...MENU...: 
1. Accept start city
2. Display matrix
3. Using DFS
4. Using BFS
5. Exit

Enter your choice: 
4
____________________________________
____________________________________
USING BFS

ROUTE	:
A ---> C ---> D ---> E ---> B ---> A
TOTAL DISTANCE:	34
____________________________________
Do you want to continue?? Press 1 for YES and 0 for NO.
1
____________________________________

...MENU...: 
1. Accept start city
2. Display matrix
3. Using DFS
4. Using BFS
5. Exit

Enter your choice: 
5
____________________________________
Do you want to continue?? Press 1 for YES and 0 for NO.
0


*/