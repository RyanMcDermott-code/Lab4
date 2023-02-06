/**
 * @author RyanMcDermott
 * @createdOn 1/30/2023 at 1:04 PM
 * @projectName ZombieGenerator
 * @packageName main.models;
 */
package main.models;

public class Walker extends Zombie{


    public Walker() {
        setArms(generateStat(0,2));
        setLegs(generateStat(0,2));
        setBaseHP(generateStat(15, 30));
        setSpeed(generateStat(6, 10));
        setAttackDamage(attack(roll(20,1)));
    }
    public Walker(int arms, int legs, int baseHP, int speed) {
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
        setAttackDamage(attack(roll(20,1)));
    }


    @Override
    public int attack(int roll) {
        //single d20 roll must be passed in
        //if below 8 the attack misses dealing 0 damage
        //if attack is between 8 and 19 the attack hits and 3d6 are rolled to determine the damage dealt.
        //if attack is 20 the attack is a critical hit and does double damage, multiples result by 2
        //return total damage dealt
        if(roll < 8) {
            //miss
            setAttackSuccess("Miss!");
            return 0;
        }else if(roll == 20) {
            //critical hit
            setAttackSuccess("Critical Hit!!!");
            return roll(6, 3) * 2;
        }else if(roll >= 8 && roll <= 19) {
            //regular attack
            setAttackSuccess("Hit!");
            return roll(6, 3);
        }else {
            return -1;
        }
    }




    @Override
    public void setBaseHP(int baseHP) {
        //Walker baseHP range is 15 to 30
        if(baseHP < 15 || baseHP > 30) {
            throw new IllegalArgumentException("BaseHP must be between 15 and 30 for " + this.getClass().getName());
        }
        this.baseHP = baseHP;
    }

    @Override
    public void setSpeed(int speed) {
        //Walker speed range is 6 to 10
        if(speed < 6 || speed > 10) {
            throw new IllegalArgumentException("Speed must be between 6 and 10 for " + this.getClass().getName());
        }
        this.speed = speed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "] Attack[ " + getAttackSuccess() +
                " Damage Dealt: " + getAttackDamage() +
                " ]}"
                ;
    }
}
