import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ParserList {


    private String rawData;

    public ParserList(){
        this.rawData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getRawData() {

        return rawData;
    }

        public void patterMatcher(){

            String text    =
                    "This is the text to be searched " +
                            "for occurrences of the pattern.";

            String pattern = ".*is.*";

            boolean matches = Pattern.matches(pattern, text);

            System.out.println("matches = " + matches);
        }


}
