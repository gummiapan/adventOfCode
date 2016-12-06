import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gustav on 2016-12-05.
 */
public class test {

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }


    public Direction DirectionAfterInput(Direction direction, String dir, int steps) {
        switch (direction) {
            case NORTH:
                if (dir.equals("R")) {
                    //System.out.println("East");
                    location.setX(steps);
                    for(int i = 0; i<steps; i++){
                        Point key = new Point(location.getStepsX() - i,location.getStepsY());
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.EAST;
                } else {
                    //System.out.println("West");
                    location.setX(-steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX() + i,location.getStepsY());
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.WEST;
                }

            case SOUTH:
                if (dir.equals("R")) {
                    //System.out.println("West");
                    location.setX(-steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX() + i,location.getStepsY());
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.WEST;
                } else {
                    //System.out.println("East");
                    location.setX(steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX() - i,location.getStepsY());
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.EAST;
                }
            case EAST:
                if (dir.equals("R")) {
                    //System.out.println("South");
                    location.setY(-steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX(),location.getStepsY() + i);
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.SOUTH;
                } else {
                    //System.out.println("North");
                    location.setY(steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX(),location.getStepsY()-i);
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.NORTH;
                }
            case WEST:
                if (dir.equals("R")) {
                    //System.out.println("North");
                    location.setY(steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX(),location.getStepsY()-i);
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.NORTH;
                } else {
                    //System.out.println("South");
                    location.setY(-steps);
                    for(int i = 1; i<steps; i++){
                        Point key = new Point(location.getStepsX(),location.getStepsY()+i);
                        if(mapOfLocations.containsKey(key)){
                            System.out.println("Point: " + mapOfLocations.get(key));
                        }
                        else {
                            mapOfLocations.put(key,key.getLocation());
                        }
                    }
                    return Direction.SOUTH;
                }
            /*default:
                if(dir == "R") {
                    System.out.println("East");
                    location.setX(steps);
                    return Direction.EAST
                }
                else {
                    System.out.println("West");
                    location.setX(-steps);
                    return Direction.WEST;
                }
              */


        }
        return direction;
    }

    public void printLocation(){
        System.out.println(location.getStepsX() + " X axis");
        System.out.println(location.getStepsY() + " Y axis");
    }
    public Map<Point, Object> mapOfLocations = new HashMap<Point, Object>();
    public Location location = new Location(0,0);
    public static void main (String args []){

        Direction currentDirection;
        test santa = new test();
        String inputdata = "R4, R3, R5, L3, L5, R2, L2, R5, L2, R5, R5, R5, R1, R3, L2, L2, L1, R5, L3, R1, L2, " +
                "R1, L3, L5, L1, R3, L4, R2, R4, L3, L1, R4, L4, R3, L5, L3, R188, R4, L1, R48, L5, R4, R71, R3, L2," +
                " R188, L3, R2, L3, R3, L5, L1, R1, L2, L4, L2, R5, L3, R3, R3, R4, L3, L4, R5, L4, L4, R3, R4, L4, " +
                "R1, L3, L1, L1, R4, R1, L4, R1, L1, L3, R2, L2, R2, L1, R5, R3, R4, L5, R2, R5, L5, R1, R2, L1, L3" +
                ", R3, R1, R3, L4, R4, L4, L1, R1, L2, L2, L4, R1, L3, R4, L2, R3, L1, L5, R4, R5, R2, R5, R1, R5," +
                " R1, R3, L3, L2, L2, L5, R2, L2, R5, R5, L2, R3, L5, R5, L2, R4, R2, L1, R3, L5, R3, R2, R5, L1," +
                " R3, L2, R2, R1";
        String test1 = "R2, L3";
        String test3 = "R5, L5, R5, R3";
        String test4 = "R8, R4, R4, R8";
        int steps = 0;
        String dir;
        inputdata.trim();
        //System.out.println(test4);
        currentDirection = Direction.NORTH;
        for (String retval: inputdata.split(",")){
            String ret = retval.trim();
           dir = Character.toString(ret.charAt(0));
           steps = Integer.parseInt(ret.substring(1));
           //System.out.println("Dir: " + dir + " steps: " + steps);
           currentDirection = santa.DirectionAfterInput(currentDirection,dir,steps);

        }
        
        

        santa.printLocation();

    }
}
