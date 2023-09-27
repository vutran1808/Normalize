package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.*;

public class Algorithm {

    StringBuffer strb = new StringBuffer();

    public String readFile(String type) {
        File file = new File("src\\model\\" + type + ".txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                strb.append(line);
                line = br.readLine();
            }
        } catch (Exception e) {
        }
        return strb.toString();
    }

    public String Normalize(String text) {
        text = text.replaceAll("[\\s&&[^\\n]]+", " ")
                .replaceAll("\\s*,\\s*", ", ")
                .replaceAll("\\s:\\s*", ": ")
                .replaceAll("\\n+", "\n")
                .replaceAll("^\n|\n$", "")
                .replaceAll("\\s*\\s", " ");
        String temp = "";
        String[] str = text.split("\\.");
        for (String string : str) {
            String toUpperCase = string.substring(0, 1).toUpperCase();
            String lineUpper = toUpperCase + string.substring(1);
            temp += lineUpper + ".";
        }
        text = temp;
//
//        Pattern pattern = Pattern.compile("(\")(.+)(\")");
//        Matcher matcher = pattern.matcher(text);
//        if (matcher.find()) {
//            text = text.replace(matcher.group(2), matcher.group(2).trim());
//        }
        return text;
    }

    public void writeFile(String text, String type) {
         File file = new File("src\\model\\" + type + ".txt");
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.print(text);
            pw.close();
        } catch (Exception e) {
        }
    }

}
