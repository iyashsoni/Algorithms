import java.util.*;
public class SortByFreq{

	public static void main(String[] args){
	
		int arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
		calcAns(arr);
	}
	
	static void calcAns(int[] arr){
		int n = arr.length;
		Node[] input = new Node[n];
		ArrayList<Node> list = new ArrayList<Node>();
		
		// Making Node array out of int array
		for(int i=0; i<n; i++)	
			input[i] = new Node(arr[i],i);
			

		Node temp;
		// sort Node[] 
		for(int i=0; i<n; i++)	
			for(int j=i+1; j<n; j++)	
				if(input[i].getData() > input[j].getData()){
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;	
				}

		// creating a list, minus duplicates, and maintaing count and first index				
		list.add(input[0]);
		for(int i=1; i<n; i++){
			if(list.get(list.size()-1).getData() == input[i].getData()){
				list.get(list.size()-1).setCount(list.get(list.size()-1).getCount()+1);
				
				if(list.get(list.size()-1).getFirstIndex() > input[i].getFirstIndex()){
					list.get(list.size()-1).setFirstIndex(input[i].getFirstIndex());
				}
			}
			else{
				list.add(input[i]);
			}
		}
		
		n = list.size();
		// sorting countwise
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){	
				if(list.get(i).getCount() < list.get(j).getCount()){
					temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);	
				}
				else if((list.get(i).getCount() == list.get(j).getCount()) && (list.get(i).getFirstIndex() > list.get(j).getFirstIndex())){
					temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);	
				}				
			}
		}
		
		// printing
		for(int i=0; i<n; i++){
			for(int j=0; j<list.get(i).getCount(); j++){
				System.out.print(list.get(i).getData()+"  ");
			}
		}
		
	}
}
class Node{
	int data;
	int firstIndex;
	int count;
	
	Node(int d, int f){
		data = d;
		firstIndex = f;
		count = 1;
	}
	
	int getData(){
		return this.data;
	}
	
	int getCount(){
		return this.count;
	}
	
	void setCount(int a){
		this.count = a;
	}
	
	int getFirstIndex(){
		return this.firstIndex;
	}
	
	void setFirstIndex(int a){
		this.firstIndex = a;
	}
}
