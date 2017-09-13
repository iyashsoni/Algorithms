public class MobileNumber{
	public static void main(String[] args){
		char[][] keypad = new char[][]{{'1','2','3'},
		                    {'4','5','6'},
		                    {'7','8','9'},
		                    {'*','0','#'}};
		int len = 5;
		possibleNumsOfLengthN(keypad, len);
	}
	
	static void possibleNumsOfLengthN(char[][] keypad, int n){
		if(n<=0)
			return;
		if(n == 1){
			System.out.println("10");
			return;
		}
		
		double[][] table = new double[10][n+1];
	    int row[] = {0, 0, -1, 0, 1};
		int col[] = {0, -1, 0, 1, 0};
		
		for(int i=0; i<10; i++){
			table[i][0] = 0;
			table[i][1] = 1;
		}
		
		for(int len=2; len<=n; len++){
			for(int i=0; i<4; i++){
				for(int j=0; j<3; j++){
					if(keypad[i][j] != '*' && keypad[i][j] != '#'){
						int num = keypad[i][j] - '0';
						table[num][len] = 0;
						for(int k=0; k<5; k++){
							int r = i + row[k];
							int c = j + col[k];
							if(r>=0 && r<=3 && c>=0 && c<=2 && keypad[r][c] != '#' && keypad[r][c] != '*'){
								int next = keypad[r][c] - '0';
								table[num][len] += table[next][len-1];
							}
						}
					}
				}
			}
		}
		int total = 0;
		for(int i=0; i<10; i++)
			total += table[i][n];
		System.out.println(total);
	}
}
