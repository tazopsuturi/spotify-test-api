import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ReadResponse {
	public static String readResponse(HttpURLConnection conn) throws IOException {
		StringBuilder response = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			String line;
			while ((line = in.readLine()) != null) {
				response.append(line);
			}
		}
		return response.toString();
	}
}
