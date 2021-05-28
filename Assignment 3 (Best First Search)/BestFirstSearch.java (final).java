import java.io.*;
import java.util.*;
/*class Edge{
	int start=0;
	//int end=0;
	int hv=0;
	//int weight=0;
	Edge(int h,int s)
	{
		start=s;
		//end=e;
		hv=h;
		//weight=w;
	}
	int gethv()
	{
		return this.hv;
	}
}*/
class Graph
{
	Scanner sc=new Scanner(System.in);
	int adjmat[][];
	int visited[];
	int ne,nv;
	int heurasticval[];
	int nextvertex;
	void accept()
	{
		System.out.println("Enter the no of vertices: ");
		nv=sc.nextInt();
		System.out.println("Enter the no of edges: ");
		ne=sc.nextInt();
		visited=new int[nv];
		adjmat=new int[nv][nv];
		heurasticval=new int[nv];
		
		for (int i = 0; i < ne; i++) {
			System.out.println("Enter start vertex: ");
			int sv=sc.nextInt();
			System.out.println("Enter end vertex: ");
			int ev=sc.nextInt();
			System.out.println("Enter weight for edge "+sv+" - "+ev+": ");
			int wt=sc.nextInt();
			adjmat[sv][ev]=wt;
			adjmat[ev][sv]=wt;
		}
		
		for(int i=0;i<nv;i++)
		{
			System.out.println("Enter heurastic value for vertex "+(i)+" : ");
			heurasticval[i]=sc.nextInt();
		}
		
		//Display
		System.out.println(" -Adjacency Matrix- ");
		for(int i=0;i<nv;i++)
		{
			for(int j=0;j<nv;j++)
			{
				System.out.print("| "+adjmat[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("\n -Heurastic Values- ");
		for (int i = 0; i < nv; i++) {
			System.out.print(i+"   ");
		}
		System.out.println("\n-----------------------------------");
		for (int i = 0; i < nv; i++) {
			System.out.print(heurasticval[i]+"   ");
		}
		System.out.println();
	}
	
	int getnode(int hv)
	{
		int i=0;
		for(i=0;i<nv;i++)
		{
			if(heurasticval[i]==hv)
				break;
		}
		return i;
	}
	void BFS()
	{
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		int closelist[]=new int[10];
		int k=0,finalcost=0;
		int s=0;
		System.out.print("\nEnter start vertex:  ");
		int source=sc.nextInt();
		pq.add(heurasticval[source]);
		visited[source]=1;
		System.out.println("\nPriority queue");
		while(heurasticval[s]!=0)
		{
			int temp=pq.remove();
			s=getnode(temp);
			closelist[k]=s;
			k++;
			for(int j=0;j<nv;j++)
			{
				if(adjmat[s][j]!=0 && visited[j]==0)
				{
					visited[j]=1;
					pq.add(heurasticval[j]);
				}
			}
			System.out.println(pq);
		}
		System.out.print("\nPath: [");
		for(int i=0;i<k;i++)
		{
			System.out.print(closelist[i]+" ");
			if(i<(k-1))
				finalcost=finalcost+adjmat[closelist[i]][closelist[i+1]];			//f(n)=g g-distance between nodes
		}
		System.out.println("]\nCost: "+finalcost);

	}
}
public class BestFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g=new Graph();
		System.out.println(" --BFS With Heurastic Technique-- ");
		g.accept();
		g.BFS();

	}

}
/*
 * Output:
--BFS With Heurastic Technique-- 
Enter the no of vertices: 
10
Enter the no of edges: 
14
Enter start vertex: 
0
Enter end vertex: 
1
Enter weight for edge: 
6
Enter start vertex: 
0
Enter end vertex: 
2
Enter weight for edge: 
3
Enter start vertex: 
1
Enter end vertex: 
3
Enter weight for edge: 
3
Enter start vertex: 
1
Enter end vertex: 
4
Enter weight for edge: 
2
Enter start vertex: 
2
Enter end vertex: 
5
Enter weight for edge: 
1
Enter start vertex: 
2
Enter end vertex: 
6
Enter weight for edge: 
7
Enter start vertex: 
3
Enter end vertex: 
7
Enter weight for edge: 
5
Enter start vertex: 
4
Enter end vertex: 
7
Enter weight for edge: 
8
Enter start vertex: 
5
Enter end vertex: 
8
Enter weight for edge: 
3
Enter start vertex: 
6
Enter end vertex: 
8
Enter weight for edge: 
2
Enter start vertex: 
3
Enter end vertex: 
4
Enter weight for edge: 
1
Enter start vertex: 
7
Enter end vertex: 
9
Enter weight for edge: 
5
Enter start vertex: 
8
Enter end vertex: 
9
Enter weight for edge: 
3
Enter start vertex: 
7
Enter end vertex: 
8
Enter weight for edge: 
5
Enter heurastic value for vertex 0 : 
10
Enter heurastic value for vertex 1 : 
8
Enter heurastic value for vertex 2 : 
6
Enter heurastic value for vertex 3 : 
5
Enter heurastic value for vertex 4 : 
7
Enter heurastic value for vertex 5 : 
5
Enter heurastic value for vertex 6 : 
3
Enter heurastic value for vertex 7 : 
3
Enter heurastic value for vertex 8 : 
1
Enter heurastic value for vertex 9 : 
0
-Adjacency Matrix- 
| 0	| 6	| 3	| 0	| 0	| 0	| 0	| 0	| 0	| 0	
| 6	| 0	| 0	| 3	| 2	| 0	| 0	| 0	| 0	| 0	
| 3	| 0	| 0	| 0	| 0	| 1	| 7	| 0	| 0	| 0	
| 0	| 3	| 0	| 0	| 1	| 0	| 0	| 5	| 0	| 0	
| 0	| 2	| 0	| 1	| 0	| 0	| 0	| 8	| 0	| 0	
| 0	| 0	| 1	| 0	| 0	| 0	| 0	| 0	| 3	| 0	
| 0	| 0	| 7	| 0	| 0	| 0	| 0	| 0	| 2	| 0	
| 0	| 0	| 0	| 5	| 8	| 0	| 0	| 0	| 5	| 5	
| 0	| 0	| 0	| 0	| 0	| 3	| 2	| 5	| 0	| 3	
| 0	| 0	| 0	| 0	| 0	| 0	| 0	| 5	| 3	| 0	

-Heurastic Values- 
0   1   2   3   4   5   6   7   8   9   
-----------------------------------
10   8   6   5   7   5   3   3   1   0   

Enter start vertex:  0

Priority queue
[6, 8]
[3, 8, 5]
[1, 8, 5]
[0, 3, 5, 8]
[3, 8, 5]

Path: [0 2 6 8 9 ]
Cost: 15
*/


/*
====================================================================
						OUTPUT
====================================================================
 --BFS With Heurastic Technique-- 
Enter the no of vertices: 
5
Enter the no of edges: 
7
Enter start vertex: 
0
Enter end vertex: 
1
Enter weight for edge 0 - 1: 
1
Enter start vertex: 
0
Enter end vertex: 
2
Enter weight for edge 0 - 2: 
4
Enter start vertex: 
1
Enter end vertex: 
2
Enter weight for edge 1 - 2: 
2
Enter start vertex: 
1
Enter end vertex: 
4
Enter weight for edge 1 - 4: 
12
Enter start vertex: 
1
Enter end vertex: 
3
Enter weight for edge 1 - 3: 
5
Enter start vertex: 
2
Enter end vertex: 
3
Enter weight for edge 2 - 3: 
2
Enter start vertex: 
3
Enter end vertex: 
4
Enter weight for edge 3 - 4: 
3
Enter heurastic value for vertex 0 : 
7
Enter heurastic value for vertex 1 : 
6
Enter heurastic value for vertex 2 : 
2
Enter heurastic value for vertex 3 : 
1
Enter heurastic value for vertex 4 : 
0
 -Adjacency Matrix- 
| 0	| 1	| 4	| 0	| 0	
| 1	| 0	| 2	| 5	| 12	
| 4	| 2	| 0	| 2	| 0	
| 0	| 5	| 2	| 0	| 3	
| 0	| 12	| 0	| 3	| 0	

 -Heurastic Values- 
0   1   2   3   4   
-----------------------------------
7   6   2   1   0   

Enter start vertex:  0

Priority queue
[2, 6]
[1, 6]
[0, 6]
[6]

Path: [0 2 3 4 ]
Cost: 9


*/