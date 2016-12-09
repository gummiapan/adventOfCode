import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Gustav on 2016-12-08.
 */
public class Day7 {

    private static final String filename = "C:\\Users\\Gustav\\IdeaProjects\\Advent7\\src\\input.txt";
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
        System.out.println("Nummber of IPs supporting TLS: " + new Day7().hasTLS(parts));
        System.out.println("Nummber of IPs supporting SSL: " + new Day7().hasSSL(parts));
    }
    int hasTLS(String [] arrayOfLines){
        int numberOfTLSIP = 0;
        for(int i = 0; i< arrayOfLines.length; i++) {
            String potentialTLS = arrayOfLines[i];
            String reformatedString = "";
            int tmpTLSNr = 0;
            for(int j = 0; j<potentialTLS.length(); j++){
                if(potentialTLS.charAt(j) == '['){
                if(TLSchecker(reformatedString)){
                    tmpTLSNr = 1;
                }
                reformatedString = "";
            }
            else if (potentialTLS.charAt(j) == ']') {
                if(TLSchecker(reformatedString)){
                    tmpTLSNr = 0;
                    break;
                }
                reformatedString = "";
            }
            else {
                reformatedString += potentialTLS.charAt(j);
                if (j == potentialTLS.length()-1){
                    if(TLSchecker(reformatedString)){
                        tmpTLSNr = 1;
                        reformatedString = "";
                    }
                }
            }
        }
            numberOfTLSIP +=tmpTLSNr;
        }
       return numberOfTLSIP;
    }

    Boolean TLSchecker(String subString) {
        if(subString.length() < 4){
            return false;
        }
        else {
            for(int i = 0; i< subString.length()-3; i++){
                if ((subString.charAt(i) == subString.charAt(i + 3 )) &&
                        (subString.charAt(i+1)== subString.charAt(i + 2)) &&
                        (subString.charAt(i) != subString.charAt(i+1))){
                    return true;
                }
            }
        }
        return false;
    }

    int hasSSL(String [] potentialSSLArray) {
        int numberOfSSL = 0;
        for (int i = 0; i < potentialSSLArray.length; i++){
            String sslIP = potentialSSLArray[i];
            int tmpSSLnr = 0;
            ArrayList<String> potABA = new ArrayList<>();
            ArrayList<String> potBAB = new ArrayList<>();
            String subIP = "";
            for(int j = 0; j < sslIP.length(); j++) {
                if(sslIP.charAt(j) == '['){
                    for(String s : SSLchecker(subIP)){
                        potABA.add(s);
                    }
                    subIP = "";
                }
                else if (sslIP.charAt(j) == ']') {
                    for(String s : SSLchecker(subIP)){
                        potBAB.add(s);
                    }
                    subIP = "";
                }
                else {
                    subIP += sslIP.charAt(j);
                    if (j == sslIP.length()-1){
                        for(String s : SSLchecker(subIP)){
                            potABA.add(s);
                        }
                        sslIP ="";
                    }
                }
            }
            for (String ABA: potABA) {
                for(String BAB: potBAB) {
                    if ((ABA.charAt(0) == BAB.charAt(1)) && (ABA.charAt(1) == BAB.charAt(0))){
                        tmpSSLnr = 1;
                    }
                }
            }
            numberOfSSL += tmpSSLnr;
        }
        return numberOfSSL;
    }
    String [] SSLchecker(String subString) {
        ArrayList<String> listOf = new ArrayList<>();
        for(int i = 0; i< subString.length()-2; i++){
            if ((subString.charAt(i) == subString.charAt(i + 2 )) && (subString.charAt(i) != subString.charAt(i+1))){
                listOf.add("" + subString.charAt(i) + subString.charAt(i+1) + subString.charAt(i+2));
            }
        }
        return listOf.toArray(new String[0]);
    }
}
