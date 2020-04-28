import java.net.URL;

public class Tester {
    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            URL url = new URL("https://www.google.com/");
            parser.getAllLinks(url, 0);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
