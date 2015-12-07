package hackerrank.contest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/**
 * @author ankugarg
 * Question : 
 * Given a broken 9×9 sudoku with at most 1 pair of grid cells swapped, find the swap that could make the sudoku valid. If there are multiple ways to do so, find them all.

If you are not familiar with sudoku and its rules, please take a look at this page.

Input Format

The first line contains an integer, T,(1≤T≤1000), which is the number of tests. T test cases follow and each test case consists of 9 lines that represents a broken sudoku. Each line contains 9 digits separated by space.

Output Format

For each test case, output one line containing "Case #x:" first, where x is the test case number (starting from 1). Then, if the given soduku isn't broken, just output a line with the word:

Serendipity
Otherwise, say grid cell c1=(x1,y1) and grid cell c2=(x2,y2) were swapped, output:

(x1,y1) <-> (x2,y2)
Make sure that (x1,y1)≤(x2,y2), that is, x1<x2 or (x1=x2 and y1<y2). If there are multiple solutions, output them in the same format one per line. Suppose the first grid cell of solution i is c1i, and the second is c2i. Make sure that the (c1i,c2i)≤(c1j,c2j) when i<j.

Sample Input

2
2 1 9 7 5 3 4 8 6
3 7 5 8 6 4 9 1 2
8 4 6 2 9 1 3 5 7
1 9 8 6 7 5 2 4 3
5 6 4 1 3 2 7 9 8
7 2 3 4 8 9 5 6 1
4 4 7 3 1 6 8 2 9
9 8 1 5 2 7 6 3 4
6 3 2 9 5 8 1 7 5
4 6 2 5 7 1 9 8 3
7 9 1 2 8 3 4 6 5
5 8 3 6 4 9 2 7 1
6 1 7 4 9 8 5 3 2
9 4 8 3 5 2 6 1 7
2 3 5 1 6 7 8 9 4
1 7 6 9 2 4 3 5 8
3 5 4 8 1 6 7 2 9
8 2 9 7 3 5 1 4 6


Sample Output

Case #1:
(7,2) <-> (9,5)
Case #2:
Serendipity

 */
public class SudokoSwap {
	
	private static class Cell implements Comparable<Cell>{
		Integer x, y;
		Integer value;
		
		Cell(int x, int y, int value){
			this.x = x+1;
			this.y = y+1;
			this.value = value;
		}

		@Override
		public int compareTo(Cell c) {
			if(this.x > c.x){
				return 1;
			}else if(this.x < c.x){
				return -1;
			}else{
				return this.y.compareTo(c.y); 
			}
		}
		public String toString(){
			return "["+this.value+":("+this.x+","+this.y+")]";
		}
		public String printPositions(){
			return "("+this.x+","+this.y+")";
		}
	}
	
	private static class Defect{
		java.util.List<Cell> positions = new ArrayList<SudokoSwap.Cell>();
		boolean hasDefect = false;;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		InputStream in = System.in;
		in = new FileInputStream(new File("resource/sudokoswap_input_3.txt"));
		Scanner sc = new Scanner(in);
		
		final int T = sc.nextInt();
		for(int i = 0; i< T; i++){
			int[][] m = readSudoko(sc);
			displaySudoko(m);	
			System.out.println(processSudokoSolution(m, i+1));
		}
	}
	
	public static String processSudokoSolution(int[][] m, int caseNumber){
		String result = "Case #"+caseNumber+":\n";
		Defect d = new Defect();
		Defect temp = new Defect();
		Defect t = new Defect();
		int count = 0;
		for(int r=0; r < m.length; r++){
			int[] hashPosition = new int[10];
			java.util.Arrays.fill(hashPosition, -1);
			for(int c=0; c<m[r].length; c++){
				if(hashPosition[m[r][c]] != -1){
					count++;
					d.hasDefect = true;
					System.out.println("defected row : " + r);
					if(isColumnDefected(m, hashPosition[m[r][c]])){
						d.positions.add(new Cell(r, hashPosition[m[r][c]], m[r][c]));
					}
					else if(isColumnDefected(m, c)){
						d.positions.add(new Cell(r, c, m[r][c]));
					}else if(isSquareDefected(m, r, hashPosition[m[r][c]])){
						d.positions.add(new Cell(r, hashPosition[m[r][c]], m[r][c]));
					}else if(isSquareDefected(m, r, c)){
						d.positions.add(new Cell(r, c, m[r][c]));
					}else{
						temp.hasDefect = true;
						temp.positions.add(new Cell(r, hashPosition[m[r][c]], m[r][c]));
						temp.positions.add(new Cell(r, c, m[r][c]));
					}
				}else{
					hashPosition[m[r][c]] = c;
				}
			}
			java.util.Arrays.fill(hashPosition, -1);
			for(int k =0; k<9;k++){
				if(hashPosition[m[k][r]] == -1){
					hashPosition[m[k][r]] = k;
				}else{
					System.out.println("column wise defect : " + k+","+r+","+hashPosition[m[k][r]]);
					t.hasDefect = true;
					t.positions.add(new Cell(hashPosition[m[k][r]], r, m[k][r]));
					t.positions.add(new Cell(k, r, m[k][r]));
				}
			}
			if(count ==2){
//				break;
			}
		}
		if(d.hasDefect && ! temp.hasDefect){
			result += d.positions.get(0).printPositions()+" <-> "+d.positions.get(1).printPositions();
		}else if(temp.hasDefect){
			result += temp.positions.get(0).printPositions()+" <-> "+temp.positions.get(2).printPositions()+"\n";
			result += temp.positions.get(1).printPositions()+" <-> "+temp.positions.get(3).printPositions()+"\n";
		}else if(t.hasDefect){
			result += t.positions.get(0).printPositions()+" <-> "+t.positions.get(2).printPositions()+"\n";
			result += t.positions.get(1).printPositions()+" <-> "+t.positions.get(3).printPositions()+"\n";
		}else{
			result += "Serendipity\n";
		}
		return result;
	}
	
	public static Defect checkRows(int[][] m){

		return null;
	}
	
	public static boolean isColumnDefected(int[][] m, int c){
		System.out.println("checking column : "+c);
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < 9; i++){
			if(!set.add(m[i][c])){
					return true;
			}
		}
		return false;
	}
	
	private static boolean isSquareDefected(int[][]m, int r, int c){
		int sr = (r/3)*3;
		int sc = (c/3)*3;
		System.out.println(r+","+c+"-->"+sr+","+sc);
		int[] square = new int[]{0,0, 0,1, 0,2, 1,0, 1,1, 1,2, 2,0, 2,1, 2,2};
		HashSet<Integer> set = new HashSet<Integer>();
		for(int s=0; s< square.length; s=s+2){
			if(!set.add(m[sr+square[s]][sc+square[s+1]])){
				return true;
			}
		}
		return false;
	}
	
	private static int[][] readSudoko(Scanner sc){
		int[][] m = new int[9][9];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				m[i][j] = sc.nextInt();
		return m;
	}
	
	private static void displaySudoko(int[][] m){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				System.out.print(" "+m[i][j]);
			System.out.println();
		}
		System.out.println("======================");
	}
	
}
