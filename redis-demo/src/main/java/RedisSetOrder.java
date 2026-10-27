import redis.clients.jedis.RedisClient;

import java.util.Set;

public class RedisSetOrder {

    public void saddAndSmembers(RedisClient client) {
        System.out.println("sadd 和 smembers");
        client.flushAll();

        client.sadd("key", "111", "222", "333");
        Set<String> result = client.smembers("key");
        System.out.println("result: " + result);
    }

    public void sismember(RedisClient client) {
        System.out.println("sismember");
        client.flushAll();

        client.sadd("key", "111", "222", "333");
        boolean result = client.sismember("key", "100");
        System.out.println("result: " + result);
    }

    public void scard(RedisClient client) {
        System.out.println("scard");
        client.flushAll();

        client.sadd("key", "111", "222", "333");
        long result = client.scard("key");
        System.out.println("result: " + result);
    }

    public void spop(RedisClient client) {
        System.out.println("spop");
        client.flushAll();

        client.sadd("key", "111", "222", "333", "444", "555");
        String result = client.spop("key");
        System.out.println("result: " + result);
    }

    public void sinter(RedisClient client) {
        System.out.println("sinter");
        client.flushAll();

        client.sadd("key", "111", "222", "333");
        client.sadd("key2", "111", "222", "444");

        Set<String> result = client.sinter("key", "key2");
        System.out.println("result: " + result);
    }

    public void sinterstore(RedisClient client) {
        System.out.println("sinterstore");
        client.flushAll();

        client.sadd("key", "111", "222", "333");
        client.sadd("key2", "111", "222", "444");

        long len = client.sinterstore("key3", "key", "key2");
        System.out.println("len: " + len);

        Set<String> result = client.smembers("key3");
        System.out.println("result: " + result);
    }

}
