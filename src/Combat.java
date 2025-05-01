public class Combat {

    public static boolean resolveFight(Human player, Goblin goblin){
        int playerHealth = 100;
        int goblinHealth = 80;

        System.out.println("Combat Start: ");

        while (playerHealth > 0 && goblinHealth > 0) {
            int playerAttack = (int)(Math.random() * 16) + 7;
            int goblinAttack = (int)(Math.random() * 10) + 9;

            goblinHealth -= playerAttack;
            System.out.println("🧍 Attacks: " + playerAttack + " Damage. \n👹 Health left: " + Math.max(0, goblinHealth));

            if (goblinHealth <= 0) break;

            playerHealth -= goblinAttack;
            System.out.println("👹 Attacks: " + goblinAttack + " Damage. \n🧍Health left: " + Math.max(0, playerHealth));
        }

        if (playerHealth > 0) {
            System.out.println("You Win :D");
            Item drop = goblin.getDrop();//obtain item
            player.getInventory().addItem(drop);// add item to the inventory
            return true;  // Players WIN

        } else {
            System.out.println("You Lose Goblin WINS Evil laugh...");
            System.exit(0); // Goblin Wins Ends Program
            return false;
        }
    }
}