public class Goblin extends Entity{

    public Goblin (int startCordX, int startCordY) {
        this.cordX = startCordX;
        this.cordY = startCordY;
    }

    @Override
    public String toString(){
        return "👹";//Goblin representation
    }
}
