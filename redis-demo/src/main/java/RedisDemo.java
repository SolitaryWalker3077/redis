import redis.clients.jedis.*;

public class RedisDemo {


    public static void main1(String[] args) {
        //1.连接Redis服务器
        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:8888");

        //2.从连接池中获取一个Jedis连接
        try (Jedis jedis = jedisPool.getResource()) {
            //注Redis的各种命令,就对应到jedis对象的各种方法

            //3.密码验证（若Redis设置了requirepass密码，取消注释下面一行）
            //jedis.auth("yourpassword");

            //4.读写数据
            jedis.set("name", "redis-demo");
            System.out.println("读取到的值: " + jedis.get("name"));

            //5.操作一个键值对是否存在
            System.out.println("键是否存在: " + jedis.exists("name"));

            //6.设置键的过期时间（单位：秒）
            jedis.expire("name", 60);
            System.out.println("剩余生存时间: " + jedis.ttl("name") + " 秒");
        }

        //7.关闭连接池
        jedisPool.close();

        System.out.println("连接并操作Redis完成!");
    }

    static RedisGenericOrder redisGenericOrder = new RedisGenericOrder();
    static RedisStringOrder redisStringOrder = new RedisStringOrder();
    static RedisListOrder redisListOrder = new RedisListOrder();
    static RedisSetOrder redisSetOrder = new RedisSetOrder();
    static RedisHashOrder redisHashOrder = new RedisHashOrder();
    static RedisZSetOrder redisZSetOrder = new RedisZSetOrder();

    public static void main(String[] args) {
        ConnectionPoolConfig poolConfig = new ConnectionPoolConfig();
        poolConfig.setMaxTotal(8); // 最大连接数
        poolConfig.setMaxIdle(8);  // 最大空闲连接数
        poolConfig.setMinIdle(0);  // 最小空闲连接数

        try (RedisClient client = RedisClient.builder()
                .hostAndPort("localhost", 8888)
                .poolConfig(poolConfig).build()) {
//            redisGenericOrder.setAndGetTest(client);
//            redisGenericOrder.existsAndDel(client);
//            redisGenericOrder.keys(client);
//            redisGenericOrder.expireAndTtlAndType(client);
//
//            redisStringOrder.mgetAndMset(client);
//            redisStringOrder.getrangeAndsetrange(client);
//            redisStringOrder.append(client);
//            redisStringOrder.incrAndDecr(client);

//            redisListOrder.lpushAndLrange(client);
//            redisListOrder.rpush(client);
//            redisListOrder.lpop(client);
//            redisListOrder.rpop(client);
//            redisListOrder.blpop(client);
//            redisListOrder.llen(client);

//            redisSetOrder.saddAndSmembers(client);
//            redisSetOrder.sismember(client);
//            redisSetOrder.scard(client);
//            redisSetOrder.spop(client);
//            redisSetOrder.sinter(client);
//            redisSetOrder.sinterstore(client);

//            redisHashOrder.hsetAndHget(client);
//            redisHashOrder.hexists(client);
//            redisHashOrder.hdel(client);
//            redisHashOrder.hkeysAndHvals(client);
//            redisHashOrder.hmgetAndHmset(client);

//            redisZSetOrder.zaddAndZrange(client);
//            redisZSetOrder.zcard(client);
//            redisZSetOrder.zrem(client);
//            redisZSetOrder.zscore(client);
//            redisZSetOrder.zrank(client);
        }
    }
}