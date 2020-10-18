public class Test {
    public static void main(String[] args) {
        Translator translator = new Translator("text.txt", "dictionary.txt");
        translator.readDictionary();
        translator.readFileToTranslate();
        translator.translate();

    }
}
