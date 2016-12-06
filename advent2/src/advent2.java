import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustav on 2016-12-05.
 */
public class advent2 {


    public enum Number {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, A, B, C,D
    }

    private static final String filename = "C:\\Users\\Gustav\\IdeaProjects\\advent2\\src\\input.txt";

    public static void main (String args []) {
        BufferedReader br = null;
        FileReader fr = null;
        String txt = "";
        StringBuilder sb = new StringBuilder();
        List<Number> code = new ArrayList();

        advent2 adv = new advent2();
        aNumber actNr = new aNumber();
        NumpadOne numpadOne = new NumpadOne();
        NumpadTwo numpadTwo = new NumpadTwo();

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
        actNr.setActiveNumber(Number.FIVE);
        for (String retval : txt.split("\\r?\\n")) {
            for (int i = 0; i < retval.length(); i++) {
                //use numpadOne or Two
                actNr.setActiveNumber(numpadTwo.numPad2(retval.charAt(i),actNr.getActiveNumber()));
            }
            code.add(actNr.getActiveNumber());
        }
        System.out.println("Code" + code.toString());
    }

}
