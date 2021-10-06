package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.service.RackService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;
import com.kosmo88.logistics_erp.wms.util.MyLog;


//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/wms/warehouse")
public class WarehouseController {
    
    @Autowired
    WarehouseService warehouseService;
   
    @Autowired
    RackService rackService;


    @RequestMapping(value = "/add")
    public String add() {
        return "wms/warehouse/addWarehouse";
    }
    
    @RequestMapping(value= {"/warehouse", "/"})
    public String warehouse(Model model) {
    	warehouseService.warehouse();
        return "wms/warehouse/warehouse";
    }
    
//    폐기
    @RequestMapping(value = "/list")
    public String list(Model model) {
    	List<WarehouseDto> list = warehouseService.list();
        return "wms/warehouse/warehouseList";
    }


	@RequestMapping(value = "/addAction")
    public String addAction(HttpServletRequest req, Model model) {
     	Map<String, String[]> paramMap = req.getParameterMap();
     	MyLog.logParamMap(paramMap);
     	System.out.println("파라미터 맵 값 : " + paramMap);
    	int warehouseId = warehouseService.addAction(paramMap);
    	rackService.addAction(paramMap, warehouseId);
    	
        return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = "/stock")
    public String stock(Model model) {
    	warehouseService.stock();
        return "wms/warehouse/stock";
    }

    @RequestMapping("/modify")
    public String modify(Model model){
    	warehouseService.modify();
    	return "wms/warehouse/modifyWarehouse";
    }
 
    @RequestMapping("/delete")
    public String delete(Model model){
    	warehouseService.delete();
    	return "wms/warehouse/warehouseList";
    }

    
    @RequestMapping("/viewRack")
    public String viewRack(Model model) {
    	warehouseService.viewRack();
        return "wms/warehouse/rackDetail";
    }

//    @RequestMapping("/rack")
//    public String rack(){
//    	return "";
//    }

}



//아마 객체정보를 response의 body message에 추가하는 메소드가 자동으로 생성되겠지? 
@SessionAttributes({"session", "userid"})
@RestController
@RequestMapping(value = "/wms/warehouse")
class WarehouseRestController {
    @Autowired
    WarehouseService warehouseService;
    // 거래처(구매처) 목록
    @ResponseBody
    @RequestMapping(value = "/info")
    public List<WarehouseDto> warehouseList() {
    	return warehouseService.list();
    }
    
   
  
    
    
}