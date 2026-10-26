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

    static RedisOrder redisOrder = new RedisOrder();

    public static void main(String[] args) {
        ConnectionPoolConfig poolConfig = new ConnectionPoolConfig();
        poolConfig.setMaxTotal(8); // 最大连接数
        poolConfig.setMaxIdle(8);  // 最大空闲连接数
        poolConfig.setMinIdle(0);  // 最小空闲连接数

        try(RedisClient client = RedisClient.builder()
                .hostAndPort("localhost",8888)
                .poolConfig(poolConfig).build()) {
            //redisOrder.setAndGetTest(client);
            //redisOrder.existsAndDel(client);
            redisOrder.keys(client);
        }
    }
}