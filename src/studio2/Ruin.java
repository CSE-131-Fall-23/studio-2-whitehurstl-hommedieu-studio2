package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
			System.out.println("What is your starting amount?");
			double startAmount = in.nextDouble();
			double temp=startAmount;
			System.out.println("What is your win probability");
			double winChance = in.nextDouble();
			
			System.out.println("What is your win limit?");
			double winLimit = in.nextDouble();
			
			System.out.println("How many total simulations");
			int totalSimulations=in.nextInt();
			int lossCount=0;
			for (int i = 1;i<totalSimulations+1;i++) {
				int count=0;
				
				while(startAmount<winLimit) {
				
				double stat=Math.random();
				if(stat<=winChance) {
					startAmount++;
					count++;
					if(startAmount==winLimit) {
						
						startAmount=temp;
						System.out.println("Simulation "+i+": win, "+count+" plays");
						count=0;
						break;
					}
					
				}else {
					startAmount--;
					count++;
						if(startAmount==0){
						startAmount=temp;
						lossCount++;
						System.out.println("Simulation "+i+" ruin, "+count+" plays");
						count=0;
						break;
						}
				}
					
				}
			
			}
			double expRuin;
			double alpha=(1-winChance)/winChance;
			if(winChance==.5) {
				expRuin=(1-(startAmount/winLimit));
			}else {
				expRuin=(Math.pow(alpha,startAmount)-(Math.pow(alpha, winLimit)))/(1-Math.pow(alpha, winLimit));
			}
			System.out.println("Losses: "+lossCount+" Simulations: "+totalSimulations);
			
			double ruinRate=lossCount/(double)totalSimulations;
			System.out.println("Ruin Rate from Simulation: "+ruinRate+" Expected Ruin Rate: "+expRuin);
		
		
		
		
		
	}

}
