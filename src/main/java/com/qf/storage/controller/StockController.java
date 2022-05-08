package com.qf.storage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Stock;
import com.qf.storage.service.StockService;
import com.qf.storage.utils.PageUtils;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Region;
import com.qf.utils.LayUIOperate;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public TableData findByPage(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        //HttpSession session=request.getSession();
        String name = request.getParameter("name");
        Map params = new HashMap();
        params.put("name", name);
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Stock> data = stockService.findByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//设置总条数
        tableData.setData(data.getList());//设置当前的数据
        return tableData;
    }

    @RequestMapping("/addStorehouse")
    @ResponseBody
    public LayUIOperate addStorehouse(@RequestBody Stock Stock, HttpServletRequest request){

        HttpSession session=request.getSession();
//        Emp emp=(Emp)session.getAttribute("emp");
//        emp.setId(1);
        LayUIOperate operate=new LayUIOperate();
        boolean f= stockService.addStorehouse(Stock);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("添加成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("添加失败");
        }
        return operate;
    }
    @RequestMapping("/delStorehouse")
    @ResponseBody
    public LayUIOperate delStorehouse(Integer id){
        LayUIOperate operate=new LayUIOperate();
        boolean f= stockService.delStorehouse(id);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("删除成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("删除失败");
        }
        return operate;
    }
    @RequestMapping("/updateStorehouse")
    @ResponseBody
    public LayUIOperate updateStorehouse(@RequestBody Stock Stock, HttpServletRequest request){
        LayUIOperate operate=new LayUIOperate();
        boolean f= stockService.updateStorehouse(Stock);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("更新成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("更新失败");
        }
        return operate;
    }
    @RequestMapping("/getStorehouseById")
    public String getStorehouseById(int id){
        stockService.getStorehouseById(id);
        return "storehouseList2";
    }
    @RequestMapping("/fastJson")
    @ResponseBody
    public Stock getFastJson(Stock Stock){
        return Stock;
    }
    @RequestMapping("/dateTest")
    public void dateTest(Stock Stock){
        System.out.println(Stock);
    }
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile photoSource, Stock Stock, HttpServletRequest request) throws IOException {
        String fileName=photoSource.getOriginalFilename();
        String fileType=photoSource.getContentType();
        System.out.println(Stock.id);
        System.out.println(fileName+"&"+fileType);
        String newfileName= UUID.randomUUID().toString();
        String ext= FilenameUtils.getExtension(fileName);
        String parentDir=request.getSession().getServletContext().getRealPath("/uploadFiles");
        String newFile=newfileName+"."+ext;
        File file=new File(parentDir,newFile);
        photoSource.transferTo(file);
        return "success";
    }
}
