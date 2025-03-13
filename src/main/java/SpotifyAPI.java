import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import org.json.*;

public class SpotifyAPI {
	
	private static final String CLIENT_ID = System.getenv("SPOTIFY_CLIENT_ID");
	private static final String CLIENT_SECRET = System.getenv("SPOTIFY_CLIENT_SECRET");
	
	public static void main(String[] args) throws Exception {
		String token = getAccessToken();
		String artistId = ArtistID.getArtistID("Eminem", token);
		TopTracks.getTopTracks(artistId, token);
		System.out.println(token);
	}
	
	private static String getAccessToken() throws IOException {
		String auth = CLIENT_ID + ":" + CLIENT_SECRET;
		String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
		
		URL url = new URL("https://accounts.spotify.com/api/token");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true);
		
		try (OutputStream os = conn.getOutputStream()) {
			os.write("grant_type=client_credentials".getBytes());
		}
		
		String response = conn.getResponseMessage();
		JSONObject json = new JSONObject(response);
		return json.getString("access_token");
	}
}
