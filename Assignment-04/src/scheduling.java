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

			System.out.println((c+1)+"\t\t"+(e[c]-a[c]-b[c])+"\t\t"+(e[c]-a[c]));

		}
		System.out.println("\nAverage Waiting Time : "+(aw/n));
		System.out.println("\nAverage Turn Around Time : "+(at/n));
	}
}
