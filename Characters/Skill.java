package Characters;

import java.util.function.BiFunction;

public class Skill {
    final private BiFunction<Character, Character, Double> skill;
    final private String name;
    final public int skillPoint;

    // To Picture
    final private String url;

    public Skill(String name, String url, int skillPoint, BiFunction<Character, Character, Double> func){
        this.name = name;
        this.skillPoint = skillPoint;
        this.url = url;
        this.skill = func;
    }

    @Override 
    public String toString(){
        return this.name;
    }

    public Double call(Character self, Character other){
        return this.skill.apply(self, other);
    }

    public String getURL(){
        return this.url;
    }


}
