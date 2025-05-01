public class Human  extends Entity{

    public Human (int startCordX, int startCordY) {
        this.cordX = startCordX;
        this.cordY = startCordY;
    }

    @Override
    public String toString(){
        return "🧍";//Human representation
    }
}
