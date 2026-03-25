package Characters;

public class Skills {
    private final String atkName;
    private final String secName;
    private final String ultName;
    

    public Skills(String atkName, String secName, String ultName){
        this.atkName = atkName;
        this.secName = secName;
        this.ultName = ultName;
    }

    public String getAtk(){
        return this.atkName;
    }

    public String secName(){
        return this.secName;
    }

    public String ultName(){
        return this.ultName;
    }


}
