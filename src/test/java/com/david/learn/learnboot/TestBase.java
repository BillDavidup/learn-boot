package com.david.learn.learnboot;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wudening
 * @Description: 启动Spring容器的测试父类
 * @Date: 2020/12/5 下午5:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnBootApplication.class)
public class TestBase {
}

