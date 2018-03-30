package b4;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.LoadingCache;

public class Demo {

	public static void main(String[] args) {
		Demo prime = new Demo();
		// System.out.println(prime.getPrimeUseGuava(5));
		get("/hello/:n", (req, res) -> {
			int id = Integer.parseInt(req.params(":n"));
			return prime.getPrimeUseGuava(id);
		});

	}

	private ArrayList<Integer> getPrimeUseGuava(int i) throws ExecutionException {
		LoadingCache<Integer, ArrayList<Integer>> primecache = GuavaCache.getLoadingCache();
		System.out.println("size cache: " + primecache.size());
		return primecache.get(i);
	}

}
