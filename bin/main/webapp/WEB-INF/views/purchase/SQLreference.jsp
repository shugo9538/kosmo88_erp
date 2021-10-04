<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>    
<!-- 
-- 견적서, 주문서(통합 뷰)
SELECT r.id as request_id, r.begin_date as begin_date, r.end_date as end_date, r.state as request_state, r.enabled as request_enabled
     , e.name as employee_name, e.photo as employee_photo, e.resident_reg_num as resident_reg_num, e.phone as employee_phone, e.address as employee_address
     , e.hire_date as hire_date, e.email as employee_email, e.enabled as employee_enabled, c.type as client_type, c.name as client_name
     , c.ceo_name as client_ceo_name, c.register_num as client_register_num, c.address as client_address, c.detail_address as client_detail_address
     , c.zip_code as client_zip_code, c.register_date as client_register_date, c.phone as client_phone, c.email as client_email, c.enabled as client_enabled
     , p.quantity as item_quantity, p.sales_price as item_sales_price, i.name as item_name, i.category as item_category, i.register_date as item_register_date
     , i.price as item_purchase_price
  FROM request r, employee e, client c, req_product_list q, product_group p, item i
 WHERE r.employee_id = e.id
   AND r.client_id = c.id
   AND r.id = q.request_id
   AND q.product_group = p.product_group
   AND p.item_id = i.id  
 ORDER BY r.id;
 
 
 
-- 일반전표(통합 뷰)
SELECT s.id as slip_id, s.type as slip_type, s.register_date as slip_register_date, s.update_date as slip_update_date, s.state as slip_state
     , r.begin_date as begin_date, r.end_date as end_date, r.state as request_state, r.enabled as request_enabled
     , e.name as employee_name, e.photo as employee_photo, e.resident_reg_num as resident_reg_num, e.phone as employee_phone, e.address as employee_address
     , e.hire_date as hire_date, e.email as employee_email, e.enabled as employee_enabled, c.type as client_type, c.name as client_name
     , c.ceo_name as client_ceo_name, c.register_num as client_register_num, c.address as client_address, c.detail_address as client_detail_address
     , c.zip_code as client_zip_code, c.register_date as client_register_date, c.phone as client_phone, c.email as client_email, c.enabled as client_enabled
     , p.quantity as item_quantity, p.sales_price as item_sales_price, i.name as item_name, i.category as item_category, i.register_date as item_register_date
     , i.price as item_purchase_price
  FROM slip s, request r, employee e, client c, req_product_list q, product_group p, item i
 WHERE s.department_request = r.id
   AND r.employee_id = e.id
   AND r.client_id = c.id
   AND r.id = q.request_id
   AND q.product_group = p.product_group
   AND p.item_id = i.id
 ORDER BY r.id;
 --> 
</body>
</html> 
 