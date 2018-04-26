package springmvc.actions;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import springmvc.beans.User;
import springmvc.service.impl.UserServiceImpl;

 
import common.action.BaseAction;

@Controller
@RequestMapping(value="/user")
public class UserAction extends BaseAction{			
	@Autowired
	private UserServiceImpl userService;
											//@ModelAttribute("user") User user
											//这样前台页面提交请求并附带user相关参数,会把参数赋值给这个user对象
											//同时这个user对象也可以带回到前台页面
											//页面可以用el表达式来读取
	@RequestMapping(value="/login")
	public ModelAndView login(@ModelAttribute("user")User user){
		ModelAndView mv = new ModelAndView("user/success");  //配合spring配置中的jsp页面解析器，确定哪个目录，去user文件夹下找success.jsp的视图
																//引用名称为“user/success”的视图
								//springMVC,把JSP放入JSP文件夹下，所有的view都通过spring进行转发，一般controller执行完毕后会返回return new ModelAndView("example")；那么spring就根据你的配置，去JSP文件夹下找example.jsp的视图
	    user = userService.login(user);
	    if(user==null) {
	    	mv.addObject("op", "登陆失败!");
	   }else{
		   mv.addObject("op", "登陆成功!");
	   }
	    return mv;
	}
	@RequestMapping(value="/userlist")  
	public ModelAndView getUser() throws Exception {
		ModelAndView mv = new ModelAndView("user/list");  
	    mv.addObject("userlist", userService.getUsers()); 
		return mv;
	}
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)  
	public String saveUser(@ModelAttribute("user")User userInfo ) throws Exception {  
	    if(userInfo.getId()==-1){
	    	userService.saveUser(userInfo);//新增
	    }else{ 
	    	userService.edit(userInfo);//更新
	    }
		return "redirect:/user/userlist";//重定向到/user/userlist接口	
	}
	@RequestMapping(value="/edituser")  
	public ModelAndView editUser(@ModelAttribute("user")User userInfo )throws Exception { 
		ModelAndView mv = new ModelAndView("user/edit");  
	    mv.addObject("users", userService.getUserInfo(userInfo)); 
		return mv;
	}
	@RequestMapping(value="/deluser",method=RequestMethod.GET)  
	public String deleteUser(@ModelAttribute("user")User userInfo )throws Exception { 
 		userService.deleteUser(userInfo);
		return "redirect:/user/userlist"; 
	}
}
