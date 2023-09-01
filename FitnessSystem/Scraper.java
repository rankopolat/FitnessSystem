import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {
  public static void main(String[] args) {
    String url = "https://novelfull.com/godly-empress-doctor/chapter-1779-i-only-have-one-master-4.html";

    // Make a request to the URL and parse the HTML using JSoup
    Document doc = Jsoup.connect(url).get();

    // Find the main content of the chapter using the class "panel-body"
    Element content = doc.selectFirst(".panel-body");

    // Print the content
    System.out.println(content.text());
  }
}
