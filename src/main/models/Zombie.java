/**
 * @author RyanMcDermott
 * @createdOn 1/30/2023 at 1:04 PM
 * @projectName ZombieGenerator
 * @packageName main.models;
 */
package main.models;

import java.util.Random;

public abstract class Zombie {

    //arms and legs must be between 0 and 2
    private int arms;
    private int legs;
    protected int baseHP;
    protected int speed;
    private String attackSuccess;
    private int attackDamage;
    public static final Random RANDOM = new Random();


    protected static int roll(int sides, int dice) {
        /*
    Roll method simulates multiple type of dice rolls.
    Sides is the number of sides to the dice.
    Dice is the number of dice being rolled.
    All dice will have the same amount of sides.
    Total will be returned.
     */
        int roll = 0;

        for(int i = 0; i < dice; i++) {
            roll += RANDOM.nextInt(sides) + 1;
        }
        return roll;

        /* Old roll method, simpler but doesn't simulate correct probability
        int out = (new Random().nextInt(sides) + 1) * dice;
        return out;
        */

    }


    protected static int generateStat(int lowBound, int highBound) {
        int randomInclusive =  RANDOM.nextInt((highBound - lowBound) + 1) + lowBound;
        return randomInclusive;
    }


    public abstract int attack(int roll);





    protected int getArms() {
        return arms;
    }


    //region Getters/Setters
    protected void setArms(int arms) {
        if(arms < 0 || arms > 2) {
            throw new IllegalArgumentException("Arms must be between 0 and 2!");
        }
        this.arms = arms;
    }

    protected int getLegs() {
        return legs;
    }

    protected void setLegs(int legs) {
        if(legs < 0 || legs > 2) {
            throw new IllegalArgumentException("Legs must be between 0 and 2!");
        }
        this.legs = legs;
    }

    protected int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    protected int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }



    protected String getAttackSuccess() {
        return attackSuccess;
    }

    protected void setAttackSuccess(String attackSuccess) {
        this.attackSuccess = attackSuccess;
    }

    protected int getAttackDamage() {
        return attackDamage;
    }
    //endregion
    protected void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{ [Statistics: BaseHP=" + getBaseHP() +
                ", Arms=" + getArms() +
                ", Legs=" + getLegs() +
                ", Speed=" + getSpeed();
    }
}
