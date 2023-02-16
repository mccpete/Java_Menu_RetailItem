import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * RetailItem Class
 * 
 * This class contains the necessary code in order to have a menu like retail system.
 * 
 * @author Peter McLane
 *
 */
public class RetailItem {
	private String description;
	private int unitsOnHand;
	private double price;
	
	RetailItem()
	{
		initializeObject();
	}
	
	RetailItem(Scanner r)
	{
		initializeObject();
		readData(r);
	}
	
	RetailItem(String newDescription, int newUnitsOnHand, double newPrice)
	{
		if( !(setDescription(newDescription) && setUnitsOnHand(newUnitsOnHand) && setPrice(newPrice)) )
			initializeObject();

	}
	//creating RetailItem object
	private void initializeObject()
	{
		description = "Unknown";
		unitsOnHand = 0;
		price = 0.0;
	}
//setting the description of the retail item
	public boolean setDescription(String newDescription)
	{
		//making sure the user actually enters input
		if( !newDescription.equals("") )			
		{
			description = newDescription;
		}
		
		return !newDescription.equals("");
	}	
//setting the units on hand
	public boolean setUnitsOnHand(int newUnitsOnHand)
	{
		if( unitsOnHand >= 0 ) 			
		{
			unitsOnHand = newUnitsOnHand;
		}

		return unitsOnHand >= 0;		
	}
//setting the price
	public boolean setPrice(double newPrice)
	{
		if( newPrice > 0.0 )			/
		{
			price = newPrice;
		}
		return newPrice > 0.0;			
	}
//getting the description
	public String getDescription()
	{
		return description;
	}
//getting the units on hand
	public int getUnitsOnHand()
	{
		return unitsOnHand;
	}
//getting the price	
	public double getPrice()
	{
		return price;	
	}
	//reading data from the txt file
	public int readData(Scanner data) 
	{
		
		String oldDescription = description;
		int oldUnitsOnHand = unitsOnHand;
		double oldPrice = price;

		int status = -1;   					
		if( data.hasNext() )
		{
			setDescription(data.next());			
						
			status = -2;					
			if( data.hasNextInt() )
			{

				if( !setUnitsOnHand(data.nextInt()) )
				{
					status = -3;		
				} else {

					status = -4;		
					if( data.hasNextDouble() )
					{

						if( !setPrice(data.nextDouble()) )
						{
							status = -5;	
						} else {
							
							status = 0;
							if( data.hasNextLine() ) 			
							{
								status = -6;			
							
							}
						}
					}
					
				}
			}
		}

		if( status >= -1 && status <= -5 ) {		
			setDescription(oldDescription);			
			setUnitsOnHand(oldUnitsOnHand);
			setPrice(oldPrice);
		}

		return status;
	}

	public String toString()
	{
		return description + " " + unitsOnHand + " " + price;
	}
//writing data to new file
	public void writeData(PrintWriter w)
	{
		w.println(toString());
	}
}


