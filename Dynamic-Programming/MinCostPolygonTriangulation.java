import java.lang.Math;
public class MinCostPolygonTriangulation{
	public static void main(String[] args){
		Point points[] = {new Point(0, 0), new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 2)};
		minCost(points, points.length);
	}
	
	static void minCost(Point[] points, int n){
		double[][] table = new double[n][n];
		
		for(int gap=0; gap<n; gap++){
			for(int i=0, j=gap; j<n; i++, j++){
				if(j<i+2)
					table[i][j] = 0.0;
				else{
					double min = Double.MAX_VALUE;
					for(int k=i+1; k<j; k++){
						if(table[i][k] + table[k+1][j] + costOfTri(points, i,j,k) < min)
							min = table[i][k] + table[k][j] + costOfTri(points, i,j,k);
					}
					table[i][j] = min;
				}
			}
		}
		System.out.println(table[0][n-1]);
	}
	
	static double costOfTri(Point[] arr, int i, int j, int k){
		return distance(arr[i],arr[j]) + distance(arr[j],arr[k]) + distance(arr[k],arr[i]);
	}
	
	static double distance(Point p1, Point p2){
		return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) +
                (p1.y - p2.y)*(p1.y - p2.y));
	}
	
	static double min(double a, double b){	return (a<b)?a:b;	}
}

class Point{
	int x, y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
