import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Gustav on 2016-12-06.
 */
public class advent3bTriangle {


    private static final String filename = "C:\\Users\\Gustav\\IdeaProjects\\advent3b\\src\\input.txt";

    public static void main (String [] args) {
        BufferedReader br = null;
        FileReader fr = null;
        String txt = "";
        StringBuilder sb = new StringBuilder();
        advent3bTriangle adv3b = new advent3bTriangle();

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

        //TriangleChecker triCheck = new TriangleChecker();
        ArrayList col1 = new ArrayList();
        ArrayList col2 = new ArrayList();
        ArrayList col3 = new ArrayList();
        int nrOfTriangles = 0;
        for(String retval: txt.split("\\r?\\n")){
            retval = retval.trim();
            String [] triangleMeassurements = retval.split("\\s+");
            col1.add(triangleMeassurements[0]);
            col2.add(triangleMeassurements[1]);
            col3.add(triangleMeassurements[2]);

        }
        nrOfTriangles += adv3b.iterateColumn(col1);
        nrOfTriangles += adv3b.iterateColumn(col2);
        nrOfTriangles += adv3b.iterateColumn(col3);




        System.out.println("Number of triangles: " + nrOfTriangles);

    }


    public int iterateColumn(ArrayList listOfColNrs) {
        int triangleCount = 0;
        for (int i = 0; i < listOfColNrs.size(); i +=3){
            String first = listOfColNrs.get(i).toString();
            String second = listOfColNrs.get(i+1).toString();
            String third = listOfColNrs.get(i+2).toString();
            triangleCount += isTriangle(first,second,third);
        }
        return triangleCount;

    }

    public int isTriangle(String first, String second, String third) {
        int a = Integer.valueOf(first);
        int b = Integer.valueOf(second);
        int c = Integer.valueOf(third);
        if ((a + b > c) && (a+c > b) && (b+c > a)){
            return 1;
        }
        else
            return 0;
    }



}
