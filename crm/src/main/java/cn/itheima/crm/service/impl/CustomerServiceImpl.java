/**   
* @Title: CustomerServiceImpl.java 
* @Package cn.itheima.crm.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午10:59:34 
* @version V1.0   
*/
package cn.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.CustomerMapper;
import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.service.CustomerService;
import cn.itheima.crm.utils.Page;

/** 
 * @ClassName: CustomerServiceImpl 
 * @Description: 客户service实现类
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午10:59:34 
 *  
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	// 注入客户mapper接口
	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 分页查询客户列表数据
	 */
	public Page<Customer> queryCustomerListPage(QueryVo queryVo) {
		
		// 1.计算开始记录索引
		// 第一页：0；第二页：10；第三页：20.......
		int startIndex = 0;
		startIndex = (queryVo.getPage()-1)*queryVo.getRows();
		queryVo.setStartIndex(startIndex);
		
		// 2.统计客户列表数据
		Integer totalRecords = this.customerMapper.countCustomers(queryVo);
		
		// 3.查询客户列表数据
		List<Customer> list = this.customerMapper.queryCustomerList(queryVo);
		
		// 4.创建分页对象
		// public Page(int total, int page, int size, List<T> rows) {
		Page<Customer> page = new Page<Customer>(totalRecords,queryVo.getPage(),queryVo.getRows(),list);
		
		
		return page;
	}

	/**
	 * 根据客户id查询客户数据
	 */
	public Customer queryCustomerById(Long custId) {
		
		return customerMapper.queryCustomerById(custId);
	}

	/**
	 * 根据客户id修改客户数据，保存数据库
	 */
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
		
	}

	/**
	 * 根据客户id删除客户数据
	 */
	public void deleteCustomerById(Long custId) {
		customerMapper.deleteCustomerById(custId);
		
	}

}
