/**   
* @Title: BaseDictServiceImpl.java 
* @Package cn.itheima.crm.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午10:16:59 
* @version V1.0   
*/
package cn.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.BaseDictMapper;
import cn.itheima.crm.po.BaseDict;
import cn.itheima.crm.service.BaseDictService;

/** 
 * @ClassName: BaseDictServiceImpl 
 * @Description: 数据字典service实现类
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午10:16:59 
 *  
 */
@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {
	
	// 注入数据字典mapper
	@Autowired
	private BaseDictMapper baseDictMapper;

	/**
	 * 根据数据字典类型编码进行查询
	 */
	public List<BaseDict> queryBaseDictByTypeCode(String typeCode) {
		
		return baseDictMapper.queryBaseDictByTypeCode(typeCode);
	}

}
