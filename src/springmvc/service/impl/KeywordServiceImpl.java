package springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.service.BaseService;

import springmvc.beans.Keyword;
import springmvc.beans.User;
import springmvc.dao.CommonDao;
import springmvc.service.UserService;

@Service("keywordService")
public class KeywordServiceImpl extends BaseService implements UserService{
	@Autowired
	private CommonDao commonDao;
	private final String mapper="springmvc.beans.Keyword.@";//UserMapper.xml中的idspringmvc.beans.User
	
	public Keyword edit(Keyword keyword){
		commonDao.updateByWhere(mapper.replace("@", "updateById"), keyword);
		return keyword;
	}
	public List getKeyword(){
		Keyword k = new Keyword();
		k.setSql("select * from keyword");				//springmvc.beans.Keyword
		String s = mapper.replace("@", "findListBySql");//springmvc.beans.Keyword.findListBySql
		List list=commonDao.findListBySql(mapper.replace("@", "findListBySql"), k);
		return list;
	}
	
	
	public List ajaxList(String keys){
		Keyword k = new Keyword();
		if(!(keys==null)||!(keys.trim()=="")){
			k.setSql("select * from keyword where `keys` like '%"+keys+"%'");
		}else{
			k.setSql("select * from keyword");
		}
		//String s = mapper.replace("@", "findListBySql");//springmvc.beans.Keyword.findListBySql
		List list=commonDao.findListBySql(mapper.replace("@", "findListBySql"), k);
		return list;
	}
	public List ajaxList(){
		Keyword k = new Keyword();
			k.setSql("select * from keyword where `keys` like '%a%'");
		//String s = mapper.replace("@", "findListBySql");//springmvc.beans.Keyword.findListBySql
		List list=commonDao.findListBySql(mapper.replace("@", "findListBySql"), k);
		return list;
	}
	public Keyword getKeywordInfo(Keyword keywordInfo){
	  return (Keyword) commonDao.findById(mapper.replace("@", "getById"), keywordInfo);
	}
	public void deletekeyword(Keyword keyword){
		 commonDao.findById(mapper.replace("@", "deleteById"), keyword);
	}
	public void saveKeyword(Keyword keyword){
		 commonDao.findById(mapper.replace("@", "insert"), keyword);
		 
	}
}
