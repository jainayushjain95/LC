import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Logger {

    private Map<String, Integer> map;
    private Queue<String> queue;

    public Logger() {
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
        logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
        logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
        logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }


    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean shouldPrint = false;
        if(!map.containsKey(message)) {
            map.put(message, timestamp);
            shouldPrint = true;
            queue.add(message);
        } else {
            int currentTimestamp = map.get(message);
            shouldPrint = currentTimestamp + 10 <= timestamp;
            if(shouldPrint) {
                map.put(message, timestamp);
            }
            while(!queue.isEmpty() && map.get(queue.peek()) + 10 < timestamp) {
                map.remove(queue.poll());
            }
        }

//        System.out.println(shouldPrint);

        return shouldPrint;
    }

}
