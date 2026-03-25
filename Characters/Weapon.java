package Characters;

/**
 * Weapon class, used for abstractions
 */
public abstract class Weapon {
    public final String name;
    public final String desc;

    // I am not planning to add exp system to weapons
    private final Stats s;

    /**
     * Abstract constructor param
     * @param name
     * @param desc
     * @param s
     */
    public Weapon(String name, String desc, Stats s) {
        this.name = name;
        this.desc = desc;
        this.s = s;
    }

    /**
     * Default construct
     * @param name
     * @param dec
     */
    public Weapon(String name, String dec){
        this.name = name;
        this.desc = dec;
        this.s = new Stats(
            100, 0, 0, 0, 0, 0
         );
    }

    public Stats getStats() {
        return s;
    }

}
