package Characters;

public class Moveset {
    private Skill normal;
    private Skill special;
    private Skill ultimate;

    /**
     * Default skill
     * @param self
     * @param other
     * @return
     */
    private static final Double Normal_attack(Character self, Character other){
        int leveldiff = self.getLevel() - other.getLevel();
        // Used to find damage deduction max is -20% because I don't wanna get by a bunch of low levels
        if(Math.abs(leveldiff) > 20) leveldiff = 20 * self.getLevel() > other.getLevel()?1:-1; 
                                                                                                // Incase division by 0         
        double damage = (self.getStats().ATK * 0.5 * self.getStats().ATK/other.getStats().DEF>0?other.getStats().DEF:1) * (1 +leveldiff/100);
        other.getHit(damage);
        System.out.println(damage);
        System.out.println(leveldiff/100 + 1);
        return damage;
    }

    /**
     * Default skill
     * @param self
     * @param other
     * @return
     */
    private static final Double Normal_Special(Character self, Character other){
        int leveldiff = self.getLevel() - other.getLevel();
        // Used to find damage deduction max is -20% because I don't wanna get by a bunch of low levels
        if(Math.abs(leveldiff) > 20) leveldiff = 20 * self.getLevel() > other.getLevel()?1:-1; 

        double damage = (self.getStats().ATK * 1.2 + 50) * (1 +leveldiff/100);
        other.getHit(damage);
        return damage;
    }

    private static final Double Normal_Ult(Character self, Character other){
        int leveldiff = self.getLevel() - other.getLevel();
        // Used to find damage deduction max is -20% because I don't wanna get by a bunch of low levels
        if(Math.abs(leveldiff) > 20) leveldiff = 20 * self.getLevel() > other.getLevel()?1:-1;

        double damage = (self.getStats().ATK * 1.2 + 0.05 * other.getHealth()) * (1 +leveldiff/100);
        other.getHit(damage);
        return damage;
    }

    public int Use(int skill, Character self, Character other){
        return (int) Math.round(switch(skill){
            case 0-> this.normal.call(self, other);
            case 1-> this.special.call(self, other);
            case 2-> this.ultimate.call(self, other);
            default->-1;
        });
    }

    public Moveset(Skill normal, Skill special, Skill ult){
        this.normal = normal!=null?normal: new Skill("Normal normal attack", "None", -1, Moveset::Normal_attack);
        this.special = special!=null?special: new Skill("Normal special", "None", 1, Moveset::Normal_Special);
        this.special = special!=null?special: new Skill("Normal Ult", "None", 3, Moveset::Normal_Ult);
    }
}
