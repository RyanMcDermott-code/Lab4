/**
 * @author RyanMcDermott
 * @createdOn 1/30/2023 at 1:05 PM
 * @projectName ZombieGenerator
 * @packageName main.models;
 */
package main.models;

public class Tank extends Zombie{
    //damageModifier bonus damage applied to every successful attack, 10 to 20 extra
    private int damageModifier;


    public Tank() {
        setArms(generateStat(0,2));
        setLegs(generateStat(0,2));
        setBaseHP(generateStat(45, 70));
        setSpeed(generateStat(4, 8));
        setDamageModifier(generateStat(10, 20));
    }
    public Tank(int arms, int legs, int baseHP, int speed, int damageModifier) {
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
        setDamageModifier(damageModifier);
    }

    @Override
    public int attack(int roll) {
        //single d20 roll must be passed in
        //if below 10 the attack misses dealing 0 damage, no modifier is applied
        //if attack is between 10 and 19 the attack hits and 3d6 are rolled to determine the damage dealt.
        //if attack is 20 the attack is a critical hit and does triple damage, add 3d6 to damage modifier then multiply by 3
        //return total damage dealt
        if(roll < 10) {
            //miss
            setAttackSuccess("Miss!");
            return 0;
        }else if(roll == 20) {
            //critical hit
            setAttackSuccess("Critical Hit!!!");
            return (roll(6, 3) + damageModifier) * 3;
        }else if(roll >= 10 && roll <= 19) {
            //regular attack
            setAttackSuccess("Hit!");
            return roll(6, 3) + damageModifier;
        }else {
            return -1;
        }
    }

    @Override
    public void setBaseHP(int baseHP) {
        //Tank health range 45 to 70
        if(baseHP < 45 || baseHP > 70) {
            throw new IllegalArgumentException("BaseHP must be between 45 and 70 for " + this.getClass().getName());
        }
        this.baseHP = baseHP;
    }

    @Override
    public void setSpeed(int speed) {
        //Tank speed range is 4 to 8
        if(speed < 4 || speed > 8) {
            throw new IllegalArgumentException("Speed must be between 4 and 8 for " + this.getClass().getName());
        }
        this.speed = speed;
    }

    public int getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(int damageModifier) {
        if(damageModifier < 10 || damageModifier > 20) {
            throw new IllegalArgumentException("DamageModifier must be between 10 and 20 for " + this.getClass().getName());
        }
        this.damageModifier = damageModifier;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", DamageModifier=" + getDamageModifier() +
                "}"
                ;
    }
}
