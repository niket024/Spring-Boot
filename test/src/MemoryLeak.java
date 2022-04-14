
import java.util.HashMap;
import java.util.Map;

public class MemoryLeak {
	static Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while (true) {
			map.put("abc" + i, "abc" + i);
			Thread.sleep(3000);
			i++;
			System.out.println("abc" + i + " added");
		}
	}
}
