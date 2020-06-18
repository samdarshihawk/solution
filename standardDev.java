// using array on standardDev method



public class standardDev
{
	public static void main(String[] args)
	{
		double[] ex1 = {1.5, 1.5, 1.5};
		double[] ex2 = {0.0, 1.0, 2.0, 3.0};
		double[] ex3 = {3.4, 5.6, 123.4, 684.93, 3.4};
		System.out.println(standardDev(ex1, ex1.length));
		System.out.println(standardDev(ex2, ex2.length));	
		System.out.println(standardDev(ex3, ex3.length));
	}
// definition of standardDev goes here
	
	public static double standardDev(double[] list, int len) 
	{
		double average=0;
		double sum1=0;
		for(int i =0; i<len;i++)
			sum1+=list[i];
		average=sum1/len;
		double[] square = new double[len];
		double sum2=0;
		for(int i =0;i<len;i++) 
		{
			square[i] = Math.pow((list[i] - average), 2);
			sum2 += square[i];
		}
		
		double average2 = sum2/len;
		return(Math.sqrt(average2));
		
		
	}
}
