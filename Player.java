import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Player here.
 *
 * @author (Ribhav Bhatia)
 * @version (a version number or a date)
 */
public class Player
{
    String name;
    int money;
    ArrayList <Property> cards;
    int space;
    int numOfProperties;
    double num;
    double num2;
    double num3;
    //String spot;
    public Player(String n) //contructor: takes in name as imput and everything else is predefined
    {
        name = n;
        money = 1500;
        cards = new <Property> ArrayList();
        space = 0;
        numOfProperties = 0;
        num = 0;
        num2 = 0;
        num3 = 0;
        //spot = "Go";
    }
    public String getName()
    {
        return name;
    }
    public double getNum()    
    {
        return num;
    }
    public double getNum2()
    {
        return  num2;
    }
    public int getMoney()
    {
        return money;
    }
    
    public void loseMoney(int n)
    {
        money -= n;
    }
    public void addMoney(int n)
    {
        money += n;
    }
    public int getSpace()
    {
        return space;
    }
    public void addProperty(Property p)
    {
        cards.add(p);
    }
    /**
     * This method checks if this Player has the property passed as a parameter
     * @param - Property c - property to check 
     * @return - boolean - if the player has the property or not
     */
    public boolean isInCards(Property c)
    {
        for(Property prop: cards)
        {
            if(prop.getName().equals(c.getName())) //checks if the name's are the same
            {
                return true;
            }
        }
        return false;
    }
    ///Return only properties which are not mortgaged
    /**
     * This method returns the properties that the  Player has
     * @param - none
     * @return - returns properties that are not mortgaged
     */
    public ArrayList <Property> getCards()
    {
        ArrayList <Property> properties = new <Property> ArrayList(); 
        for(Property prop: cards)
        {
            if (prop.getIsMortgage() == false)  //checks if the properties is mortgaged or not
            {
                properties.add(prop);
            }
        }        
        return properties;
    }
    ///Return all the properties
    public ArrayList <Property> getAllCards()
    {
        return cards;
    }

    /**
     * This method mortgages based on the money in debt
     * @param - int moneyToPay - the amount of money in debt, String roundSummary - a summary of what the player has done
     * @return - String roundSummary - a summary of what the player has done
     */
    public String mortgageProperty(int moneyToPay, String roundSummary)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to mortgage a property?(y or n)"); //asks the player
        String s1 = scanner.nextLine();
        while(!s1.equals("Y") && !s1.equals("y") && !s1.equals("N") &&  !s1.equals("n")) //makes sure that player inputted the right letters
        {
            System.out.println("Invalid Character");
            System.out.println("Do you want to buy this property?(y or n)");
            s1 = scanner.nextLine(); 
        }   
        if(s1.equals("Y") || s1.equals("y")) //if player says yes
        {
            for(Property prop2: getCards()) //runs through the player's cards
            {
                System.out.println (prop2.getName());
            }
            System.out.println("Please type what property you want to mortgage"); //another scanner to ask what to mortgages
            String s2 = scanner.nextLine();
            for(Property prop2: getCards())
            {
                if(prop2.getName().trim().equals(s2.trim())) //just in case player types the property wrong
                {
                    int mortProperty = prop2.mortgage();
                    if(mortProperty > 0) //checks if they mortgaged or not
                    {
                        addMoney(mortProperty);
                        roundSummary += getName() + " has mortgaged " + prop2.getName() + "\n";
                    }
                }
            }                                   
        }
        while(getMoney() < moneyToPay && getCards().size() > 0) //if they still don't have enough
        {
                System.out.println("You still don't have enough money");
                System.out.println("Please try another property"); 
                for(Property prop2: getCards())
                {
                    System.out.println (prop2.getName());
                }
                System.out.println("Please type what property you want to mortgage");
                String s3 = scanner.nextLine();
                for(Property prop2: getCards())
                {
                    if(prop2.getName().trim().equals(s3.trim()))
                    {
                        int mortProperty = prop2.mortgage();
                        if(mortProperty > 0)
                        {
                            addMoney(mortProperty);
                            roundSummary += getName() + " has mortgaged " + prop2.getName() + "\n";
                        }
                    }   
                }
               
        }
        return roundSummary;
    }
    //public String getSpot()
    //{
    //    return spot;
    //}
    /**
     * This method determines the space the player is on based on roll
     * @param - int n - Player's roll
     * @return - String place - the name of the place
     */
    public String move(int n)
    {
        String place = "";
        if(n == 0 || n == 40){
            place = "Go";
        }
        if(n == 1){
            place = "Mediterranean Avenue";
        }
        if(n == 2){
            place = "Community Chest";
        }
        if(n == 3){
            place = "Baltic Avenue";
        }
        if(n == 4)
        {
            place = "Income Tax";
            money -= 200;
        }
        if(n == 5)
        {
            place = "Reading Railroad";
        }
        if(n == 6)
        {
            place = "Oriental Avenue";
        }
        if(n == 7)
        {
            place = "Chance";
        }
        if(n == 8)
        {
            place = "Vermont Avenue";
        }
        if(n == 9)
        {
            place = "Conneticut Avenue";
        }
        if(n == 10)
        {
            place = "Jail/Just visiting";
        }
        if(n == 11)
        {
            place = "St. Charles Place";
        }
        if(n == 12)
        {
            place = "Electric Company";
        }
        if(n == 13)
        {
            place = "States Avenue";
        }
        if(n == 14)
        {
            place = "Virginia Avenue";
        }
        if(n == 15)
        {
            place = "Pennsylvania Railroad";
        }
        if(n == 16)
        {
            place = "St. James Place";
        }
        if(n == 17)
        {
            place = "Community Chest";
        }
        if(n == 18)
        {
            place = "Tennessee Avenue";
        }
        if(n == 19)
        {
            place = "New York Avenue";
        }
        if(n == 20)
        {
            place = "Free Parking";
        }
        if(n == 21)
        {
            place = "Kentuky Avenue";
        }
        if(n == 22)
        {
            place = "Chance";
        }
        if(n == 23)
        {
            place = "Indiana Avenue";
        }
        if(n == 24)
        {
            place = "Illinois Avenue";
        }
        if(n == 25)
        {
            place = "B&O Railroad";
        }
        if(n == 26)
        {
            place = "Atlantic Avenue";
        }
        if(n == 27)
        {
            place = "Ventor Avenue";
        }
        if(n == 28)
        {
            place = "Water Works";
        }
        if(n == 29)
        {
            place = "Marvin Gardins";
        }
        if(n == 30)
        {
            place = "Go to Jail";
            space = 10;
        }
        if(n == 31)
        {
            place = "Pacific Avenue";
        }
        if(n == 32)
        {
            place = "North Carolina Avenue";
        }
        if(n == 33)
        {
            place = "Community chest";
        }
        if(n == 34)
        {
            place = "Pennsylvania Avenue";
        }
        if(n == 35)
        {
            place = "Short Line";
        }
        if(n == 36)
        {
            place = "Chance";
        }
        if(n == 37)
        {
            place = "Park Place";
        }
        if(n == 38)
        {
            place = "Luxary Tax";
            money -= 100;
        }
        if(n == 39)
        {
            place = "Board Walk";
        }
        //spot = place;
        return place;
    }
    
    /**
     * this method rolls for a player and determines the place that they are on
     * @param - none
     * @return - int space - tells what space player is on
     */
    public String turn()
    {
        num = Math.random() * (6 - 1 + 1) + 1;
        num2 = Math.random() * (6 - 1 + 1) + 1; //two rolls for two die
        num3 = num + num2;
        num3 = Math.floor(num); //round to integer
        space += num3;
        if(space >= 40) //if the player has more than 40 spaces, then he or she restarts
        {
            money += 200;
            System.out.println(name + " has passed Go!");
            space -= 40;
        }
        
        return move(space);
    }
    /**
    public int buy()
    {
        //if(space != 0 ||space != 2 || space != 7 || space != 10 || space != 17 ||space != 20 || space != 22 ||space != 30 ||space != 33 ||space != 36 ||space != 40 ||space != 4 ||space != 38)
        //{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to buy this property?(y or n)");
        String s1 = scanner.nextLine();
        if(s1 == "Y" || s1 == "y")
        {
            if(space == 1){
                money -= 60;
                cards.add("Mediterranean Avenue");
            }
            if(space == 3){
                money -= 60;
                cards.add("Baltic Avenue");
            }
    
            if(space == 5)
            {   
                money -= 200;
                cards.add("Reading Railroad");
            }
            if(space == 6)
            {
                money -= 100;
                cards.add("Oriental Avenue");
            }
       
            if(space == 8)
            {
                money -= 100;
                cards.add("Vermont Avenue");
            }
            if(space == 9)
            {
                money -= 120;
                cards.add("Conneticut Avenue");
            }
       
            if(space == 11)
            {
                money -= 140;
                cards.add("St. Charles Place");
            }
            if(space == 12)
            {
                money -= 150;
                cards.add("Electric Company");
            }
            if(space == 13)
            {
                money -= 140;
                cards.add("States Avenue");
            }
            if(space == 14)
            {   
                money -= 160;
                cards.add("Virginia Avenue)");
            }
            if(space == 15)
            {
                money -= 200;
                cards.add("Pennsylvania Railroad");
            }
            if(space == 16)
            {
                money -= 180;
                cards.add("St. James Place");
            }
        
            if(space== 18)
            {
                money -= 180;
                cards.add("Tennesse Avenue");
            }
            if(space == 19)
            {
                money -= 200;
                cards.add("New York Avenue");
            }
        
            if(space == 21)
            {
                money -= 220;
                cards.add("Kentucky Avenue");
            }
        
            if(space == 23)
            {
                money -= 220;
                cards.add("Indiana Avenue");
            }
            if(space == 24)
            {
                money -= 240;
                cards.add("Illinois Avenue");
            }
            if(space == 25)
            {
                money -= 200;
                cards.add("B&O Railroad");
            }
            if(space == 26)
            {
                money -= 260;
                cards.add("Atlantic Avenue");
            }
            if(space == 27)
            {
                money -= 260;
                cards.add("Ventor Avenue");
            }
            if(space== 28)
            {
                money -= 150;
                cards.add("Water Works");
            }
            if(space == 29)
            {
                money -= 280;
                cards.add("Marvin Gardins");
            }
       
            if(space == 31)
            {
                money -= 300;                
                cards.add("Pacific Avenue");
            }
            if(space == 32)
            {
                money -= 300;
                cards.add("North Carolina Avenue");
            }
        
            if(space == 34)
            {
                money -= 320;
                cards.add("Pennsylvania Avenue");
            }
            if(space == 35)
            {
                money -= 200;
                cards.add("Short Line");
            }
      
            if(space == 37)
            {
                money -= 350;
                cards.add("Park Place");
            }
        
            if(space == 39)
            {
                money -= 400;
                cards.add("Boardwalk");
            }
            if(cards.size() > 1)
            {
                numOfProperties += 1;
            }
            if(money < 0)
            {
                cards.remove(numOfProperties);
                System.out.println("You don't have enough money to buy");
                System.out.println("Do you want to mortgage(m) or Auction(a)");
                s1 = scanner.nextLine();
                while(s1 != "m" || s1 != "M" || s1 != "a" || s1 != "A")
                {
                    System.out.println("Invalid character");
                    System.out.println("Do you want to mortgage(m) or Auction(a)");
                    s1 = scanner.nextLine();
                }
                if(s1 == "m" || s1 == "M")
                {
                    for(int k = 0; k < cards.size(); k++)
                    {
                        System.out.println(cards.get(k));
                    }
                    System.out.println("Which property do you want to mortgage?");
                    s1 = scanner.nextLine();
                    cards.indexOf(s1);
                    if(cards.indexOf(s1) == -1)
                    {
                    }
                   
                    return mortgage();
                }
                
            }
            return money;
            //do more
           }
           return money;
    }
    */
    /**
     * /public int mortgage()
    {
            if(cards.size() >= 1)
            {
                for(int k = 0; k < cards.size(); k++)
                {
                    System.out.println(cards.get(k));
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Which property do you want to mortgage?");
                String s1 = scanner.nextLine();
        
                while(cards.indexOf(s1) == -1)
                {
                    System.out.println("You don't have that property, please try again.");
                    System.out.println("Which property do you want to mortgage?");
                    s1 = scanner.nextLine();
                }
                if(s1 == "Mediterranean Avenue" || s1 == "Baltic Avenue")
                {
                    money += 30;
                    cards.remove(cards.indexOf(s1));
                }
                if(s1 == "Reading Railroad" || s1 == "Pennsylvania Railroad" || s1 == "B&O Railroad" || s1 == "Short Line")
                {
                    money += 100;
                }                
            }
            return 1;
    }
     */
}
