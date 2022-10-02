import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Property here.
 *
 * @author (Ribhav Bhatia)
 * @version (a version number or a date)
 */
public class Property
{
    // instance variables 
    private String name;
    private String color;
    private int price;
    private int pricePerHouse;
    private int rent;
    private int rentOneHouse;
    private int rentTwoHouses;
    private int rentThreeHouses;
    private int rentFourHouses;
    private int rentHotel;
    private int priceForMortgage;
    private int priceForUnMortgage;
    private boolean isMortgage;
    private int howManyHouses;
    private int space;
    private boolean isBought;
    /**
     * Constructor for objects of class Property
     */
    public Property(String n, String c, int p, int pph, int r, int roh, int rth, int rthreeh, int rfh, int rhot, int s) //parameters for the contructer needed, everything else is preset
    {
        // initialise instance variables
        name = n;
        color = c;
        price = p;
        pricePerHouse = pph;
        rent = r;
        rentOneHouse = roh;
        rentTwoHouses = rth;
        rentThreeHouses = rthreeh;
        rentFourHouses = rfh;
        rentHotel = rhot;
        priceForMortgage = p / 2;
        priceForUnMortgage = ((p / 2) / 10) + (p / 2);
        isMortgage = false;
        howManyHouses = 0;
        space = s;
        isBought = false;
    }
    public boolean getIsMortgage()
    {
        return isMortgage;
    }
    public int getSpace()
    {
        return space;
    }
    /**
     * This method returns the rent of the property
     * @param - none
     * @return - int rent - the rent the player has to pay
     */
    public int getRent()
    {
        int rentToPay = rent;
        if (howManyHouses == 1) //checks if they have houses
        {
            rentToPay = rentOneHouse;
        }
        if (howManyHouses == 2)
        {
            rentToPay = rentTwoHouses;
        }
        if (howManyHouses == 3)
        {
            rentToPay = rentThreeHouses;
        }
        if (howManyHouses == 4)
        {
            rentToPay = rentFourHouses;
        }
        return rentToPay;
    }
    public int getPrice()
    {
        return price;
    }
    public String getName()
    {
        return name;
    }
    public int howManyHouses()
    {
        return howManyHouses;
    }
    public int getPricePerHouse()
    {
        return pricePerHouse;
    }
    /**
     * This method is for a player buying something
     *
     * @param - none
     * @return - returns price to buy the property
     */
   
    public int buy()
    {
        //if(space != 0 ||space != 2 || space != 7 || space != 10 || space != 17 ||space != 20 || space != 22 ||space != 30 ||space != 33 ||space != 36 ||space != 40 ||space != 4 ||space != 38)
        //{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to buy this property?(y or n)");
        String s1 = scanner.nextLine();
        while(!s1.equals("Y") && !s1.equals("y") && !s1.equals("N") &&  !s1.equals("n")) //if they entered an invalid character
        {
           System.out.println("Invalid Character");
           System.out.println("Do you want to buy this property?(y or n)");
           s1 = scanner.nextLine(); 
        }
        if(s1.equals("Y") || s1.equals("y")) //checks if they said yes
        {
            isBought = true;
            return price;
        }
        return 0;
    }
    /**
     * This method checks if the inputed property is bought
     *
     * @param - none
     * @return - returns boolean isBought
     */
    public boolean ifBought()   //checks if property is bought
    {
        return isBought;
    }
    /**
     * This method is for a player buying something
     *
     * @param - none
     * @return - returns price to buy the house
     */
    public int buyHouse()
    {
        howManyHouses += 1;
        return pricePerHouse;
    }
    /**
     * This method returns the mortgage value for the property
     *
     * @param - none
     * @return - int depending on if the property is mortgaged
     */
    public int mortgage()
    {
        if(isMortgage == false) //checks if not mortgaged
        {
                isMortgage = true;
                return price / 2;            
        }
        else
        {
                System.out.println("Already Mortgaged");
        }                
        return 0;
    }
    /**
     * This method returns the unmortgage value for the property
     *
     * @param - none
     * @return - int depending on if the property is mortgaged
     */
   
    public int unMortgage()
    {
        if(isMortgage == true) //checks if mortgaged
        {
            isMortgage = false;
            return priceForUnMortgage;
        }
        else
        {
            System.out.println("Not Mortgaged");
        }
        return 0;
    }
}
