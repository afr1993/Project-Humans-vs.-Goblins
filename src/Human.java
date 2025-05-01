public class Human  extends Entity{
    Inventory inventory;

    public Human (int startCordX, int startCordY) {
        this.cordX = startCordX;
        this.cordY = startCordY;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString(){
        return "🧍";//Human representation
    }
}
