import java.util.*;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.*;
import java.io.File;
public class FitnessSystem {
	
	private User user;
	private String currentUser;
	private Scanner input;
	private double bmr,bmi,TDEE;
	
	public FitnessSystem(){		
	
	user = new User();
	input = new Scanner(System.in);
	selectUser();
	readUserData();
	calculateBMI();
	calculateBMR();

	}

	public static void main(String[] args){
	
	FitnessSystem fs = new FitnessSystem();	
	fs.table();
	fs.prompt();

	}
	
	public void prompt(){
		
		Scanner number = new Scanner(System.in);
		int select = number.nextInt();
		boolean flag = true;
		while(flag){
			switch(select){
			
				case 1:
					updateAge();
						break;				
				case 2:
					updateWeight();
						break;
				case 3:
					user.printData();
						break;
				case 4:
					System.out.printf("%s BMI is: %.2f\n",currentUser,bmi);
						break;
				case 5:
					System.out.printf("%s BMR is: %.2f\n",currentUser,bmr);
						break;
				case 6:
					calculateTDEE();
						break;
				case 7:
					calculateWeight();
						break;
				case 8:
				
				break;
				case 9:
				
				break;
				case 0:
					flag = false;
						break;
				default:
			}
			table();
			select = number.nextInt();
		
		}
		
	}
	public void table(){
		System.out.println();
		System.out.printf("1.\tUpdate Users age\n");
		System.out.printf("2.\tUpdate Users weight\n");
		System.out.printf("3.\tDisplay Users Info\n");
		System.out.printf("4.\tCalculate Users BMI\n");
		System.out.printf("5.\tCalculate Users BMR\n");
		System.out.printf("6.\tCalculate Users TDEE\n");
		System.out.printf("7.\tCalculate Users Estimated weight(4 weeks)\n");
		System.out.printf("8.\tChange User Profile\n");
		System.out.printf("9.\tSave User Profile\n");
		System.out.printf("0.\tExit\n");
	
		
	}
	
	
	public void updateAge(){
		
		System.out.println("Please input updated age:");
		int updatedAge = input.nextInt();
		user.setAge(updatedAge);
		System.out.printf("Age has been updated to %s\n",updatedAge);
		
	}
	
	public void updateWeight(){
		
		System.out.println("Please input updated Weight:");
		double updatedWeight = input.nextDouble();
		user.setWeight(updatedWeight);
		System.out.printf("Weight has been updated to %s\n",updatedWeight);
		
	}
	
	
	public void calculateBMI(){
		double userHeight = user.getHeight() / 100;
		double squaredheight = Math.pow(userHeight,2);
		bmi = user.getWeight()/squaredheight;
		
	}

	
	public void calculateBMR(){
		
		//bmr = 88.362 + (13.397 * user.getWeight()) + (4.799 * user.getHeight()) - (5.677 * user.getAge());
		bmr = (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge()) + 5;
		
	}
	
	public void calculateTDEE(){
		
		System.out.println("Please choose your activity level:");
		System.out.println("1. Sedentary: You work at a desk job and you don't do much housework, walking, or exercising.");
		System.out.println("2. Lightly active: You don't exercise much, but you go for walks 1-3 times per week and are on your feet doing housework during some of the day.");
		System.out.println("3. Moderately active: You exercise 3-5 times a week and stay moving throughout the day with non-exercise activities.");
		System.out.println("4. Very active: You exercise intensely or play vigorous sports on most days.");
		System.out.println("5. Extra active: You exercise intensely or play vigorous sports nearly every day, including occasional (two a days). You also work a physical job or are on your feet most of the time.");
		
		int select = input.nextInt();
		
		switch(select){
			
			case 1: 
				TDEE = bmr *1.2;
					break;
			case 2: 
				TDEE = bmr *1.375;
					break;
			case 3: 
				TDEE = bmr *1.550;
					break;
			case 4: 
				TDEE = bmr *1.725;
					break;
			case 5: 
				TDEE = bmr *1.9;
					break;
				
	}
		System.out.printf("%s TDEE is %.2f\n",currentUser,TDEE);
	}
	
	public void calculateWeight(){
		
		
		
		
		
		
		
	}
		
		public void selectUser(){
			
			System.out.println("Select User File Name");
			 
			 File folder = new File("C:/Users/ranko/Desktop/FitnessSystem");
				
				File[] files = folder.listFiles();
					
					for (File file : files){ 
						
						if (file.isFile() && file.getName().endsWith(".txt")){
							System.out.println(file.getName());
						}
					}
				
			currentUser = input.next();
		}
	
	public void readUserData(){
		
		String filename = currentUser +".txt";
		Path path = Paths.get(filename);
		try{
			
			if (Files.exists(path)){
			
				Scanner scan = new Scanner(path);
				scan.useDelimiter(",|\r\n|\t|\n");
					
					while(scan.hasNext()){
					
						user.readData(scan);
						
					}
					scan.close();			
			}
			else{ 
				System.out.println("Cannot find User");
			}	
		
	}catch (IOException i){
				System.out.println("IOException");
			}
	}
}

		