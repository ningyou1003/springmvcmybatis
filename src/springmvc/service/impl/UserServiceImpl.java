package springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.service.BaseService;

import springmvc.beans.User;
import springmvc.dao.CommonDao;
import springmvc.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService{
	@Autowired
	private CommonDao commonDao;
	private final String mapper="springmvc.beans.User.@";//UserMapper.xml中的idspringmvc.beans.User
	public User login(User user){
 		 String where="where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		 user.setWhere(where);
		 user=(User)commonDao.findByWhere(mapper.replace("@", "getByWhere"), user);
	  	 return user;
	}
	public User regist(User user){
		 User u=new User();
		 u.setPassword(user.getPassword());
		 u.setUsername(user.getUsername());
		 String where="where username='"+user.getUsername()+"'";
		 user.setWhere(where);
		 user=(User)commonDao.findByWhere(mapper.replace("@", "getByWhere"), user);
		 if(user==null)//不存在
			 commonDao.insert(mapper.replace("@", "insert"),u);
		return user;//用户名已经存在
	}
	public User edit(User user){
		commonDao.updateByWhere(mapper.replace("@", "updateById"), user);
		return user;
	}
	public List getUsers(){
		User u=new User();
		u.setSql("select * from user");
		List list=commonDao.findListBySql(mapper.replace("@", "findListBySql"), u);//springmvc.beans.User.findListBySql
		return list;
	}
	public User getUserInfo(User user){
	  return (User) commonDao.findById(mapper.replace("@", "getById"), user);
	}
	public void deleteUser(User user){
		 commonDao.findById(mapper.replace("@", "deleteById"), user);
	}
	public void saveUser(User user){
		 commonDao.findById(mapper.replace("@", "insert"), user);
		 
	}
}
