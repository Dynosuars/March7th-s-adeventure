package Characters;

public class Stats {
    public int ATK;
    public int HEP;
    public int DEF;
    public int SPD;
    public int CRD;
    public int CRR;

    /**
     * Stats, this will be used throughout the entire game. ENTIRELY based on Honkai starrail/genshin
     * @param atk
     * @param hep
     * @param def
     * @param spd
     * @param crd
     * @param crr
     */
    public Stats(int atk, int hep, int def, int spd, int crd, int crr) {
        this.ATK = atk;
        this.HEP = hep;
        this.DEF = def;
        this.SPD = spd;
        this.CRD = crd;
        this.CRR = crr;
    }
}
