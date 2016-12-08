
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by Gustav on 2016-12-08.
 */
public class Day5 {
    private static final String filename = "C:\\Users\\Gustav\\IdeaProjects\\Advent5\\src\\input.txt";
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
        System.out.println(new Day5().hashedPasswordTwo(parts));
    }

    String hashedPasswordOne(String [] pw) {
        String password = "";
        for(int i =0; i<pw.length; i++){
            String unHashedPw = pw[i];
            int eightLetterPw = 0;
            int index = 0;
            while (eightLetterPw < 8){

                String hashedPw = getHash(unHashedPw + index);
                if(hashedPw.startsWith("00000")){
                    eightLetterPw++;
                    password += hashedPw.charAt(5);
                }
                index++;
            }
        }
        return password;
    }

    String hashedPasswordTwo(String [] pw) {
        String password ="";
        for(int i =0; i<pw.length; i++){
            String doorId = pw[i];
            int eightLetterPw = 0;
            int index = 0;
            HashMap<Integer, Character> code = new HashMap<>();
            while (eightLetterPw < 8){

                String hashedPw = getHash(doorId + index);
                if (hashedPw.startsWith("00000")){
                    int possibleIndex = Character.getNumericValue(hashedPw.charAt(5));
                    char possibleNumber = hashedPw.charAt(6);

                    if (possibleIndex >= 0 && possibleIndex <= 7){
                        if(code.containsKey(possibleIndex)){

                        }
                        else {
                            code.put(possibleIndex, possibleNumber);
                            eightLetterPw++;
                        }
                    }
                }
                index++;
            }
            for(int j = 0; j< code.size(); j++){
                password += code.get(j);
            }
        }
        return password;
    }

    String getHash(String idPlusIndex){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(idPlusIndex.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte h : hash) {
                String hex = Integer.toHexString(0xFF & h);
                if (hex.length() == 1)
                    hexString.append("0");
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
