import java.util.*;
import java.io.*;
import java.nio.*;
public class User{

private String name;
private double weight;
private double height;
private int age;


public String getName(){return name;}
public double getWeight(){return weight;}
public double getHeight(){return height;}
public int getAge(){return age;}


public void setWeight(double weight){this.weight = weight;}
public void setAge(int age){this.age = age;}

public void readData(Scanner scan){
	
		try{	
			name = scan.next();
			weight = scan.nextDouble();
			height = scan.nextDouble();
			age = scan.nextInt();
	
	}catch(InputMismatchException e) {
			System.out.println("Wrong input type. " + e);
			scan.next(); 
	}
	
}

public void printData(){
	
	System.out.printf("%s, %s, %s, %s",name,weight,height,age);
	
}

}