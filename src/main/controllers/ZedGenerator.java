/**
 * @author RyanMcDermott
 * @createdOn 1/30/2023 at 1:04 PM
 * @projectName ZombieGenerator
 * @packageName main.controllers;
 */
package main.controllers;

import main.models.*;
import main.views.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZedGenerator {
    private List<Zombie> horde = new ArrayList<Zombie>();
    public static final Random RANDOM = new Random();
    public static final int MAX_ZEDS = 10000;
    private UI ui= new UI();
    public void run(){

        boolean usingProgram = true;
        do{
            int selection = ui.displayMainMenu();
            switch (selection){

                case 1://generate 1 zed
                    generateZed(1);
                    showZombie();
                    horde.clear();
                    break;
                case 2://generate 1 to 10 zeds
                    generateZed(RANDOM.nextInt(9) + 1);
                    showZombie();
                    horde.clear();
                    break;
                case 3: //generate n zeds
                    generateZed(ui.howManyZeds());
                    showZombie();
                    horde.clear();
                    break;
                case 4: //exit
                    usingProgram = false;
                    ui.displayGoodbyeMessage();
                    break;
            }
        }while(usingProgram);
    }

    private void generateZed(int count) {
        for (int i = 0; i < count; i++) {
            horde.add(randomZedType());
        }
    }
    private Zombie randomZedType() {
       int type = RANDOM.nextInt(2) + 1;
        switch (type) {
            case 1:
                return new Tank();
            case 2:
                return new Runner();
            default:
                return new Walker();
        }
    }
    private void showZombie() {
        for (Zombie zed : horde) {
            ui.displayZeds(zed);
            int attackDamage = zed.attack(zed.roll(20, 1));
            ui.attackZombie(attackDamage, zed.getAttackSuccess());
        }
    }


}
