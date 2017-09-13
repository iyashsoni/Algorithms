import java.util.*;
public class JobScheduling{
	public static void main(String[] args){
		Job[] jobs = {new Job(1,2,50), new Job(3,5,20), new Job(6,19,100), new Job(2,100,200)};
		calcMaxProfit(jobs);
	}
	
	static void calcMaxProfit(Job[] jobs){
		Arrays.sort(jobs, new MyCompJobScheduling());
		int n = jobs.length;
		
		int[] table = new int[n];
		table[0] = jobs[0].profit;
		
		for(int i=1; i<n; i++){
			int incl = jobs[i].profit;
			int x = previousNonConflictingJob(jobs, i);
			if(x != -1)
				incl += table[x];
			table[i] = max(incl, table[i-1]);
		}
		
		System.out.println(table[n-1]);
	}
	
	static int previousNonConflictingJob(Job[] jobs, int index){
		int x = -1;
		for(int i=0; i<index; i++){
			if(jobs[i].finish <= jobs[index].start)
				x = i;
		}
		return x;
	}
	
	static int max(int a, int b){	return (a>b)?a:b;	}
}

class Job{
	int start, finish, profit;
	Job(int a, int b, int c){
		start = a;
		finish = b;
		profit = c;
	}
}

class MyCompJobScheduling implements Comparator<Job>{
	public int compare(Job j1, Job j2){
		return (j1.finish - j2.start);
	}	
}
