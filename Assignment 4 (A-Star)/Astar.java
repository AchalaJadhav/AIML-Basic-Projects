import java.io.*;
import java.util.*;

class Node{
int cost;
int heu;
int data;
int value;

Node(int d){
data = d;
}

Node(int d, int h, int c, int v){
data = d;
heu = h;
cost = c;
value = v;
}

}

class AstarComparator implements Comparator<Node>{

public int compare(Node n1, Node n2){
if(n1.value == n2.value) return 0;
else if(n1.value > n2.value) return 1;
else return -1;
}
}
public class Astar
{
	int[][] map;
	int num_v;
	int num_e;
	boolean visited[];
	int[] H;
	ArrayList<Integer> path;


	Astar(int v, int e){
	num_v = v+1;
	num_e = e+1;
	map = new int[num_v][num_v];
	for(int i=0; i<num_v; i++){
	map[i] = new int[num_v];
	}
	visited = new boolean[num_v];
	path = new ArrayList<Integer>();
	H = new int[num_v];
	}

	void buildmap(){

	Scanner sc = new Scanner(System.in);
	for(int i=1; i<num_e; i++){
	System.out.println("Enter the vertex pair and the cost: ");
	int v1 = sc.nextInt();
	int v2 = sc.nextInt();
	int cost = sc.nextInt();
	map[v1][v2] = cost;
	map[v2][v1] = cost;
	}


	}

	void buildheuristics(){

	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the heuristic values: ");
	for(int i=1; i<num_v; i++){
	H[i] = sc.nextInt();
	}

	}


	void printmap(){
	for(int i=1; i<num_v; i++){
	for(int j=1; j<num_v; j++)
	System.out.print(map[i][j]+" ");
	System.out.println();
	}
	}

	void findnode(int start, int goal){
	int finalCost=0;
	PriorityQueue<Node> PQ = new PriorityQueue<Node>(num_v, new AstarComparator());
	for(int i=0; i<num_v; i++)
	visited[i] = false;
	PQ.add(new Node(start,H[1],0,H[1]+0));
	visited[start] = true;
	while(!PQ.isEmpty()){
	Node n = PQ.remove();
	path.add(n.data);
	if(n.data==goal) break;
	else{
	for(int i=0; i<num_v; i++){
	if(map[n.data][i]!=0 /*&& !visited[i]*/){
	visited[i] = true;
	int dist = H[i]+map[n.data][i]+n.cost;
	PQ.add(new Node(i,H[i],map[n.data][i],dist));
	}
	}
	}
	for(Node x: PQ)
	System.out.print("["+x.data+","+x.value+"] ");
	System.out.println();
	}
	int i=0;
	System.out.println("Path is: "+path);
	ArrayList<Integer> a = new ArrayList<Integer>();
	for (Integer x: path)
	{
	if(a.contains(x))
	{
	a.remove(x);
	a.add(x);
	}
	else
	a.add(x);
	
	}
	System.out.println("A: "+a);
	while(i<a.size()-1)
	{
	if(map[a.get(i)][a.get(i+1)]!=0)
	{
	finalCost=finalCost+map[a.get(i)][a.get(i+1)];
	i++;
	}
	else
	{

	finalCost=finalCost-map[a.get(i-1)][a.get(i)];
	a.remove(i);
	i=0;
	}
	}
	System.out.println("COST : "+finalCost);
	}



	public static void main(String[] args) 
	{
	Scanner sc =  new Scanner(System.in);
	System.out.println("Enter the number of vertices and edges");
	int v=sc.nextInt();
	int e=sc.nextInt();
	Astar A = new Astar(v,e);
	A.buildheuristics();
	A.buildmap();
	System.out.println("Enter the initial and goal state");
	int start=sc.nextInt();
	int goal=sc.nextInt();
	A.findnode(start,goal);
	}

}



/*

======================================================
					OUTPUT
======================================================

Enter the number of vertices and edges
5
7
Enter the heuristic values: 7
6
2
1
0
Enter the vertex pair and the cost: 
1
2
1
Enter the vertex pair and the cost: 
1
3
4
Enter the vertex pair and the cost: 
2
3
2
Enter the vertex pair and the cost: 
2
4
12
Enter the vertex pair and the cost: 
4
5
3
Enter the vertex pair and the cost: 
3
4
2
Enter the vertex pair and the cost: 
2
4
5
Enter the initial and goal state
1
5
[3,6] [2,7] 
[2,7] [4,7] [2,12] [1,15] 
[3,5] [4,7] [4,7] [1,15] [1,9] [2,12] 
[4,5] [4,7] [4,7] [1,9] [2,12] [1,13] [2,10] [1,15] 
[5,5] [3,6] [4,7] [1,9] [4,7] [1,13] [2,10] [1,15] [2,13] [2,12] 
Path is: [1, 3, 2, 3, 4, 5]
A: [1, 2, 3, 4, 5]
COST : 8





*/