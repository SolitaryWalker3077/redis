import redis.clients.jedis.RedisClient;

import java.util.List;

public class RedisListOrder {

    public void lpushAndLrange(RedisClient client) {
        System.out.println("lpush 和 lrange");
        client.flushAll();

        client.lpush("key", "111", "222", "333");

        List<String> result = client.lrange("key", 0, -1);
        System.out.println(result);
    }

    public void rpush(RedisClient client) {
        System.out.println("rpush");
        client.flushAll();

        client.rpush("key", "111", "222", "333");

        List<String> result = client.lrange("key", 0, -1);
        System.out.println("result: " + result);
    }

    public void lpop(RedisClient client) {
        System.out.println("lpop");
        client.flushAll();

        client.rpush("key", "111", "222", "333");
        String result = client.lpop("key");
        System.out.println("result: " + result);

        result = client.lpop("key");
        System.out.println("result: " + result);

        result = client.lpop("key");
        System.out.println("result: " + result);

        result = client.lpop("key");
        System.out.println("result: " + result);
    }

    public void rpop(RedisClient client) {
        System.out.println("rpop");
        client.flushAll();

        client.rpush("key", "111", "222", "333");
        String result = client.rpop("key");
        System.out.println("result: " + result);
        result = client.rpop("key");
        System.out.println("result: " + result);
        result = client.rpop("key");
        System.out.println("result: " + result);
        result = client.rpop("key");
        System.out.println("result: " + result);
    }

    public void blpop(RedisClient client) {
        System.out.println("blpop");
        client.flushAll();

        // 返回结果是一个 "二元组", 一个是从哪个 key 对应的list中删除的, 一个是删除的元素是什么.
        List<String> results = client.blpop(100, "key");
        System.out.println("results[0]: " + results.get(0));
        System.out.println("results[1]: " + results.get(1));
    }

    public void llen(RedisClient client) {
        System.out.println("llen");
        client.flushAll();

        client.rpush("key", "111", "222", "333");
        long len = client.llen("key");
        System.out.println("len: " + len);
    }

}
