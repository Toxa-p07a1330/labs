import java.net.URL;
import java.util.*;

public class Parser {

    class LinkWithDepth{
        private URL link;
        private int depth;

        public int getDepth() {
            return depth;
        }

        public URL getLink() {
            return link;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public void setLink(URL link) {
            this.link = link;
        }
        LinkWithDepth(URL url, int depth)
        {
            this.depth = depth;
            this.link = url;
        }
    }


     Set<LinkWithDepth>urls = new HashSet<>();

    static int maxDepth = 5;


    void getAllLinks(URL url, int depth)
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
                    LinkWithDepth addMe = new LinkWithDepth(new URL(tmp),depth);
                    if (!urls.contains(addMe)){
                    urls.add(addMe);
                    if (depth < maxDepth)
                    {
                        (new Thread(new crewkerClass())).start();

                    }
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

class  crewkerClass implements Runnable{
    @Override
    public void run()
    {

    }
}