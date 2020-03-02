package com.work.groundui.controller;

import com.work.groundui.model.User;
import com.work.groundui.redisclient.RedisClient;
import com.work.groundui.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.Map;

/**
 * Program Name: Ground
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjw
 * @version 1.0
 * @date 2020/3/2 12:46 下午
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoMainController {
    @Autowired
    private RedisClient redisClient;


    @GetMapping("test1")

    public Object test1() {
        return "success";
    }

    @GetMapping("test/redis/get")
    public Object testRedis() {
        redisClient.set("key1","v1-ming1");
        String name = redisClient.get("key1");
        System.out.println(name);
        return name;
    }

    @GetMapping("test/redis/mget")
    public Object testRedis2() {
        User user = new User();
        user.setName("ming2");
        user.setAge(12);
        redisClient.hsetAll("user:1", JsonUtil.jsonToMap(JsonUtil.beanToJson(user)));
        String name = (String) redisClient.hget("user:1", "name");
        Map map = redisClient.hgetAll("user:1");
        System.out.println(name);
        return map;
    }
}
