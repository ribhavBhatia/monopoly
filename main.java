import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class main here.
 *
 * @author (Ribhav Bhatia)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args)
    {
        String roundSummary = "";
        int rent;
        boolean has2;
        System.out.println("----------------------------------------------------");
        System.out.println("Starting Monopoly.exe");
        System.out.println("----------------------------------------------------");
        System.out.println("Please enter number of player (minimum 2 and maximum 4 players are allowed) "); //asking how many players from user using scanner
        String playerName = "";
        ArrayList <Player> players = new <Player> ArrayList();
        int numOfPlayers = 0;
        Scanner scanner = new Scanner(System.in);
        numOfPlayers = scanner.nextInt();
        while (numOfPlayers < 2 || numOfPlayers > 4) //checking if they put in less than 2 players or more than 4
        {
            System.out.println("You have entered invalid numbers of players. Minimum 2 and maximum 4 players are allowed ");
            numOfPlayers = scanner.nextInt();
        }
        scanner.nextLine();
        for(int n = 1; n <= numOfPlayers; n++) //asking user to enter a player's name for each player using a for loop
        {
            System.out.println("Enter name of Player " + n);
            playerName = scanner.nextLine();
            players.add(new Player(playerName)); //adding players into a ArrayList that was created before
        }
        ArrayList <Property> properties = new <Property> ArrayList();
        properties.add(new Property("Medditeranean Avenue", "Brown", 60, 50, 2, 10, 30, 90, 160, 250, 1)); //adding all the properties
        properties.add(new Property("Baltic Avenue", "Brown", 60, 50, 4, 20, 60, 180, 320, 450, 3));
        properties.add(new Property("Oriental Avenue", "Brown", 100, 50, 6, 30, 90, 270, 400, 550, 6));
        properties.add(new Property("Vermont Avenue", "Brown", 100, 50, 6, 30, 90, 270, 400, 550, 8));
        properties.add(new Property("Conneticut Avenue", "Brown", 120, 50, 8, 40, 100, 300, 450, 600, 9));
        properties.add(new Property("St. Charles Place", "Brown", 140, 100, 10, 50, 150, 450, 625, 750, 11));
        properties.add(new Property("States Avenue", "Brown", 140, 100, 10, 50, 150, 450, 625, 750, 13));
        properties.add(new Property("Virginia Avenue", "Brown", 160, 100, 12, 60, 180, 500, 700, 900, 14));
        properties.add(new Property("St. James Place", "Brown", 180, 100, 14, 70, 200, 550, 750, 950, 16));
        properties.add(new Property("Tenessee Avenue", "Brown", 180, 100, 14, 70, 200, 550, 750, 950, 18));
        properties.add(new Property("New York Avenue", "Brown", 200, 100, 16, 80, 220, 600, 800, 1000, 19));
        properties.add(new Property("Kentucky Avenue", "Brown", 220, 150, 18, 90, 250, 700, 875, 1050, 21));
        properties.add(new Property("Indiana Avenue", "Brown", 220, 150, 18, 90, 250, 700, 875, 1050, 23));
        properties.add(new Property("Illinois Avenue", "Brown", 240, 150, 20, 100, 300, 750, 925, 1100, 24));
        properties.add(new Property("Atlantic Avenue", "Brown", 260, 150, 22, 110, 330, 800, 975, 1150, 26));
        properties.add(new Property("Ventor Avenue", "Brown", 260, 150, 22, 110, 330, 800, 975, 1150, 27));
        properties.add(new Property("Marvin Gardens", "Brown", 280, 150, 24, 120, 360, 850, 1025, 1200, 29));
        properties.add(new Property("Pacific Avenue", "Brown", 300, 200, 26, 130, 390, 900, 1100, 1275, 31));
        properties.add(new Property("North Carolina Avenue", "Brown", 300, 200, 26, 130, 390, 900, 1100, 1275, 32));
        properties.add(new Property("Pennsylvania Avenue", "Brown", 320, 200, 28, 150, 450, 1000, 1200, 1400, 34));
        properties.add(new Property("Park Place", "Brown", 350, 200, 35, 175, 500, 1100, 1300, 1500, 37));
        properties.add(new Property("Board Walk", "Brown", 400, 200, 50, 200, 600, 1400, 1700, 2000, 39));
        properties.add(new Property("Reading Railroad", "Railroad", 200, 0, 25, 25, 50, 100, 200, 0, 5));
        properties.add(new Property("Pennsylvania Railroad", "Railroad", 200, 0, 25, 25, 50, 100, 200, 0, 15));
        properties.add(new Property("B & O Railroad", "Railroad", 200, 0, 25, 25, 50, 100, 200, 0, 25));
        properties.add(new Property("Short Line", "Railroad", 200, 0, 25, 25, 50, 100, 200, 0, 35));
        properties.add(new Property("Electric Company", "Utility", 150, 4, 0, 0, 0, 0, 0, 0, 12));
        properties.add(new Property("Water Works", "Utility", 60, 4, 0, 0, 0, 0, 0, 0, 28));
        while (players.size() > 1 ) //checking if there are still more than one player or else game ends
        {
            roundSummary = "";
            for (Player currentPlayer : players) //going through a loop for player's actions
            {
                rent = 0;
                has2 = false;
                do
                {
                    System.out.println(currentPlayer.getName() + " is Rolling!");
                    System.out.println(currentPlayer.getName() + " landed on " + currentPlayer.turn());
                    int space1 = currentPlayer.getSpace();
                    for(Property prop: properties)
                    {
                        if(prop.getSpace() == space1)
                        {
                            if(prop.ifBought()) //chcks if property is bought
                            {
                                    if (currentPlayer.isInCards(prop)) //checks if character has the property
                                    {
                                        if (space1 != 5 && space1 != 15 && space1 != 25 && space1 != 35 && space1 != 12 && space1 != 28)
                                        {
                                            if (prop.howManyHouses() < 5 && currentPlayer.getMoney() >= prop.getPricePerHouse() )
                                            {
                                                currentPlayer.loseMoney(prop.buyHouse()); //builds house
                                                roundSummary += currentPlayer.getName() + " has added house at " + prop.getName() + "\n"; //adds to summary
                                            }
                                        }
                                    }   
                                    else
                                    {
                                        if(prop.getIsMortgage() == false) //if property is not mortgaged
                                        {
                                            rent = prop.getRent();
                                            if(space1 == 12 || space1 == 28) //for water works and electric company
                                            {
                                                for(Property prop2: currentPlayer.getCards())
                                                {
                                                    if(space1 == 12)
                                                    {
                                                        if(prop2.getName().equals("Water Works"))
                                                        {
                                                            has2 = true;
                                                        }
                                                    }   
                                                    else if(space1 == 28)
                                                    {
                                                        if(prop2.getName().equals("Electric Company"))
                                                        {
                                                            has2 = true;
                                                        }
                                                    }
                                                }
                                                if(has2 == false)
                                                {
                                                    rent = 4 * (int)currentPlayer.getNum(); //if other person has one of the two (Electric or Water), then roll is multiplied by 4
                                                }
                                                else
                                                {
                                                    rent = 10 * (int)currentPlayer.getNum(); //if other person has both Electric and Water, then roll is multiplied by 10
                                                }
                                            }
                                            if (currentPlayer.getMoney() < rent)
                                            {
                                                System.out.println("You don't have enough money to pay rent");
                                                roundSummary += currentPlayer.mortgageProperty(rent,roundSummary); //mortgages properties
                                            }   
                                            currentPlayer.loseMoney(rent);
                                            roundSummary += currentPlayer.getName() + " paid rent $" + rent + " to " ;
                                            //checks who has the property so that the rent can be paid to that player
                                            for(Player p:players)
                                            {
                                                if (!p.getName().equals(currentPlayer.getName())) //If the player is not the current player
                                                {
                                                    if(p.isInCards(prop))
                                                    {
                                                        p.addMoney(rent);
                                                        roundSummary += p.getName();
                                                    }
                                                }
                                            }
                                            roundSummary += " for the property " + prop.getName() + "\n";
                                        }
                                    }                               
                            }
                            else
                            {
                                if (currentPlayer.getMoney() >= prop.getPrice()) //if not bought and player has money to buy
                                {
                                    int property = prop.buy();
                                    if (property > 0) //checks if player said yes
                                    {
                                        currentPlayer.loseMoney(property);
                                        currentPlayer.addProperty(prop);
                                        roundSummary += currentPlayer.getName() + " has bought " + prop.getName() + "\n";
                                    }
                                }
                                else
                                {
                                    Scanner sc = new Scanner(System.in);
                                    System.out.println("Do you want to buy this property?(y or n)");
                                    String n = sc.nextLine();
                                    if(n.equals("y") || n.equals("Y"))
                                    {
                                        System.out.println("You don't have enough money for this property");
                                        roundSummary += currentPlayer.mortgageProperty(prop.getPrice(),roundSummary);
                                        if (currentPlayer.getMoney() >= prop.getPrice()) //checks if player has enough money
                                        {
                                            int property = prop.buy();
                                            if (property > 0 )
                                            {
                                                currentPlayer.loseMoney(property);
                                                currentPlayer.addProperty(prop);
                                                roundSummary += currentPlayer.getName() + " has bought " + prop.getName() + "\n";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (currentPlayer.getNum() == currentPlayer.getNum2())
                    {
                        System.out.println(currentPlayer.getName() + " got doubles!");
                    }
                }while(currentPlayer.getNum() == currentPlayer.getNum2());
            }
            ArrayList <Player> playersToRemove = new <Player> ArrayList();
            System.out.println("End of round --- Summary");
            System.out.println(roundSummary);
            for (Player p: players)
            {
                System.out.println(p.getName() + " Balance is: " + p.getMoney());
                if (p.getMoney() < 0)
                {
                    playersToRemove.add(p);//remove the player from the game if the player has negative amount
                }
            }
            for (Player p: playersToRemove) //goes through the number of players in the players to remove List
            {
                players.remove(p); 
            }
        }
        Player p1 = players.get(0); //All the players, except the one, has been removed from the game due to negative balace
        System.out.println("Congratulations " + p1.getName() + " !!! You won the game of Monopoly");
        System.out.println("You have $" + p1.getMoney() + "  in your account and following properties:");
        System.out.println("Property Name -- Mortgaged?");
        for(Property prop: p1.getAllCards()) //prints all of the cards of the player who won
        {
            System.out.println (prop.getName() + " -- " + prop.getIsMortgage());
        }
        
    }
}
