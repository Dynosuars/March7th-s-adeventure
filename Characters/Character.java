package Characters;

public abstract class Character {

    // Base
    protected String name;
    protected String desc;
    
    protected double exp;
    // I AM not using a function to keep track of level
    protected int level;
    protected final Stats stat;

    // Skill sets
    Moveset moves;

    // Equipment (Sword only)
    Weapon sword;

    // Real time variables
    protected double health;

    // Static constant variables
    public static int _start_xp = 50;
    public static double _xp_gain_rate = 0.02;
    public static Stats increase_rate = new Stats(25, 25, 25, 0, 2, 0);

    /**
     * Abstractive character class.
     * @param name<String> desc
     * @param description<String> desc
     * @param stat<Stats>, just the stats
     * @param 
     */
    public Character(String name, String description, Stats stat) {
        this.name = name;
        this.desc = description;
        this.level = 1;
        this.exp = _start_xp;
        this.stat = stat!=null?stat: Stats.baseStat;
        this.health = this.stat.HEP;
        this.moves = new Moveset(null, null, null);
    }

    /**
     * get level
     * @return
     */
    public int getLevel(){
        return this.level;
    }

    /**
     * Gets the health
     * @return
     */
    public double getHealth(){
        return this.health;
    }

    /**
     * Gets hit and also will heal if damage is negative lol
     * @param damage
     */
    public void getHit(double damage){
        this.health -= damage;
    }

    public Stats getStats(){
        return this.stat;
    }

    /**
     * Gets the name
     * @return
     */
    public String getName(){
        return this.name;
    }

    public int gain_xp(double amount){
        int res = 0;
        // gather js for easy calc
        double xp = this.exp + amount;


        // Levels will be calculated by a recursion formula of
        // a_n = (a_n-1 + 40)(1.04); a_0 = 50
        // explicit formula of f(x) = (50 + 20x) (1.02)^x;
        int curr = xp_req();
        while(xp > curr){

            // Debug
            /*System.out.println("XP: " + xp);
            System.out.println("RES: " + res);
            System.out.println("XP_REQ " + xp_req());*/

            curr = xp_req();
            xp -= curr;
            res++;
        }

        this.exp = xp;
        this.level+=res;
        return res;
    }

    /**
     * The Xp required to level up
     * @return
     */
    public int xp_req(){
        return (int) Math.round((_start_xp + this.level * 20)* Math.pow(1 + _xp_gain_rate, this.level));
    }

    public int hit(int skill, Character other){
        return this.moves.Use(skill, this, other);
    }
    





}
