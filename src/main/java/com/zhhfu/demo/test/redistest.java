package com.zhhfu.demo.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/20 15:10
 * @email ：fuzhihang5@jd.com
 * @description ：redis的测试
 */
public class redistest {
    public static void main(String[] args) {
        Jedis jedis = null;
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        jedis = jedisPool.getResource();
        System.out.println("测试" + jedis.ping());
        System.out.println(jedis.get("hello"));
        System.out.println(jedis.get("k6"));
        jedis.close();
    }
}
