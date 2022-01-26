# Data Structure & Algorithm (Java) Assignmets 04 (Solved)
___
# [Assignment: 04](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/Readme/Assignment-04.md)
#### Assignment 04 word file (with Code & ScreenShots) : [DSA_Assignment-04.docs]()
## Question No 01:									5 Marks
Consider the set of 6 processes whose arrival time and burst time are given below-

![question](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Question/question.JPG)

If the CPU scheduling policy is Round Robin with time quantum = 2, 
calculate the average waiting time and average turnaround time. (Show all steps of solution)
Implement Round Robin policy in Java Programming language 
Note: C language code is already available in Lab Manual
### Code:
#### main.java:
```
public class main {
	
	public static void main(String args[]) throws Exception {

		scheduling ob = new scheduling();

		ob.roundrobin();

	}
}
```
#### scheduling.java:
```
import java.io.*;

public class scheduling {
	
	public void roundrobin() throws Exception, IOException {
	
		System.out.println("______Round Robin Algorithm______ (Name: Haris, Reg.No: 51379)");
		System.out.println("\nEnter the number of processes : ");

		int n;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int a[] = new int[n],b[] = new int[n];
		int r[] = new int[n],e[] = new int[n],c,t,tq;

		for(c=0;c<n;c++) {

			System.out.println("\nEnter arrival time for process : " + (c+1));

			a[c] = Integer.parseInt(br.readLine());

			System.out.println("Enter burst time for process : " + (c+1));

			b[c] = Integer.parseInt(br.readLine());

			r[c]=b[c];

		}

		System.out.println("\nEnter quantum time (Q) : ");

		tq = Integer.parseInt(br.readLine());

		for(t=a[0];;) {

			for(c=0;c<n;c++) {

				if(a[c]<=t&&r[c]!=0) {

					if(r[c]<=tq) {

						t+=r[c];
						r[c]=0;
						e[c]=t;
					}
					else {

						r[c]-=tq;
						t+=tq;
					}
				}
			}
			for(c=0;c<n;c++)

				if(r[c]!=0)

					break;

			if(c==n)

				break;

		}

		float aw=0,at=0;

		System.out.println("\nProcess No.\tWaiting Time\tTurn Around Time");

		for(c=0;c<n;c++) {

			aw+=e[c]-a[c]-b[c];

			at+=e[c]-a[c];

			System.out.println((c+1)+"\t"+(e[c]-a[c]-b[c])+"\t"+(e[c]-a[c]));

		}
		System.out.println("\nAverage Waiting Time : "+(aw/n));
		System.out.println("\nAverage Turn Around Time : "+(at/n));
	}
}
```
### Code Output:
```
______Round Robin Algorithm______ (Name: Haris, Reg.No: 51379)

Enter the number of processes : 
8

Enter arrival time for process : 1
0
Enter burst time for process : 1
4

Enter arrival time for process : 2
1
Enter burst time for process : 2
5

Enter arrival time for process : 3
2
Enter burst time for process : 3
2

Enter arrival time for process : 4
3
Enter burst time for process : 4
1

Enter arrival time for process : 5
4
Enter burst time for process : 5
6

Enter arrival time for process : 6
6
Enter burst time for process : 6
3

Enter arrival time for process : 7
4
Enter burst time for process : 7
3

Enter arrival time for process : 8
2
Enter burst time for process : 8
1

Enter quantum time (Q) : 
2

Process No.	Waiting Time	Turn Around Time
1		12		16
2		17		22
3		2		4
4		3		4
5		15		21
6		12		15
7		15		18
8		11		12

Average Waiting Time : 10.875

Average Turn Around Time : 14.0
```
### Code Screenshots:
#### main.java:
![main](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/main.jpg)
#### scheduling.java:
![scheduling_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/scheduling_ss1.JPG)
![scheduling_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/scheduling_ss2.JPG)
![scheduling_ss3](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Code/scheduling_ss3.JPG)
### Code Output Screenshots:
![output_ss1](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Output/output_ss1.JPG)
![output_ss2](https://github.com/H-R-S/DSA-Java-Assignments/blob/main/Assignment-04/ScreenShots/Output/output_ss2.JPG)