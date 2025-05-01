import java.util.List;
import java.util.Random;
import java.util.ArrayList;


public class World {

    private final static int worldSize = 10;
    private Human player;
    private List<Goblin> goblinList;

    public World(Human player) {
        this.player = player;
        this.goblinList = new ArrayList<>();
        generateGoblins(5);
    }

    private void generateGoblins(int countGoblins) {
        Random random = new Random();
        for (int i = 0; i < countGoblins; i++) {
            int x, y;
            do {
                x = random.nextInt(worldSize);
                y = random.nextInt(worldSize);
            } while ((x == player.getCordX() && y == player.getCordY()) || goblinAtPosition(x, y) != null); // Evita solapamiento
            goblinList.add(new Goblin(x, y));
        }
    }

    private Goblin goblinAtPosition(int x, int y) {
        for (Goblin g : goblinList) {
            if (g.getCordX() == x && g.getCordY() == y) {
                return g;
            }
        }
        return null;
    }

    // Render Maps
    public void render() {
        for (int i = 0; i < worldSize; i++) {
            for (int j = 0; j < worldSize; j++) {
                if (i == player.getCordX() && j == player.getCordY()) {
                    System.out.print(player + " "); // player
                } else {
                    Goblin g = goblinAtPosition(i,j);
                    if(g != null){
                        System.out.print(g +" ");
                    }else{
                        System.out.print("· "); // Empty space
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean isPlayerInseideMap(int cordX, int cordY){
        if (cordX >= 0 && cordX < worldSize && cordY >= 0 && cordY < worldSize) {
            return true;
        } else {
            return false;
        }
    }

    public void movePLayer(String direction){

        int newCordX = player.getCordX();
        int newCordY = player.getCordY();

        switch(direction.toLowerCase()){
            case "w": newCordY--;
                break;
            case "n": newCordX--;
                break;
            case "s": newCordX++;
                break;
            case "e": newCordY++;
                break;
            default:
                System.out.println("Invalid Direction");
                return;
        }

        if (isPlayerInseideMap(newCordX,newCordY)) {

            player.setPosition(newCordX, newCordY);

        }else{
                System.out.println("Out of the map XXX");
        }

        Goblin g = goblinAtPosition(newCordX, newCordY);
        if (g != null){
            boolean won = Combat.resolveFight(player,g);
            if(won){
                goblinList.remove(g);
                player.setPosition(newCordX,newCordY);
            }
        }else{
            player.setPosition(newCordX,newCordY);
        }

    }
}
