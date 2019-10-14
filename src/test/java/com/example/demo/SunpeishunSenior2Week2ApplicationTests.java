package com.example.demo;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.bean.Goods;
import com.tzh.utils.IOToFileUtils;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SunpeishunSenior2Week2ApplicationTests {

	//注入RedisTemplate进行使用RedisTemplate对象进行添加
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void contextLoads() {
	}
	
	//测试进行添加读取文件
	@Test
	public void ListGoods() {	
		List<String> readFileByLinesList = IOToFileUtils.readFileByLinesList(System.getProperty("user.dir")+"/src/test/java/a.txt");
		//读取文件
		for (String string : readFileByLinesList) {
			System.out.println(string);
			//创建goods对象
			Goods goods = new Goods();
			String[] split = string.split("\\==");
			goods.setGid(Integer.parseInt(split[0]));
			goods.setGname(split[1]);
			goods.setPrice(Double.parseDouble(split[2]));
			goods.setBfb(Integer.parseInt(split[3]));
			
			ListOperations<String, Object> opsForList = redisTemplate.opsForList();
			Long leftPushAll = opsForList.leftPushAll(string,goods);
			System.out.println(leftPushAll);
		}
	}
}