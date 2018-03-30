import static spark.Spark.*;

import java.util.ArrayList;

public class Example3 {
	static boolean CheckNT(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static ArrayList<Integer> Show(int n) {
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (CheckNT(i)) {
				a.add(i);
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		get("/hello/:n", (req, res) -> {
			int id = Integer.parseInt(req.params(":n"));
			return Show(id);
		});

	}

}
