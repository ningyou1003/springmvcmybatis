package springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.service.BaseService;

import springmvc.beans.Trade_data;
import springmvc.dao.CommonDao;
import springmvc.service.Trade_dataService;

@Service("trade_dataService")
public class Trade_dataServiceImpl extends BaseService implements Trade_dataService{
	@Autowired
	private CommonDao commonDao;
	private final String mapper="springmvc.beans.Trade_data.@";//Trade_dataMapper.xml中的idspringmvc.beans.Trade_data
	
	
	public List list(){
		Trade_data u=new Trade_data();
		u.setSql("select * from trade_data");
		List list=commonDao.findListBySql(mapper.replace("@", "findListBySql"), u);//springmvc.beans.Trade_data.findListBySql
		return list;
	}
	
	public Trade_data listById(Trade_data trade_data){
	  return (Trade_data) commonDao.findById(mapper.replace("@", "getById"), trade_data);
	}
	
	public Trade_data edit(Trade_data trade_data){
		commonDao.updateByWhere(mapper.replace("@", "updateById"), trade_data);
		return trade_data;
	}
	
	public void delete(Trade_data trade_data){
		 commonDao.findById(mapper.replace("@", "deleteById"), trade_data);
	}
	public void save(Trade_data trade_data){
		 commonDao.findById(mapper.replace("@", "insert"), trade_data);
		 
	}
}
