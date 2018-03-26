/**   
* @Title: CustomerService.java 
* @Package cn.itheima.crm.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午10:58:27 
* @version V1.0   
*/
package cn.itheima.crm.service;

import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.utils.Page;

/** 
 * @ClassName: CustomerService 
 * @Description: 客户service接口
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午10:58:27 
 *  
 */
public interface CustomerService {
	
	/**
	 * 1.分页查询客户数据
	 */
	Page<Customer> queryCustomerListPage(QueryVo queryVo);
	
	/**
	 * 2.根据客户id查询客户数据
	 */
	Customer queryCustomerById(Long custId);
	
	/**
	 * 3.修改客户数据，保存数据库 
	 */
	void updateCustomerById(Customer customer);
	
	/**
	 * 4.根据客户id删除客户数据
	 */
	void deleteCustomerById(Long custId);

}
