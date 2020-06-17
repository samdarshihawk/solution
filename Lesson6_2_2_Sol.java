/**
 * This program estimates the height of a child using
 * the formula:  H(male) = (H(mother)*13/12 + H(father))/2
 * 		  H(female) = (H(father)*12/13 + H(mother))/2
 *
 * All heights are in inches.  A function takes as input
 * parameters the heights in inches and outputs the height in inches.
 * Conversions are made by allowing the user to input the height
 * in feet and inches.
 *
 * Created: Sat Mar 05, 2005
 *
 * author Kenrick Mock
 * edited by N. Acemian (April 2, 2019)
 * version 1
 */

import java.util.Scanner;
public class Lesson6_2_2_Sol
{
	/**
	 * This is the main method.  It loops repeatedly until the
	 * user stops by not entering "Y" to continue using a do-while loop.
	 * Input is accomplished through the Scanner class.
	 */
	public static void main(String[] args)
	{
		// Variable declarations
		int gender;					// 0=male, 1=female
		int mom_feet, mom_inches;
		int dad_feet, dad_inches;
		int child_total_inches;
		Scanner keyIn = new Scanner(System.in);

		do
		{
			//Prompt for gender, height of mom and dad in feet and inches
			gender = getGender(keyIn);

			System.out.println("Enter the height in feet then the height " +
					"in inches of the mom.");
			mom_feet = keyIn.nextInt();
			mom_inches = keyIn.nextInt();

			System.out.println("Enter the height in feet then the height " +
					"in inches of the dad.");
			dad_feet = keyIn.nextInt();
			dad_inches = keyIn.nextInt();

			// Convert input to all inches and get the estimate for the child
			int mother_height = convertToInches(mom_feet, mom_inches);
			int father_height = convertToInches(dad_feet, dad_inches);
			
			child_total_inches = calculateHeight(gender,mother_height, father_height);
			

			// Output the estimated height
			System.out.println("Your future child is estimated to grow to " +
					child_total_inches / 12 + " feet and " +
					child_total_inches % 12 + " inches.");
			System.out.println();
		}
		while (askAgain(keyIn));
		
		keyIn.close();
	}
	
	public static int getGender(Scanner keyIn) 
	{
		int gender;
		do{

			  System.out.println("Enter the gender of your future child. " +
						"Use 1 for female, 0 for male.");
			  gender = keyIn.nextInt();
			}while(!(gender == 0) && !(gender == 1));
		return gender;
	}
	
	public static boolean askAgain(Scanner keyIn) 
	{
		String output;
		System.out.println("Enter 'Y' to run again, anything else to exit.");
		output=keyIn.next();
		return(output.equalsIgnoreCase("y"));
	}
	public static int convertToInches(int mom_feet, int mom_inches) 
	{
		return(mom_feet*12+mom_inches);
	}
	
	public static int calculateHeight(int gender, int mother_height, int father_height) 
	{
		if(gender==0) 
		{
			return(((mother_height*13)/12 + father_height)/2);
		}
		else 
		{
			return(((father_height*12)/13 + mother_height)/2);
		}
	}
	
} // Lesson6_2_2_Sol
