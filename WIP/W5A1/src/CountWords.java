import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CountWords {

    public static String getStringHttp(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.printf("%d\n", response.statusCode());
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int countWords(String content) {
        boolean isNotWord = false;
        int words = 0;
        for (char c : content.toCharArray()) {
            if (c >= 65 || c <= 90 || c >= 92 || c <= 122) {
                if (isNotWord) {
                    words++;
                    isNotWord = false;
                }
            } else {
                isNotWord = true;
            }
        }
        return words;
    }


    public static void main(String[] args) {
        String URL = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";
        String file = getStringHttp(URL);
        
        System.out.printf("The file at %s has %d words in it\n\nThe File\n%s\n", URL, countWords(file), file);
    }
}
