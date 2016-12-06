import java.util.HashMap;

/**
 * Created by Gustav on 2016-12-05.
 */
public class Location {
    private int stepsX;
    private int stepsY;

    public Location(int x, int y){
        stepsX = x;
        stepsY = y;

    }

    public void setX(int steps) {
        stepsX = stepsX + steps;
    }

    public void setY(int steps) {
        stepsY = stepsY + steps;
    }

    public int getStepsX(){
        return stepsX;
    }
    public int getStepsY(){
        return stepsY;
    }
    public Location returnLocation(){
        return Location.this;
    }
}
