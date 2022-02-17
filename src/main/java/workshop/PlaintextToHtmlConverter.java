package main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    // defined the exception

    private String read() throws MyOwnRuntimeException {

        // should be kept a edible file, not a direct file

        Path filePath = Paths.get("src/test/basicText.txt");
        byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {

        // i- eliminated, to decrease primary obsession

        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();


        for (char characterToConvert : source.toCharArray()) {
            switch (characterToConvert) {
                case '<':
                    convertedLine.add("&lt;");
                    break;
                case '>':
                    convertedLine.add("&gt;");
                    break;
                case '&':
                    convertedLine.add("&amp;");
                    break;
                case '\n':
                    addANewLine(result,convertedLine);
                    convertedLine=new ArrayList<>();
                    break;
                default:
                    pushACharacterToTheOutput(convertedLine, String.valueOf(characterToConvert));

            }
        }

        addANewLine(result,convertedLine);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }



    private void addANewLine(List<String> result,List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
    }

    private void pushACharacterToTheOutput(List<String> convertedLine,String characterToConvert) {
        convertedLine.add(characterToConvert);
    }
}