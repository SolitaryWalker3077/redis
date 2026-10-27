import redis.clients.jedis.RedisClient;

import java.util.List;

/**
 * String类型命令:
 * get/set
 * mget/mset
 * getrange/setrange
 * append
 * incr/decr
 * */
public class RedisStringOrder {

    public void mgetAndMset(RedisClient client) {
        System.out.println("mget And mset");
        client.flushAll();
        client.mset("key","111","key2","222" ,"key3","333");
        List<String> values = client.mget("key", "key2", "key3");
        List<String> values_2 = client.mget("key", "key2", "key3","key5");
        System.out.println("values: "+ values);
        System.out.println("values_2:" + values_2);
    }

    public void getrangeAndsetrange(RedisClient client) {
        System.out.println("getrange and setrange");
        client.flushAll();
        client.set("key","abcdefghijk");
        String result = client.getrange("key", 3, 5);
        System.out.println("result :" + result);

        client.setrange("key", 3, "rew");
        String value = client.get("key");
        System.out.println("value :" + value);
    }

    public void append(RedisClient client) {
        System.out.println("append");
        client.flushAll();

        client.set("key","abcdef");
        client.append("key","gifi");

        String value = client.get("key");
        System.out.println("value:" + value);
    }

    public void incrAndDecr(RedisClient client) {
        System.out.println("incr And Decr");
        client.flushAll();

        client.set("key","100");
        long result = client.incr("key");
        System.out.println(result);

        client.set("key2","123");
        long result2 = client.decr("key2");
        System.out.println(result2);

        String value = client.get("key");
        String value2 = client.get("key2");
        System.out.println("value:" + value);
        System.out.println("value2:" + value2);
    }
}
