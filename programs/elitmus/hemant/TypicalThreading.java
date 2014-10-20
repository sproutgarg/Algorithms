package elitmus.hemant;

import java.util.Arrays;

public class TypicalThreading {

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

	public int n = 0;
	
    //Write the body of this function to search the given word in Matrix defined above   
    public int SearchWord(final Character[][] m, final String w) throws Exception 
    {
    	//cleaning the member value
    	n = 0;
        //Write your code here to search for WordToFind in the matrix
        //System.out.println(m.length);
        final int row = m.length;
        final int col = m[0].length;
        
        //horizontal 
    	Runnable horizontalCount = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
		        //System.out.println("col : "+ col);
		        // horizontol
		        for(int i=0; i< row; i++){
		        	Character[] r = m[i];
		    		String s = Arrays.toString(r).replaceAll(", ", "").substring(1, r.length + 1);
		        //	System.out.println(s);
		    		updateCount(s, w);
		        }				
			}
    		
    	};
        
        //vertical
    	Runnable verticalCount = new Runnable(){
    		@Override
    		public void run(){
    	        for(int j = 0; j< col ;j++){
    	        	String s = "";
    	        	for(int i = 0; i < row; i++){
    	        		s += m[i][j];
    	        	}
    	        	updateCount(s, w);        	
    	        }	
    		}
    	};

        //left bottom to right top diagonal
    	Runnable lrTopDiagonalCount = new Runnable(){
			@Override
			public void run() {
				for(int i=0; i< row; i++){
		        	int j = 0;
		        	String s = "";
		        	int k = i;
		        	while(k>=0){
		        		s += m[k][j];
		        		k--;
		        		j++;
		        	}
		        	updateCount(s, w);  	
		        }
			}
    	};
        
    	//left to right lower diagonal
    	Runnable lrLowerDiagonalCount = new  Runnable() {
			@Override
			public void run() {
		        for(int j = 1; j<col; j++){
		        	int i = row - 1; 
		        	String s="";
		        	int k = j;
		        	while(k<col){
		        		s +=m[i][k];
		        		i--;
		        		k++;
		        	}
		        	updateCount(s, w);  	
		        }
			}
		};
        //System.out.println("combinations : "+ cmb);

		//right to left top diagonal 
        Runnable rlTopDiagonalCount = new Runnable() {
			@Override
			public void run() {
		        for(int i = 0;i < row; i++){
		        	int j = col -1;
		        	int k = i;
		        	String s = "";
		        	while(k>=0){
		        		s +=m[k][j];
		        		j--;
		        		k--;
		        	}
		        	updateCount(s, w);
		        }
			}
		};

		//right to left lower diagonal
		Runnable rlLowerDiagonalCount = new Runnable() {	
			@Override
			public void run() {
				for(int j = col-2; j>=0; j--){
		        	String s = "";
		        	int i = row - 1;
		        	int k = j;
		        	while(k>=0){
		        		s += m[i][k];
		        		k--;
		        		i--;
		        	}
		        	updateCount(s, w);
		        }
			}
		};
        
		Thread h = new Thread(horizontalCount);
		Thread v = new Thread(verticalCount);
		Thread lrt = new Thread(lrTopDiagonalCount);
		Thread lrl = new Thread(lrLowerDiagonalCount);
		Thread rlt = new Thread(rlTopDiagonalCount);
		Thread rll = new Thread(rlLowerDiagonalCount);
		
		h.start(); v.start(); lrt.start(); lrl.start(); rlt.start(); rll.start();

		h.join(); v.join(); lrt.join(); lrl.join(); rlt.join(); rll.join();
		
		System.out.println(w +"---->" + n);
        
        return n;
    }
    public void updateCount(String s, String w){
    	if(hasWord(s, w) ){
			synchronized (this) {
				n++;
			}
    	}
    }

    private static boolean hasWord(String s, String w){
    	return s.contains(w) || s.contains(new StringBuilder(w).reverse().toString()); 
    }
    
    public static void main(String...args) throws Exception{
    	TypicalThreading tt = new TypicalThreading();
    	System.out.println(tt.SearchWord(m, "TEAM"));
    	System.out.println(tt.SearchWord(m, "TEN"));
    	System.out.println(tt.SearchWord(m, "GROWTH"));
    	System.out.println(tt.SearchWord(m, "PATA"));
    	System.out.println(tt.SearchWord(m, "TW"));
    }
}
