public abstract class Entity {
  protected int cordX, cordY;

    public Entity(int cordY, int cordX) {
        this.cordY = cordY;
        this.cordX = cordX;
    }

    protected Entity() {
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void  setPosition (int newCordX , int newCordY){
        this.cordX = newCordX;
        this.cordY = newCordY;
    }

    //Visual representation
    public abstract String toString();


}
