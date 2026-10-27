import redis.clients.jedis.RedisClient;

import java.util.Set;

//通用命令
public class RedisGenericOrder {


    public void setAndGetTest(RedisClient client) {
        System.out.println("set and get");
        client.flushAll();
        client.set("key","1111");
        System.out.println(client.get("key"));
    }

    public void existsAndDel(RedisClient client) {
        client.flushAll();
        System.out.println("exists and del");

        client.set("key","111");
        client.set("key2","222");
        client.set("key3","333");
        System.out.println(client.keys("*"));

        boolean exists = client.exists("key");
        System.out.println(exists);
        long key2 = client.del("key2");
        System.out.println(key2);
        System.out.println(client.keys("*"));
    }

    public void keys(RedisClient client) {
        client.flushAll();
        System.out.println("keys");

        client.set("key","111");
        client.set("key2","222");
        client.set("key3","333");

        //redis当中的key不能重复,而且不在意顺序
        Set<String> keys = client.keys("*");
        System.out.println(keys);
    }

    public void expireAndTtlAndType(RedisClient client) {
        client.flushAll();
        System.out.println("expire and ttl and type");
        client.set("key","111");
        client.expire("key", 60);
        long time = client.ttl("key");
        String type = client.type("key");
        System.out.println("time :"+ time);
        System.out.println("type :" +type);
    }

}
