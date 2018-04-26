package util;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

 public class MyUtils {
	static
	{
		//在类路径下寻找spring-context.xml文件
		ctx = new ClassPathXmlApplicationContext("spring-context.xml");
	}
	
	private static  ApplicationContext ctx;
	private static  SqlSessionFactory sqlSessionFactory;
	private  static SqlSessionFactory getSqlSessionFactory() {
  		 if(sqlSessionFactory==null)
			 sqlSessionFactory=(SqlSessionFactory) getCtx().getBean("sqlSessionFactory");
		 return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession(boolean b){
 		return getSqlSessionFactory().openSession(b);
	}
	public static ApplicationContext getCtx(){
		return ctx;
	}
	public static void main(String[]agrs){
	 
	}
	
}
