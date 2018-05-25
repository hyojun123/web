package org.zerock.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	//@Inject애너테이션은 스프링이 DataSource 객체를 생성해서 주입하도록 한다.
	//앞에서 배운 @Autowired 와 비슷한 느낌인거 같다.
   @Inject
   private DataSource ds;
	 //@Test 단위테스트를 위한 에너테이션이다.
   @Test
   public void testConnection()throws Exception{      
      try(Connection con = ds.getConnection()){
         System.out.println(con);
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
}