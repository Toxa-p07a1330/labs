import java.net.URL;
import java.util.*;

public class Parser {


    static Set<URL>urls = new HashSet<>();

    static int maxDepth = 5;
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/");
            getAllLinks(url, 0);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static  void getAllLinks(URL url, int depth)
    {
        try {
            Scanner scanner = new Scanner(url.openStream());
            String html = new String();
            while (scanner.hasNextLine())
                html+=scanner.nextLine();
            String[] links = html.split("</a>");
            for (String i : links) {
                try {
                    String tmp = i.substring(i.indexOf("href") + 6);
                    if (tmp.indexOf("\"") > 0)
                        tmp = tmp.substring(0, tmp.indexOf("\""));
                    URL addMe = new URL(tmp);
                    if (!urls.contains(addMe)){
                    urls.add(addMe);
                    if (depth < maxDepth)
                        getAllLinks(addMe, depth + 1);
                    System.out.println(tmp);
                    }
                }
                catch (Exception e){}
            };
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    };
}
