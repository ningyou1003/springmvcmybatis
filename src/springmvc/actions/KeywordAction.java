package springmvc.actions;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;
 
import springmvc.beans.Keyword;
import springmvc.beans.User;
import springmvc.service.impl.KeywordServiceImpl;
import springmvc.service.impl.UserServiceImpl;

 
import common.action.BaseAction;

@Controller
@RequestMapping(value="/keyword")
public class KeywordAction extends BaseAction{			
	@Autowired
	private KeywordServiceImpl keywordService;
											//@ModelAttribute("user") User user
											//这样前台页面提交请求并附带user相关参数,会把参数赋值给这个user对象
											//同时这个user对象也可以带回到前台页面
											//页面可以用el表达式来读取
	/*@RequestMapping(value="/login")
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
	    	userService.saveUser(userInfo);
	    }else{ 
	    	userService.edit(userInfo);
	    }
		return "redirect:/user/userlist";	
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
	}*/
	
	//http://localhost:8080/springmvcmybatis/keyword/keywordlist
	@RequestMapping(value="/keywordlist")  
	public ModelAndView keywordlist() throws Exception {
		ModelAndView mv = new ModelAndView("keyword/list");  
		//keywordService.getKeyword();
		mv.addObject("keywordlist", keywordService.getKeyword());
		return mv;
	}
	
	@RequestMapping(value="/editkeyword")  
	public ModelAndView editkeyword(@ModelAttribute("keyword")Keyword keywordInfo )throws Exception { 
		ModelAndView mv = new ModelAndView("keyword/edit");  
	    mv.addObject("keyword", keywordService.getKeywordInfo(keywordInfo)); 
		return mv;
	}
	
	@RequestMapping(value="/savekeyword",method=RequestMethod.POST)  
	public String savekeyword(@ModelAttribute("keyword")Keyword keywordInfo ) throws Exception {  
	    if(keywordInfo.getId()==-1){
	    	keywordService.saveKeyword(keywordInfo);
	    }else{ 
	    	keywordService.edit(keywordInfo);
	    }
		return "redirect:/keyword/keywordlist";	
	}
	
	@RequestMapping(value="/delkeyword",method=RequestMethod.GET)  
	public String delkeyword(@ModelAttribute("keyword")Keyword keywordInfo )throws Exception { 
		keywordService.deletekeyword(keywordInfo);
		return "redirect:/keyword/keywordlist"; 
	}
	
	@RequestMapping(value="/keyslist")  
	public ModelAndView keyslist(@ModelAttribute("keyword")Keyword keywordInfo) throws Exception {
		ModelAndView mv = new ModelAndView("keyword/list"); 
		//keywordService.getKeyword();
		mv.addObject("keywordlist", keywordService.getKeyword());
		return mv;
	}
	
	@RequestMapping(value="/ajaxlist")  
	public ModelAndView ajaxlist(@ModelAttribute("keyword")Keyword keywordInfo) throws Exception {
		ModelAndView mv = new ModelAndView("keyword/list");  
		String keys = keywordInfo.getKeys();
		//keywordService.getKeyword();
		mv.addObject("keywordlist", keywordService.ajaxList(keys));
		return mv;
	}
	
}
