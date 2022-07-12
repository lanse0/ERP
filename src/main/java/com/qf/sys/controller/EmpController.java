package com.qf.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Constants;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Module;
import com.qf.sys.service.EmpService;
import com.qf.sys.service.ModuleService;
import com.qf.utils.LayUIOperate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: EmpController
 * Author: HWang
 * Date:2022/5/6 10:33
 */
@Controller
@RequestMapping("/users")
public class EmpController {
    @Resource
    private EmpService empService;
    @Resource
    private ModuleService moduleService;

    @RequestMapping("/login")
    @ResponseBody
    public LayUIOperate loginCheck(String userName,String password,String code,HttpServletRequest request){
        LayUIOperate layUIOperate = new LayUIOperate();
        HttpSession session = request.getSession();
        String verifyCode = session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        Emp emp;
        if (verifyCode.equals(code)){//验证码正确
            emp = empService.login(userName);
            if (emp!=null){//用户名正确
                if (emp.getPassword().equals(password)){//密码正确
                    if (emp.getStatus().equals("1")){
                        session.setAttribute("user",emp);
                        //根据用户的权限id获取用户拥有的权限
                        List<Module> moduleList = moduleService.getEmpModules(emp.getRole().getId());
                        session.setAttribute("moduleList",moduleList);
                        layUIOperate.setSuccess(true);
                    }else {
                        layUIOperate.setSuccess(false);
                        layUIOperate.setMessage("用户状态异常！");
                    }
                }else {
                    layUIOperate.setSuccess(false);
                    layUIOperate.setMessage("密码错误");
                }
            }else {
                layUIOperate.setSuccess(false);
                layUIOperate.setMessage("用户名错误");
            }
        }else {
            layUIOperate.setSuccess(false);
            layUIOperate.setMessage("验证码错误！");
        }
        return layUIOperate;
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().invalidate();//清空session域
        return "login";
    }

    @RequestMapping("/getAllEmpList")
    @ResponseBody
    public TableData getAllEmpList(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        String empNoStr = request.getParameter("empNo");
        int empNo = empNoStr!=null&&!"".equals(empNoStr)?Integer.parseInt(empNoStr):0;
        String empName = request.getParameter("empName");
        String deptName = request.getParameter("deptName");
        String status = request.getParameter("status");
        //模糊查询条件
        Map params = new HashMap();
        params.put("empNo",empNo);
        params.put("empName",empName);
        params.put("deptName",deptName);
        params.put("status",status);
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Emp> data = empService.getAllEmpByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//总记录数
        tableData.setData(data.getList());//设置当前数据
        return tableData;
    }

    @RequestMapping("/getEmpByRoleId")
    @ResponseBody
    public TableData getEmpByRoleId(Integer roleId){
        List<Emp> empList = empService.getEmpByRole(roleId);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(empList.size());
        data.setData(empList);
        return data;
    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public LayUIOperate addEmp(@RequestBody Emp emp){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("addEmp -->"+emp);
        boolean f= empService.addEmp(emp);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("用户添加成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("用户添加失败");
        }
        return operate;
    }
    @RequestMapping("/updEmp")
    @ResponseBody
    public LayUIOperate updEmp(@RequestBody Emp emp){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("addEmp -->"+emp);
        boolean f= empService.updEmp(emp);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("用户修改成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("用户修改失败");
        }
        return operate;
    }
    @RequestMapping("/quitEmp")
    @ResponseBody//离职
    public LayUIOperate quitEmp(Integer id,String status){
        LayUIOperate operate=new LayUIOperate();
        boolean f= empService.quitEmp(id,status);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("毕业成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("毕业失败");
        }
        return operate;
    }
}
