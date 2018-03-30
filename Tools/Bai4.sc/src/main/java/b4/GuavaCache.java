package b4;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCache {
	private static LoadingCache<Integer, ArrayList<Integer>> Cache;
	static {
		Cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(10, TimeUnit.SECONDS)
				.build(new CacheLoader<Integer, ArrayList<Integer>>() {
					@Override
					public ArrayList<Integer> load(Integer i) throws Exception {
						return getList(i);
					}
				});
	}
	public static ArrayList<Integer> getList(int n){
		return Show(n);
	}
	
	public static LoadingCache<Integer, ArrayList<Integer>> getLoadingCache() {
		return Cache;
	}
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
		ArrayList <Integer> prime = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (CheckNT(i)) {
				prime.add(i);
			}
		}
		return prime;
	}
}
