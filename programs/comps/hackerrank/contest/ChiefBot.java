package hackerrank.contest;

import java.util.Scanner;

/**
 * 
 * @author ankugarg
 * @question : Chief's bot is playing an old DOS-based game. There are N+1
 *           buildings in the game - indexed from 0 to N and are placed
 *           left-to-right. It is guaranteed that building with index 0 will be
 *           of height 0 unit. For buildings with index i (i∈[1,N]) height will
 *           be hi units.
 * 
 *           At beginning Chief's bot is at building with index 0. At each step,
 *           bot jumps to next (right) building. Suppose bot is at kth building
 *           and his current energy is botEnergy, then in next step he will jump
 *           to (k+1)th building. He will gain/lose energy equal in amount to
 *           difference between hk+1 and botEnergy If hk+1>botEnergy, then he
 *           will lose hk+1−botEnergy units of energy. Otherwise, he will gain
 *           botEnergy−hk+1 units of energy. Goal is to reach Nth building, and
 *           during the course bot should never have negative energy units. What
 *           should be the minimum units of energy with which bot should start
 *           to successfully complete the game?
 * 
 *           Input Format
 * 
 *           The first line contains integer N. Next line contains N space
 *           separated integers h1,h2, ⋯,hN representing the heights of the
 *           buildings.
 * 
 *           Output Format
 * 
 *           Print a single number representing minimum units of energy required
 *           to complete the game.
 * 
 *           Constraints 1≤N≤105 1≤hi≤105,i∈[1,N]
 * 
 *           Sample Input
 * 
 *           5 3 4 3 2 4 sample Output
 * 
 *           4 Sample Input
 * 
 *           3 4 4 4 Sample Output
 * 
 *           4 Explanation
 * 
 *           Sample 1 If initial energy is 4, after step 1 energy is 5, after
 *           step 2 it's 6, after step 3 it's 9 and after step 4 it's 16,
 *           finally at step 5 it's 28. You can verify for lower initial energy
 *           bot will have -ve energy in the end.
 * 
 *           Sample 2 In the second test case if bot has energy 4, it's energy
 *           is changed by (4 - 4 = 0) at every step and remains 4.
 */
public class ChiefBot {

	/**
	 * TC : O(n*n)
	 * @param building
	 * @return
	 */
	public static int algo(int[] building){
		int minEnergy = building[1];
		boolean negative = false;
		while(true){
			int energy = minEnergy;
			negative = false;
			for(int i=1;i<building.length;i++){
				energy += energy - building[i];
				if(energy < 0){
					negative = true;
					break;
				}
			}
			if(negative){
				minEnergy++;
			}else{
				break;
			}
		}		
		return java.lang.Math.abs(minEnergy);
	}
	
	/**
	 * TC : O(n)
	 * @return
	 */
	public static int algo2(int[] b){
		int energy = 0;
		for(int i=b.length-1; i>=0;i--){
			if((energy + b[i])%2==0){
				energy = (energy + b[i]) >> 1;
			}else{
				energy = (energy + b[i] + 1) >> 1;
			}
		}
		return energy;
	}
	public static void main(String[] args) {
		//test();
		System.out.println(algo2(new int[]{0,3,4,3,2,4}));
	}
	private static void test(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] building = new int[n];
		for(int i = 0;i < n; i++){
			building[i] = sc.nextInt();
		}
		System.out.println(algo(building));
		System.out.println(algo2(building));
	}
}
