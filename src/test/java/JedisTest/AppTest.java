package JedisTest;

import redis.clients.jedis.Jedis;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] agrs) {

        Jedis jedis = new Jedis("192.168.49.128", 6379);

        jedis.flushDB();

        jedis.set("test01", "one");

        String test01 = jedis.get("test01");

        System.out.println(test01);

        jedis.append("test01", "aaa");

        String str = jedis.get("test01");

        System.out.println(str);


    }
}
