package Characters;

public abstract class Characters {

    // Base
    private String name;
    private String description;

    private double exp;
    // I AM not using a function to keep track of level
    private double level;


    /**
     * Abstractive character class.
     * @param name
     * @param description
     * @param 
     */
    public Characters(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
