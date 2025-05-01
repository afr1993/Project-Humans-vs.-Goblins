import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Adian Flores Rangel Human vs Goblin
        Scanner scanner = new Scanner(System.in);
        Human player = new Human(0,0);
        World world = new World(player);

        while (true){
            world.render();//Render World Map
            System.out.println("Controls : n/s/e/w");
            String direction = scanner.next();

            if (direction.equalsIgnoreCase("i")) {
                player.getInventory().showInventory();
            } else {
                world.movePLayer(direction);
            }
        }

    }
}