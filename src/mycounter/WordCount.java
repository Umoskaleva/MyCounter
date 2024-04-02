package mycounter;

import java.io.*;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class WordCount {

    private String inFile;
    private String outFile;
    private static String testString = "Hi my program Hi my program Hi my program";
    private Hashtable<String, Integer> words = new Hashtable<String, Integer>();


    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public Hashtable<String, Integer> getWords() {
        return words;
    }

    public void countWords() throws IOException {
        int num = 0;
        Reader reader;
        if (inFile == null) {
            reader = new StringReader(testString);
        } else {
            reader = new FileReader(inFile);
        }
        BufferedReader br = new BufferedReader(reader);
        try {


            for (String line = br.readLine();
                 line != null;
                 line = br.readLine()) {
                StringTokenizer st; // создадим обьект st для разделения строки на отдельные токены (слова) с разделителем пробел
                st = new StringTokenizer(line, " ");
                while (true) {
                    String token = st.nextToken(); // нужно поймать исключение NoSuchElementException
                    if (!words.containsKey(token)) {
                        words.put(token, 1);
                        num++;
                    } else {
                        Object var = words.get(token);
                        int n = (int) var;
                        n++;
                        words.put(token, n);
                    }
                }
            }
        } catch (NoSuchElementException ex){
            System.out.println("Исключение: NoSuchElementException");
        }
        br.close();
    }
}
