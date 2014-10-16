package hackerrank;

import java.util.Scanner;

/*

Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line, and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies.

Input
The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

Ouput
Output a single line containing the minimum number of candies Alice must buy.

Constraints
1 <= N <= 105
1 <= ratingi <= 105

Sample Input

3  
1  
2  
2

Sample Ouput

4

Explanation
Here 1, 2, 2 is the rating. Note that when two children have equal rating they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.
 */
public class Candies {
	public static void main(String...arg){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		evaluateCandies(arr);
	}
	public static int evaluateCandies(int[] rating){
		int n = rating.length;
		if(n==1){
			return 1;
		}
		int sum = 0;
		int[] candies = new int[n];
		boolean[] visited = new boolean[n];
		java.util.Arrays.fill(visited, false);
		java.util.Arrays.fill(candies, 0);
		int left, right, center;
		for(int i=0;i<n;i++){
			left=right=center=0;
			int index = 0;
			int min = rating[0];
			for(int j = 1; j < n; j++){
				if(!visited[j] && min > rating[j]){
					min = rating[j];
					index = j;
				}
			}
			if(!visited[index]){
				visited[index]=true;
				if(index == 0){
					center = candies[index];
					right = candies[index+1];
					sum = sum - (left+center+right);
					if(rating[index] < rating[index+1]){
						candies[index] = 1;
						if(candies[index+1] == 0){
							candies[index+1] = 2;
						}
					}else if(rating[index] > rating[index+1]){
						candies[index] = candies[index+1]+1;
					}else{
						if(candies[index+1] == 0){
							candies[index] = candies[index+1] = 1;
						}else{
							candies[index] = 1;
						}
						
					}
					center = candies[index];
					right = candies[index+1];
				}
				else if(index == n-1){
					center = candies[index];
					left = candies[index-1];
					sum = sum - (left+center+right);
					if(rating[index-1] < rating[index]){
						candies[index] = candies[index-1]+1;
					}else if(rating[index-1] > rating[index+1]){
						candies[index] = 1;
						if(candies[index-1] == 0){
							candies[index-1] = 2;
						}
						candies[index] = candies[index+1]+1;
					}else{
						if(candies[index-1] == 0){
							candies[index] = candies[index-1] = 1;
						}else{
							candies[index] = 1;
						}
						
					}
					center = candies[index];
					left = candies[index-1];
				}
				else{
					left = candies[index-1];
					center = candies[index];
					right = candies[index+1];
					if(rating[index-1]==rating[index] && rating[index]==rating[index+1]){
						
					}
				}
			}
		}
		return sum;
	}
}