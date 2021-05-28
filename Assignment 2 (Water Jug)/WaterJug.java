/*  
 Assignment No: 2
 Name: Achala Jadhav
 Roll No: 3301
 Problem Statement: Implement Water Jug Problem.
 */

import java.util.*;
public class WaterJug 
{

	public static void main(String[] args) 
	{
		Calculation p=new Calculation();
		p.solution();
	}
}
class Calculation
{
	Scanner s=new Scanner(System.in);
	int m,n,m_max,n_max;
	int goal1, goal2;
	public Calculation()
	{
		m=0;
		n=0;
		m_max=0;
		n_max=0;
		goal1=0;
		goal2=0;
	}
	public void solution()
	{
		System.out.print("Enter maximum amount of water in m:");
		m_max=s.nextInt();
		System.out.print("Enter maximum amount of water in n:");
		n_max=s.nextInt();
		System.out.print("Enter goal1:");
		goal1=s.nextInt();
		System.out.print("Enter goal2:");
		goal2=s.nextInt();
		if(goal1>m_max || goal2>n_max || (m_max%n_max==0 || n_max%m_max==0) || (m_max%2==0 && n_max%2==0 && (goal1%2==1 ||goal2%2==1))) 
		{
			System.out.println("\nNot Possible...");
		}
		else
		{
			m=0;
			n=0;
			System.out.println(m+","+n);
			int flag=0;
			if(goal2==0)
			{
				while(flag!=1)
				{
					if((m==goal1) && (n==goal2))
					{
						flag=1;
					}
					else if(this.m==0)
					{
						fillM();
					}
			
					else if ((this.m > 0) && (this.n != this.n_max)) 
					{
						transferMtoN();
			
					}
					else if(this.n==0)
					{
						fillN();
					}
					else if ((this.m > 0) && (this.n == this.n_max)) 
					{
						emptyN();
					}
				}
			}
			int f=0;
			if(goal1==0)
			{
				while(f!=1)
				{
					if((m==goal1) && (n==goal2))
					{
						f=1;
					}
					else if(this.n==0)
					{
						fillN();
					}
		
					else if ((this.n > 0) && (this.m != this.m_max)) 
					{
						transferNtoM();
		
					}
					else if(this.m==0)
					{
						fillM();
					}
					else if ((this.n > 0) && (this.m == this.m_max)) 
					{
						emptyM();
					}
				}
			}
		}
	}
	void fillM()
	{
		m=m_max;
		System.out.println(m+","+n);
	
	}
	void fillN()
	{
		n=n_max;
		System.out.println(m+","+n);
	
	}
	void transferMtoN()
	{
		int fin = 0;
	
		while(fin != 1) 
		{
	
			n += 1;
			m -= 1;
			
			if((n == n_max) || (m == 0)) { fin = 1;}
		
		}
		
		System.out.println(m + "," + n );
	}
	void transferNtoM()
	{
		int fin = 0;
		
		while(fin != 1) 
		{
		
			m += 1;
			n -= 1;
		
			if((m == m_max) || (n == 0)) { fin = 1;}
		
		}
		
		System.out.println(m + "," + n );
	}
	private void emptyN()
	{
		n=0;
		System.out.println(m+","+n);
	}
	private void emptyM()
	{
		m=0;
		System.out.println(m+","+n);
	}
}


/*
===================================================================
							OUTPUT
===================================================================
Enter maximum amount of water in m:4
Enter maximum amount of water in n:9
Enter goal1:2
Enter goal2:0
0,0
4,0
0,4
4,4
0,8
4,8
3,9
3,0
0,3
4,3
0,7
4,7
2,9
2,0

*/