package JedisTest;

import Util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Unit test for simple App.
 */
public class AppTest02 {



    public static void main(String[] agrs) {

        JedisPool pool = null;

        try {
            pool = RedisUtils.open("192.168.49.128", 6379);

            Jedis jedis = pool.getResource();

            jedis.flushDB();

            jedis.set("str01", "one more time");

            String s = jedis.get("str01");

            System.out.println(s);

            jedis.append("str01", " /n test ");

            String str01 = jedis.get("str01");

            System.out.println(str01);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }


    }
}
