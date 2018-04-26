package test;

 
import java.util.List;

import springmvc.beans.User;
import springmvc.dao.impl.CommonDaoImpl;
import util.MyUtils;

public class Test {
 
	private static CommonDaoImpl<User> dao=(CommonDaoImpl<User>) MyUtils.getCtx().getBean("commonDao");
	private static String mapper="springmvc.beans.User.@";
	
	public static void getById(int id){
		User u=(User)dao.findById(mapper.replace("@", "getById"), id);
		System.out.println(u.getUsername());
	}
	public static void getByWhere(){
		User u=new User();
		u.setWhere("where id=1");
		u=(User)dao.findByWhere(mapper.replace("@", "getByWhere"), u);
        System.out.println(u.getUsername());
	}
	public static void getByObj(){
		User u=new User();
		u.setId(7);
		u=(User)dao.findByWhere(mapper.replace("@", "getByObj"), u);
        System.out.println(u.getUsername());
	}
	public static void getListByObj(){
		User u=new User();
		List<User>  list=dao.findListByObj(mapper.replace("@", "getByObj"), u);
        System.out.println(list.size());
 	}
	public static void getBySql(){
		User u=new User();
		u.setSql("select * from user where id=1");
		u=(User)dao.findBySql(mapper.replace("@", "getBySql"), u);
        System.out.println(u.getUsername());
	}
	public static void getListBySql(){
		User u=new User();
		u.setSql("select * from user");
		List<User>  list=dao.findListBySql(mapper.replace("@", "getBySql"), u);
        System.out.println(list.get(1).getId());
	}
	public static void getValue(){
		User u=new User();
		u.setSql("select id from user where username='ahutcb@sina.com'");
        Object o=dao.findValueBySql(mapper.replace("@", "findValueBySql"), u);
        System.out.println(o);
	}
	public static void insert(){
		User u=new User();
        u.setUsername("zs");
        u.setPassword("123456");
        dao.insert(mapper.replace("@", "insert"), u,true);
       // dao.commit();// 设置的为true 为什么还要commmit
       System.out.println(u.getId());
	}
	public static void insert2(){
		User u=new User();
        u.setUsername("zs");
        u.setPassword("12345e6");
		MyUtils.getSqlSession(false).insert(mapper.replace("@", "insert"), u);//此处没有commit为什么提交了
		System.out.println(u.getId());
	}
	
	
	public static void deleteByWhere(){
		User u=new User();
		u.setWhere("where password='12345e6'");
		dao.deleteByWhere(mapper.replace("@", "deleteByWhere"), u);
	}
	public static void deleteById(){
		User u=new User();
		u.setId(16);
		dao.deleteByWhere(mapper.replace("@", "deleteById"), u);
	}
	public static void updateByWhere(){
		User u=new User();
		
		u.setWhere("where password='12345e6'");
		u=(User) dao.findByWhere(mapper.replace("@", "getByWhere"), u);
		u.setWhere("where password='12345e6'");
		u.setUsername("432e1");
		dao.deleteByWhere(mapper.replace("@", "updateByWhere"), u);

	}
	public static void updateById(){
		User u=new User();
	    u.setId(10);
		u.setPassword("456");
		dao.deleteByWhere(mapper.replace("@", "updateById"), u);
	}
	
	
	public static void main(String[]args){
		//getById(1);
		//getByWhere();
		//getBySql();
		//getByObj();
		//getListByObj();
		//getListBySql();
		//getValue();

	//	 insert2();
		//deleteByWhere();
		//deleteById();
		//updateById();
		updateByWhere();
	}
}
