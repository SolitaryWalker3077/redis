import redis.clients.jedis.RedisClient;
import redis.clients.jedis.resps.Tuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisZSetOrder {
    public void zaddAndZrange(RedisClient client) {
        System.out.println("zadd 和 zrange");
        client.flushAll();

        client.zadd("key", 10, "zhangsan");
        Map<String, Double> map = new HashMap<>();
        map.put("lisi", 20.0);
        map.put("wangwu", 30.0);
        client.zadd("key", map);

        List<String> members = client.zrange("key", 0, -1);
        System.out.println("members: " + members);

        List<Tuple> membersWithScore = client.zrangeWithScores("key", 0, -1);
        System.out.println("membersWithScore: " + membersWithScore);
        String member = membersWithScore.get(0).getElement();
        double score = membersWithScore.get(0).getScore();
        System.out.println("member: " + member + ", score: " + score);
    }

    public void zcard(RedisClient client) {
        System.out.println("zcard");
        client.flushAll();

        client.zadd("key", 10, "zhangsan");
        client.zadd("key", 20, "lisi");
        client.zadd("key", 30, "wangwu");

        long len = client.zcard("key");
        System.out.println("len: " + len);
    }

    public void zrem(RedisClient client) {
        System.out.println("zrem");
        client.flushAll();

        client.zadd("key", 10, "zhangsan");
        client.zadd("key", 20, "lisi");
        client.zadd("key", 30, "wangwu");

        long n = client.zrem("key", "zhangsan", "lisi");
        System.out.println("n: " + n);

        List<Tuple> result = client.zrangeWithScores("key", 0, -1);
        System.out.println("result: " + result);
    }

    public void zscore(RedisClient client) {
        System.out.println("zscore");
        client.flushAll();

        client.zadd("key", 10, "zhangsan");
        client.zadd("key", 20, "lisi");
        client.zadd("key", 30, "wangwu");

        Double score = client.zscore("key", "zhangsan2");
        System.out.println("score: " + score);
    }

    public void zrank(RedisClient client) {
        System.out.println("zrank");
        client.flushAll();

        client.zadd("key", 10, "zhangsan");
        client.zadd("key", 20, "lisi");
        client.zadd("key", 30, "wangwu");

        Long rank = client.zrank("key", "zhangsan2");
        System.out.println("rank: " + rank);
    }
}
