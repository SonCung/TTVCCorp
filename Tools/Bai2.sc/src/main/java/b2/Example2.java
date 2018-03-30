package b2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Example2 {
	public static void Buffer(String s) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
		Date date = new Date();
		String stringDate = dateFormat.format(date);
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("C:/Users/Son Cung/Desktop/"+stringDate+".txt"));
				//new FileWriter("/home/soncung/Downloads/"+stringDate+".txt"));
		writer.write(s);
		writer.newLine();
		writer.close();

	}

	public static void main(String[] args) throws IOException {
		String url = "http://dantri.com.vn/";
		Document document = Jsoup.connect(url).get();
		// Buffer(document.text());
		Buffer(document.toString());
		System.out.println("Done");
	}
}