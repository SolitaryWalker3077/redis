import redis.clients.jedis.RedisClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisHashOrder {

    public void hsetAndHget(RedisClient client) {
        System.out.println("hset 和 hget");
        client.flushAll();

        client.hset("key", "f1", "111");
        Map<String, String> fields = new HashMap<>();
        fields.put("f2", "222");
        fields.put("f3", "333");
        client.hset("key", fields);

        String result = client.hget("key", "f1");
        System.out.println("result: " + result);

        result = client.hget("key", "f2");
        System.out.println("result: " + result);

        result = client.hget("key", "f100");
        System.out.println("result: " + result);
    }

    public void hexists(RedisClient client) {
        System.out.println("hexists");
        client.flushAll();

        client.hset("key", "f1", "111");
        client.hset("key", "f2", "111");
        client.hset("key", "f3", "111");

        boolean result = client.hexists("key", "f1");
        System.out.println("result: " + result);

        result = client.hexists("key", "f100");
        System.out.println("result: " + result);
    }

    public void hdel(RedisClient client) {
        System.out.println("hdel");
        client.flushAll();

        client.hset("key", "f1", "111");
        client.hset("key", "f2", "111");
        client.hset("key", "f3", "111");

        long result = client.hdel("key", "f1", "f2");
        System.out.println("result: " + result);

        boolean exists = client.hexists("key", "f1");
        System.out.println("exists: " + exists);
        exists = client.hexists("key", "f2");
        System.out.println("exists: " + exists);
    }

    public void hkeysAndHvals(RedisClient client) {
        System.out.println("hkeys 和 hvals");
        client.flushAll();

        client.hset("key", "f1", "111");
        client.hset("key", "f2", "111");
        client.hset("key", "f3", "111");

        Set<String> fields = client.hkeys("key");
        List<String> vals = client.hvals("key");
        System.out.println("fields: " + fields);
        System.out.println("vals: " + vals);
    }

    public void hmgetAndHmset(RedisClient client) {
        System.out.println("hmget 和 hmset");
        client.flushAll();

        Map<String, String> map = new HashMap<>();
        map.put("f1", "111");
        map.put("f2", "222");
        map.put("f3", "333");
        client.hmset("key", map);

        List<String> values = client.hmget("key", "f2", "f1", "f3");
        System.out.println("values: " + values);
    }
}
