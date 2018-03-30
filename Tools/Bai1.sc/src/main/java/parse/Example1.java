package parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example1 {
	private static final Logger logger = LoggerFactory.getLogger(Example1.class);

	public static int Parse() {
		String url = "http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn";
		try {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// System.out.println(response.toString());
			JSONObject obj_JSONObject = new JSONObject(response.toString());
			// System.out.println(obj_JSONObject.get("user"));
			///JSONArray obj_JSONArray = obj_JSONObject.getJSONArray("source");
			// System.out.println(obj_JSONArray);
			//return obj_JSONArray.length(); // field user
			int a = (Integer) obj_JSONObject.get("user");
			return a;

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

		Runnable task = () -> {
			int userCuoi = -1;
			int counttime = 0;
			while (true) {
				int x = Parse(); // get user
				// System.out.println(x+"-----------");
				counttime += 2;
				if (x > (userCuoi * 1.03) || userCuoi == -1) {
					userCuoi = x;
					logger.info("So user = " + userCuoi);
					counttime = 0;
				} else {
					System.out.println(userCuoi);
					if (counttime == 12) {
						logger.debug("So user = " + userCuoi);
						counttime = 0;
					}
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		};

		new Thread(task).start();
	}

}
