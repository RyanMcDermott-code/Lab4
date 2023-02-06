/**
 * @author RyanMcDermott
 * @createdOn 1/30/2023 at 1:05 PM
 * @projectName ZombieGenerator
 * @packageName main.models;
 */
package main.models;

public class Runner extends Zombie{

    public Runner() {
        setArms(generateStat(0,2));
        setLegs(generateStat(0,2));
        setBaseHP(generateStat(10, 22));
        setSpeed(generateStat(15, 25));
        calculateClimbSpeed(speed);
    }
    public Runner(int arms, int legs, int baseHP, int speed) {
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
        calculateClimbSpeed(speed);
    }
    @Override
    public int attack(int roll) {
        //single d20 roll must be passed in
        //if below 5 the attack misses dealing 0 damage
        //if attack is between 5 and 18 the attack hits and 2d8 are rolled to determine the damage dealt.
        //if attack is 19 or 20 the attack is a critical hit and does double damage, multiples result by 2
        //return total damage dealt
        if(roll < 5) {
            //miss
            setAttackSuccess("Miss!");
            return 0;
        }else if(roll == 20 || roll == 19) {
            //critical hit
            setAttackSuccess("Critical Hit!!!");
            return roll(8, 2) * 2;
        }else if(roll >= 5 && roll <= 18) {
            //regular attack
            setAttackSuccess("Hit!");
            return roll(8, 2);
        }else {
            return -1;
        }
    }


    @Override
    public void setBaseHP(int baseHP) {
        //Runner health range is 10 to 22
        if(baseHP < 10 || baseHP > 22) {
            throw new IllegalArgumentException("BaseHP must be between 10 and 22 for " + this.getClass().getName());
        }
        this.baseHP = baseHP;
    }

    @Override
    public void setSpeed(int speed) {
        //Runner speed range is 15 to 25
        if(speed < 15 || speed > 25) {
            throw new IllegalArgumentException("Speed must be between 15 and 25 for " + this.getClass().getName());
        }
        this.speed = speed;
    }

    private int calculateClimbSpeed(double speed) {
        //climbspeed is 1/3 speed
        speed  = speed * 0.3333333;
        int climbSpeed = (int)Math.round(speed);
        return climbSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ClimbSpeed=" + calculateClimbSpeed(speed) +
                "}"
                ;
    }
}
