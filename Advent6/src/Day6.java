import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Gustav on 2016-12-08.
 */
public class Day6 {

    private static final String filename = "C:\\Users\\Gustav\\IdeaProjects\\Advent6\\src\\input.txt";
    public static void main(String[] args) {
        String everything = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            br.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        String[] parts = everything.split("\\s+");
        System.out.println("Result from Day6A: "+ new Day6().RepetitionCode(parts));
    }

    String RepetitionCode(String [] parts) {
        HashMap<Integer,String> columns = new HashMap<>();
        String res = "";
        for(int i= 0; i<parts.length; i++){
            for(int j = 0; j< parts[j].length(); j++) {
                if(columns.containsKey(j)){
                    columns.put(j, columns.get(j) + parts[i].charAt(j));
                }
                else {
                    columns.put(j, "" + parts[i].charAt(j));
                }
            }
        }

        for(int i= 0; i < parts[i].length(); i++){
            //System.out.println(columns.get(i));
            res += mostOccuring(columns.get(i));
        }
        return res;
    }
    String mostOccuring(String col){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> mapOfOccurence = new HashMap<>();
        String mostOccuringChar = "";
        for(int i = 0; i<col.length(); i++){
            char key = col.charAt(i);
            if(mapOfOccurence.containsKey(key)){
                mapOfOccurence.put(key,mapOfOccurence.get(key) + 1);
            }
            else {
                mapOfOccurence.put(key,1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mapOfOccurence.entrySet()) {
            list.add(entry.getValue());
        }

        Collections.sort(list);
        //Set list.get(0) for least occured character
        //Set list.size()-1) for most occured character
        for (Map.Entry<Character, Integer> entry : mapOfOccurence.entrySet()) {
            if (entry.getValue() == list.get(0)) {
                mostOccuringChar = entry.getKey().toString();
                break;
            }
        }
        System.out.println("mostOccuringStrin: " + mostOccuringChar);



        return mostOccuringChar;
    }

}
