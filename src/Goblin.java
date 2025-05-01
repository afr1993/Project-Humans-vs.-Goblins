public class Goblin extends Entity{

    Item drop;

    public Goblin (int startCordX, int startCordY) {
        this.cordX = startCordX;
        this.cordY = startCordY;
        this.drop = generateRandomDrop();
    }

    public Item getDrop() {
        return drop;
    }

    @Override
    public String toString(){
        return "👹";//Goblin representation
    }

    private Item generateRandomDrop() {
        String[] possibleDrops = {"Wooden Sword", "Potion", "Gold", "Shield","Armor"};
        int i = (int)(Math.random() * possibleDrops.length);
        return new Item(possibleDrops[i]);
    }
}
