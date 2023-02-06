/**
 * @author RyanMcDermott
 * @createdOn 1/30/2023 at 1:05 PM
 * @projectName ZombieGenerator
 * @packageName main.views;
 */
package main.views;

import main.controllers.ZedGenerator;
import main.models.*;
import java.util.ArrayList;

public class UI {

    public static int displayMainMenu() {
        int selection = -1;
        do{
            Console.writeLn("Select a menu option: ", Console.TextColor.BLUE);
            Console.writeLn("""
                    1. Generate 1 zed
                    2. Generate some zeds
                    3. Generate n zeds
                    4. Exit
                    """);
            selection = Console.getIntInput("Your selection?", Console.TextColor.CYAN);
            if(selection < 1 || selection > 4){
                selection = -1;
                Console.writeLn("Invalid Option! Choose only 1 through 4!", Console.TextColor.RED);
            }

        }while(selection == -1);
        return selection;
    }
    public static int howManyZeds() {
        addHorizontalLine();
        int count = -1;
        do{
            Console.writeLn("How many zeds would you like?", Console.TextColor.BLUE);
            count = Console.getIntInput("Enter Number between 1 and " + ZedGenerator.MAX_ZEDS, Console.TextColor.CYAN);
            if(count < 1 || count > ZedGenerator.MAX_ZEDS){
                count = -1;
                Console.writeLn("Invalid Option! Must be between 1 and " + ZedGenerator.MAX_ZEDS + "!", Console.TextColor.RED);
            }
        }while (count == -1);
        return count;
    }

    public void displayZeds(ArrayList<Zombie> horde) {
        for (Zombie zombie : horde) {
            Console.write(zombie.toString(), Console.TextColor.GREEN);
            attackZombie(zombie);
        }
        addHorizontalLine();
    }

    public static void displayGoodbyeMessage(){
        Console.writeLn("Goodbye!", Console.TextColor.GREEN);
    }
    private static void addHorizontalLine(){
        Console.writeLn("----------------------------------------------------", Console.TextColor.BLACK);
    }
    private static void attackZombie(Zombie zed) {
        int attackDamage = zed.attack(zed.roll(20, 1));
        Console.write(" Attack[ " + zed.getAttackSuccess() + " " + attackDamage + " damage]", Console.TextColor.RED);
        Console.writeLn("");
    }
}
