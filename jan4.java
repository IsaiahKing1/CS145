// CS145
// Isaiah King
// Jan 4th Do in class
/*Write a program that uses at least one of each of the following:

a method
two or more parameters
a return value
three types of primitives
a for loop
a while loop
an if/else statement*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.Period;


public class jan4 {


    public static void main(String[] args) {
        LocalDate temp = runInput();
        while (temp != LocalDate.MIN){
            
            printAge(temp);
            addUpAge(temp);
            temp = runInput();

        }

        

    }


    private static void addUpAge(LocalDate temp)
    {
        int [] ageAdder = new int[]
        {
            temp.getYear(),
            temp.getMonthValue(),
            temp.getDayOfMonth()
        };
        int agesum = 0;
        for (int i = 0; i < ageAdder.length; i++){
            agesum += ageAdder[i];
            if (temp.getYear() < 1980){
                System.out.println("Your year, month, and date values added are " + agesum + "Old person alert");
            }

            else {
                System.out.println("Your year, month, and date values added are " + agesum);
            }
        };
    }


    private static void printAge(LocalDate temp){
        // Calculate persons age
        // Print age
        int age = Period.between(temp, LocalDate.now()).getYears();
        if (age < 40){
            System.out.println("You are " + age + " years young." );
        }
        else if (age > 40){
            System.out.println("You are " + age + " years old." );
        }
        
        

    }



    private static LocalDate runInput()
    {
        try {
            System.out.print("Enter your birthdate in the form of MM/DD/YYYY: ");
            String dob = new Scanner(System.in).nextLine();
            if (dob == null || dob.isEmpty()) {
                return LocalDate.MIN;
            }
            return LocalDate.parse(dob, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }   
        catch (Exception e) {
            System.out.println(e.getMessage());
            return LocalDate.MIN;
        }
        
    }

}
