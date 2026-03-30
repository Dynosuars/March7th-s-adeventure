import Characters.Stats;
import Enemies.Enemy;
import Players.Player;

public class Main{
    public static void main(String[] args) {
        Player player = new Player("March 7th", "From Honkai", Stats.baseStat);
        System.out.println("Player " + player.getLevel());
        player.gain_xp(100);
        System.out.println("Player " + player.getLevel());

        Enemy enemy = new Enemy("Test", null, Stats.baseStat, 67, 100);


        System.out.println(player.hit(0, enemy));
    }
}