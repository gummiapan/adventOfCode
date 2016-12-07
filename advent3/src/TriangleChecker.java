import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gustav on 2016-12-06.
 */
public class TriangleChecker {

    private static final String filename = "C:\\Users\\Gustav\\IdeaProjects\\advent3\\src\\input.txt";

    public static void main (String [] args) {
        BufferedReader br = null;
        FileReader fr = null;
        String txt = "";
        StringBuilder sb = new StringBuilder();
        int numberOfTrinalges = 0;


        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            txt = sb.toString();
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        TriangleChecker triCheck = new TriangleChecker();

        for(String retval: txt.split("\\r?\\n")){
            retval = retval.trim();
            String [] triangleMeassurements = retval.split("\\s+");
            numberOfTrinalges += triCheck.isTriangle(triangleMeassurements[0],triangleMeassurements[1], triangleMeassurements[2]);
        }
        System.out.println("Number of triangles: " + numberOfTrinalges);

    }

    public Integer isTriangle(String aString, String bString, String cString){
        int a = Integer.valueOf(aString);
        int b = Integer.valueOf(bString);
        int c = Integer.valueOf(cString);
        int retVal = 0;
        if ((a + b > c) && (a+c > b) && (b+c > a)){
            return 1;
        }
        else
            return 0;
    }


}
