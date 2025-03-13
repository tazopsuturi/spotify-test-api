import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ArtistID {
	
	public static String getArtistID(String artistName, String token) throws IOException {
		String query = artistName.replace(" ", "%20");
		URL url = new URL("https://api.spotify.com/v1/search?q=" + query + "&type=artist");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer " + token);
		
		String response = ReadResponse.readResponse(conn);
		JSONObject jsonObject = new JSONObject(response);
		return jsonObject.getJSONObject("artists").getJSONArray("items").getJSONObject(0).getString("id");
		
	}
}
