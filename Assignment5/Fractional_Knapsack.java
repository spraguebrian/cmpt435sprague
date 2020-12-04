import java.io.IOException;
import java.util.Scanner;
 
class Fractional_Knapsack  
{  
    public static void main(String args[]) throws IOException  
    {  
    	//This creation of the knapsack class uses a scanner to get the values of each spice
    	//I have another implementation that does not use a scanner, but that one did not output the correct
    	//values, and while it looks better than this one, I figured it would be better to submit the working
    	//version opposed to the better looking version
    	
        int i,j=0,max_qty,m,n;  
        //i and j are declared for for loops
        //n is number of spices
        //max_qty is knapsack size
        //m will be used as knapsack size later on
        float sum=0,max;  
        //Open the scanner, I prompt the user what values you should enter for our class example,
        //but using a scanner opens up the possibility for user creativity
        Scanner sc = new Scanner(System.in);
        int array[][]=new int[2][20];  
        //We have 4 spices
        System.out.println("Enter number of spices: (Use 4)");  
        n=sc.nextInt(); 
 
        //The quantity of each spice
        System.out.println("Enter the quantity of each spice: (Use: 4 6 8 2)");
        for(i=0;i<n;i++)  
            array[0][i]=sc.nextInt();    
 
        //The price of each spice
        System.out.println("Enter the price of each spice: (Use 4 12 40 18)");
        for(i=0;i<n;i++)  
            array[1][i]=sc.nextInt(); 
 
        //We have 5 different knapsacks, so the class will need to be run 5 times, each time using a different size
        System.out.println("Enter maximum capacity of knapsack: (Run 5 times trying each of 1 6 10 20 21)");  
        max_qty=sc.nextInt();  
 
        m=max_qty;  
        while(m>=0)  
        {  
            max=0;  
            for(i=0;i<n;i++)  
            {  
                if(((float)array[1][i])/((float)array[0][i])>max)  
                {  
                    max=((float)array[1][i])/((float)array[0][i]);  
                    j=i;  
                }  
            }  
            //Only one spice is used
            if(array[0][j]>m)  
            {  
                System.out.println("Quantity of spice number " +  (j+1) + " added is " +m);  
                sum+=m*max;  
                m=-1;  
            }  
            //Multiple spice are used
            else  
            {  
                System.out.println("Quantity of spice number " + (j+1) + " added is " + array[0][j]);  
                m-=array[0][j];  
                sum+=(float)array[1][j];  
                array[1][j]=0;  
            }  
        }  
        System.out.println("The total profit is " + sum + " quatloos.");
        sc.close();
    }  
}