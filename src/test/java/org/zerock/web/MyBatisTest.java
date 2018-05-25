package org.zerock.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {
   @Inject
   private SqlSessionFactory sqlFactory;
	 //스프링이 정상작동할 경우 SqlSessionFactory 객체를 자동 주입한다.
   @Test
   public void testFactory() {
      System.out.println(sqlFactory);
   }
   @Test
   public void testSession()throws Exception{
      try(SqlSession session = sqlFactory.openSession()){
         System.out.println(session);
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
}