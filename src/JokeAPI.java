import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;

public class JokeAPI {

    public static void getRandomJoke() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://joke3.p.rapidapi.com/v1/joke"))
                    .header("x-rapidapi-key", "215e93c85bmsha8b295833c8ae3ap1f7750jsnf22ef2e3d45d")
                    .header("x-rapidapi-host", "joke3.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //Parse that object into a usable Java JSON object.
            JSONObject obj = new JSONObject(response.body());

            //Print out the Mage card name.
            String theJoke = obj.getString("content");
            System.out.println("\nA random Joke: " + theJoke);


        } catch ( Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
