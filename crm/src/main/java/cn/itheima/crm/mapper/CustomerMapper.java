/**   
* @Title: CustomerMapper.java 
* @Package cn.itheima.crm.mapper 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午10:42:08 
* @version V1.0   
*/
package cn.itheima.crm.mapper;

import java.util.List;

import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;

/** 
 * @ClassName: CustomerMapper 
 * @Description: 客户mapper接口 
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午10:42:08 
 *  
 */
public interface CustomerMapper {
	
	/**
	 * 1.查询当前的列表数据
	 */
	List<Customer> queryCustomerList(QueryVo queryVo);
	
	/**
	 * 2.统计满足条件的记录数 
	 */
	Integer countCustomers(QueryVo queryVo);
	
	/**
	 * 3.根据客户id查询客户数据
	 */
	Customer queryCustomerById(Long custId);
	
	/**
	 * 4.修改客户数据，保存数据库 
	 */
	void updateCustomerById(Customer customer);
	
	/**
	 * 5.根据客户id删除客户数据
	 */
	void deleteCustomerById(Long custId);

}
