/**   
* @Title: CustomerController.java 
* @Package cn.itheima.crm.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 传智 小杨老师 
* @date 2018-3-13 上午9:56:19 
* @version V1.0   
*/
package cn.itheima.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.crm.po.BaseDict;
import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.service.BaseDictService;
import cn.itheima.crm.service.CustomerService;
import cn.itheima.crm.utils.Page;

/** 
 * @ClassName: CustomerController 
 * @Description:客户控制器类
 * @author 传智 小杨老师  
 * @date 2018-3-13 上午9:56:19 
 *  
 */
@Controller
@RequestMapping("cust")
public class CustomerController {
	
	// 注入数据字典service
	@Autowired
	private BaseDictService baseDictService;
	
	// 注入客户service
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 查询客户列表
	 * action="${pageContext.request.contextPath }/cust/list" 
	 */
	@RequestMapping("list")
	public String list(ModelMap modelMap,QueryVo queryVo){
		
		// 1.综合查询条件初始化
		// 客户来源：fromType：002
		List<BaseDict> fromType = this.baseDictService.queryBaseDictByTypeCode("002");
		// 所属行业：industryType：001
		List<BaseDict> industryType = this.baseDictService.queryBaseDictByTypeCode("001");
		// 客户级别：levelType：006
		List<BaseDict> levelType = this.baseDictService.queryBaseDictByTypeCode("006");
		
		// 2.响应综合查询条件模型数据
		modelMap.addAttribute("fromType",fromType);
		modelMap.addAttribute("industryType",industryType);
		modelMap.addAttribute("levelType",levelType);
		
		// 3.分页查询客户列表数据
		Page<Customer> page = this.customerService.queryCustomerListPage(queryVo);
		
		// 4.响应客户列表模型数据
		modelMap.addAttribute("page", page);
		
		// 5.参数数据回显
		modelMap.addAttribute("custName", queryVo.getCustName());
		modelMap.addAttribute("custSource",queryVo.getCustSource());
		modelMap.addAttribute("custIndustry",queryVo.getCustIndustry());
		modelMap.addAttribute("custLevel", queryVo.getCustLevel());
		
		
		return "customer";
	}
	
	/**
	 * 根据客户id查询客户数据
	 * 	url:"<%=basePath%>cust/edit",
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Long id){
		
		// 1.根据客户id查询客户数据
		Customer customer = this.customerService.queryCustomerById(id);
		
		return customer;
	}
	
	/**
	 * 修改客户数据，保存数据库
	 * 		"<%=basePath%>cust/update",
	 */
	@RequestMapping("update")
	@ResponseBody
	public void update(Customer customer){
		
		// 修改客户数据，保存数据库
		this.customerService.updateCustomerById(customer);
		
	}
	
	/**
	 * 根据客户id删除客户数据
	 * 	"<%=basePath%>cust/delcust",
	 */
	/*@RequestMapping("delcust")
	@ResponseBody
	public void delcust(Long id){
		// 删除客户数据
		this.customerService.deleteCustomerById(id);
	}*/
	
	/**
	 * 删除客户数据实现方式二
	 */
	@RequestMapping("delcust")
	@ResponseBody
	public Map<String,String> delcust(Long id){
		
		// 定义结果map
		Map<String,String> results = new HashMap<String,String>();
		try{
			// 测试异常
			//int i=1/0;
			
			// 删除客户数据
			this.customerService.deleteCustomerById(id);
			
			results.put("flag", "success");
		}catch(Exception e){
			e.printStackTrace();
			results.put("flag", "failure");
		}
		
		return results;
		
	}
	
	
	
	
	
	
	
	
	

}
