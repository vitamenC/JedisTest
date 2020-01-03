package JedisTest;

import Util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTestHash {



    public static void main(String[] agrs) {

        JedisPool pool = null;

        try {
            pool = RedisUtils.open("192.168.49.128", 6379);

            Jedis jedis = pool.getResource();

            jedis.flushDB();

            Map<String,String > map = new HashMap<>();
            map.put("id", "1001");
            map.put("name", "wangxiaoming");
            map.put("age", "25");

            jedis.hmset("student", map);

           /* List<String> studentList = jedis.hmget("student", "id", "name", "age");

            for (String s : studentList) {
                System.out.println(s);
            }*/

            Set<String> SKeys = jedis.hkeys("student");

            List<String> SValues = jedis.hvals("student");

        /*for (String key : SKeys) {
                System.out.println(key);
            }*/


            Iterator<String> iterator = SKeys.iterator();

        /*    System.out.println("iterator ---> " + iterator);

            System.out.println("iterator.hasNext() ---> " + iterator.hasNext());*/

         /*   System.out.println("iterator.next() ---> " + iterator.next());
            System.out.println("iterator.next() ---> " + iterator.next());
            System.out.println("iterator.next() ---> " + iterator.next());*/


            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

/*            String next = iterator.next();

            System.out.println("next ---> " + next);*/


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }


    }
}
