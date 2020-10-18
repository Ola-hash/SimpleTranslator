import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Translator {
    private String path;
    private HashMap<String, String> dictionaryMap;
    private String dictionaryPath;
    private ArrayList<String> words;

    public Translator(String path, String dictionaryPath) {
        this.dictionaryPath = dictionaryPath;
        this.path = path;
        this.dictionaryMap = new HashMap<>();
        this.words = new ArrayList<>();
    }

    public void translate() {
        String result="";
        for (String word :words){
            if (dictionaryMap.containsKey(word)){
                result+=dictionaryMap.get(word)+" ";
            }else {
                result+=word+" ";
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            System.out.println("Sorry, nie mozna zapisac danych do pliku.");
        }

    }

    public void readFileToTranslate() {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                data = data.replaceAll("[\\s]+", " ");
                String[] array = data.split(" ");
                for (String word : array) {
                    words.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        }

    }


    public void readDictionary() {
        try {
            File file = new File(dictionaryPath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] tab = data.split("-");
                dictionaryMap.put(tab[0], tab[1]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku o sciezce " + dictionaryPath);
        }

    }
}
