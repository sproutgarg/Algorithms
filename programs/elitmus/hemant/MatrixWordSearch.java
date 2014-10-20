package elitmus.hemant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixWordSearch {

	static Character[][] m = {
		{'D', 'D', 'K', 'B', 'T', 'B', 'N', 'P', 'J', 'K'},
		{'J', 'B', 'L', 'E', 'W', 'X', 'T', 'A', 'L', 'P'},
		{'T', 'E', 'A', 'M', 'P', 'A', 'T', 'A', 'C', 'B'},
		{'Y', 'M', 'T', 'Y', 'L', 'D', 'T', 'M', 'V', 'E'},
		{'G', 'Q', 'E', 'E', 'I', 'E', 'A', 'Z', 'N', 'M'},
		{'O', 'H', 'N', 'G', 'N', 'E', 'J', 'C', 'Z', 'A'},
		{'R', 'T', 'C', 'C', 'T', 'E', 'F', 'F', 'P', 'E'},
		{'G', 'R', 'O', 'W', 'T', 'H', 'T', 'Y', 'J', 'T'},
		{'K', 'T', 'E', 'M', 'A', 'E', 'T', 'S', 'U', 'C'},
		{'S', 'R', 'O', 'C', 'N', 'E', 'T', 'A', 'L', 'K'}
	};
	
	//Following are already defined for you to use
	public static final int MAXROW = 26;
	public static final int MAXCOL = 26;

    //Write the body of this function to search the given word in Matrix defined above   
    public static int SearchWord(Character[][] m, String w) throws Exception 
    {
        int n = 0;
        //Write your code here to search for WordToFind in the matrix
        //System.out.println(m.length);
        
        int row = m.length;
        int col = m[0].length;
        //System.out.println("col : "+ col);
        // horizontol
        for(int i=0; i< row; i++){
        	Character[] r = m[i];
    		String s = Arrays.toString(r).replaceAll(", ", "").substring(1, r.length + 1);
        //	System.out.println(s);
        	if(hasWord(s, w) ){
        		System.out.println("found word horizontally");
        		n++;
        	}
        }
        
        //vertical 
        for(int j = 0; j< col ;j++){
        	String s = "";
        	for(int i = 0; i < row; i++){
        		s += m[i][j];
        	}
        	if(hasWord(s, w)){
        		System.out.println("found word vertically");
        		n++;
        	}        	
        }

        List<String> cmb = new ArrayList<>();
        //left bottom to right top diagonal
        for(int i=0; i< row; i++){
        	int j = 0;
        	String s = "";
        	int k = i;
        	while(k>=0){
        		s += m[k][j];
        		k--;
        		j++;
        	}
        	if(hasWord(s, w)){
        		System.out.println("found word left diagonally");
        		n++;
        	}        	        	
        	
        }
        
        for(int j = 1; j<col; j++){
        	int i = row - 1; 
        	String s="";
        	int k = j;
        	while(k<col){
        		s +=m[i][k];
        		i--;
        		k++;
        	}
        	if(hasWord(s, w)){
        		System.out.println("found word left diagonally");
        		n++;
        	}        	        	
        	
        }
        //System.out.println("combinations : "+ cmb);
        //right bottom to left bottom diagonal
        
        for(int i = 0;i < row; i++){
        	int j = col -1;
        	int k = i;
        	String s = "";
        	while(k>=0){
        		s +=m[k][j];
        		j--;
        		k--;
        	}
        	if(hasWord(s, w)){
        		n++;
        		System.out.println("found word right diagonally");
        	}
        }
        for(int j = col-2; j>=0; j--){
        	String s = "";
        	int i = row - 1;
        	int k = j;
        	while(k>=0){
        		s += m[i][k];
        		k--;
        		i--;
        	}
        	if(hasWord(s, w)){
        		n++;
        		System.out.println("found word right diagonally");
        	}
//        	System.out.println(s);
        }
        
       // System.out.println(w +"-->" + n);
        
        return n;
    }

    private static boolean hasWord(String s, String w){
    	return s.contains(w) || s.contains(new StringBuilder(w).reverse().toString()); 
    }
    public static void main(String...args) throws Exception{
    	
    	
    	
    	System.out.println(SearchWord(m, "TEAM"));
    	System.out.println(SearchWord(m, "TEN"));
    	System.out.println(SearchWord(m, "GROWTH"));
    	
    	
    }
}
