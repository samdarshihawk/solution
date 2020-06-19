
/*This question is about writing the Java code for calculating check digits using the Luhn algorithm, which is used to validate personal account numbers (PANs). Complete the method checkDigit() which has an integer array as a parameter which stores the PAN one digit per location. The method returns a check digit based on the algorithm below.We will use the number3 6 9 9 7 0 4 (extra space is added for readability) to illustrate the procedure:

Reverse the number. (We will get 4 0 7 9 9 6 3). (Hint: Store the reverse in a new array)
Multiply the digits with even indexes by 2.  (8 0 14 9 18 6 6)
Subtract 9 from all positions that are higher than 9. (8 0 5 9 9 6 6)
Add all the digits together. Let’s label this sum as X. (We will get X = 43).
Find C such that X+C is a multiple of 10. (We have X = 43, and need to add 7 to make it 50 – which is a multiple of 10, i.e., C = 7. Our check digit is 7.)
Return
*/
import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		int[] test = {3,6,9,9,7,0,4};
		System.out.print(checkDigit(test));
		

	}
	
	public static String checkDigit(int [] array) 
	{
		int list[]=Arrays.copyOf(array, array.length);
	
		
		for(int i=0; i<list.length/2; i++){
			  int temp = list[i];
			  list[i] = list[list.length -i -1];
			  list[list.length -i -1] = temp;
			}
		for(int j = 0; j<list.length;j++) 
		{
			if(j%2==0)
				list[j]=list[j]*2;
		}
		
		for(int j = 0; j<list.length;j++) 
		{
			if(list[j]>9)
				list[j]=list[j]-9;
		}
		
		int sum=0;
		
		for(int j =0; j<list.length; j++)
			sum += list[j];
		
		if(sum%10!=0) 
		{
			sum = sum+10;
			int remain = sum%10;
			int need = 10-remain;
			return(need+" number is required to make the it the multiple of 10.");
		}
		else
			return("The account is valid according to the Luhn algo.");
		
	}

}
