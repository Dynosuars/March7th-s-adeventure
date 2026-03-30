package Enemies;

import Characters.Character;
import Characters.Stats;

public class Enemy extends Character {

    private final int money_drop;
    private final int exp_drop;
    
    public Enemy(String name, String description, Stats stat, int money, int exp){
        super(name, description, stat);
        this.money_drop = money;
        this.exp_drop = exp;
    }
    
}
