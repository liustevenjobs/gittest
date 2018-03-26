/**   
* @Title: BaseDictService.java 
* @Package cn.itheima.crm.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午10:15:51 
* @version V1.0   
*/
package cn.itheima.crm.service;

import java.util.List;

import cn.itheima.crm.po.BaseDict;

/** 
 * @ClassName: BaseDictService 
 * @Description: 数据字典service接口
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午10:15:51 
 *  
 */
public interface BaseDictService {
	
	/**
	 * 根据数据字典类型编码进行查询
	 */
	List<BaseDict> queryBaseDictByTypeCode(String typeCode);

}
