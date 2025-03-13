import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TopTracks {
	public static void getTopTracks(String artistId, String token) throws IOException {
		URL url = new URL("https://api.spotify.com/v1/artists/" + artistId + "/top-tracks?market=US");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer " + token);
		
		String response = ReadResponse.readResponse(conn);
		JSONObject jsonObject = new JSONObject(response);
		
		for (Object track : jsonObject.getJSONArray("tracks")) {
			JSONObject trackObject = (JSONObject) track;
			System.out.println(trackObject.getString("name"));
		}
	}
}
