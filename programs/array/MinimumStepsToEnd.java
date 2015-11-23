package array;

public class MinimumStepsToEnd {

	public static int minimumStepsToEnd(int[] arr){
		if(arr == null || arr.length == 0){
			return Integer.MAX_VALUE;
		}
		
		if(arr.length == 1){
			return 0;
		}
		for(int i: arr)
			System.out.print(i+",");
		System.out.println();
		
		int[] jumps = new int[arr.length];
		java.util.Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0] = 0;
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[i] == arr[j]){
					jumps[i] = jumps[j] + 1;
				}
				else if(jumps[j] + i-j < jumps[i]){
					jumps[i] = jumps[j] + (i-j);
				}
			}
		}
		for(int i : jumps){
			System.out.print(i+",");
		}
		System.out.println();
		return jumps[jumps.length-1];
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,3,6,7,8,3};//1-->3-->3 total 3 steps
		System.out.println(minimumStepsToEnd(a));
		
		int[] b = new int[]{5,2,3,4,5,6,7,8,6};//5-->5->6->6 total 3 steps
		System.out.println(minimumStepsToEnd(b));
		
		int[]c = new int[]{5,2,3,4,6,5,7,8,6};//5-->5->7-->8-->6 total 4 steps
											 //5->2->3->4->6->6  total 5 steps
		System.out.println(minimumStepsToEnd(c));
	}
}