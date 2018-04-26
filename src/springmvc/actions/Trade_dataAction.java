package springmvc.actions;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import springmvc.beans.Trade_data;
import springmvc.service.impl.Trade_dataServiceImpl;

 
import common.action.BaseAction;

@Controller
@RequestMapping(value="/trade_data")
public class Trade_dataAction extends BaseAction{			
	@Autowired
	private Trade_dataServiceImpl trade_dataService;
											//@ModelAttribute("trade_data") Trade_data trade_data
											//这样前台页面提交请求并附带trade_data相关参数,会把参数赋值给这个trade_data对象
											//同时这个trade_data对象也可以带回到前台页面
											//页面可以用el表达式来读取
	
	/**
	 * 查询
	 * @return ModelAndView("trade_data/list");  el:{trade_datalist}
	 * @throws Exception
	 */
	@RequestMapping(value="/trade_datalist")  
	public ModelAndView getTrade_data() throws Exception {
		ModelAndView mv = new ModelAndView("trade_data/list");  
	    mv.addObject("trade_datalist", trade_dataService.list()); 
		return mv;
	}
	
	/**
	 * 更新
	 * @param trade_dataInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/edittrade_data")  
	public ModelAndView editTrade_data(@ModelAttribute("trade_data")Trade_data trade_dataInfo )throws Exception { 
		ModelAndView mv = new ModelAndView("trade_data/edit");  
	    mv.addObject("trade_data", trade_dataService.edit(trade_dataInfo)); 
		return mv;
	}
	
	/**
	 * 删除
	 * @param trade_dataInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deltrade_data",method=RequestMethod.GET)  
	public String deleteTrade_data(@ModelAttribute("trade_data")Trade_data trade_dataInfo )throws Exception { 
 		trade_dataService.delete(trade_dataInfo);
		return "redirect:/trade_data/trade_datalist"; 
	}
	
	/**
	 * 保存新增和更新
	 * @param trade_dataInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savetrade_data",method=RequestMethod.POST)  
	public String saveTrade_data(@ModelAttribute("trade_data")Trade_data trade_dataInfo ) throws Exception {  
	    if(trade_dataInfo.getId()==-1){
	    	trade_dataService.save(trade_dataInfo);//新增
	    }else{ 
	    	trade_dataService.edit(trade_dataInfo);//更新
	    }
		return "redirect:/trade_data/trade_datalist";//重定向到/trade_data/trade_datalist接口	
	}
}
