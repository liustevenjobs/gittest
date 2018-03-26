/**   
* @Title: BaseDictMapper.java 
* @Package cn.itheima.crm.mapper 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午10:09:25 
* @version V1.0   
*/
package cn.itheima.crm.mapper;

import java.util.List;

import cn.itheima.crm.po.BaseDict;

/** 
 * @ClassName: BaseDictMapper 
 * @Description: 数据字典mapper接口 
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午10:09:25 
 *  
 */
public interface BaseDictMapper {

	/**
	 * 根据类型编码进行查询 
	 */
	List<BaseDict> queryBaseDictByTypeCode(String typeCode);
}
