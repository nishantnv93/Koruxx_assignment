package com.example.AngularJSSpring.controller;

import com.example.AngularJSSpring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/getTableData")
    public Object getTableData(){
        ResponseEntity<Object> responseEntity = fileService.getTableData();
        return responseEntity.getBody();
    }

    @PostMapping("/updateTableData")
    public Object upDateTableData(@RequestBody Object courseDetails){
        ResponseEntity<Object> responseEntity = fileService.updateTableData(courseDetails);
        return responseEntity.getBody();
    }

    @GetMapping("/getFormData")
    public Object getFormData(){
        ResponseEntity<Object> responseEntity = fileService.getFormData();
        return responseEntity.getBody();
    }

    @PostMapping("/updateFormData")
    public Object updateFormData(@RequestBody Object formDetails){
        ResponseEntity<Object> responseEntity = fileService.updateFormData(formDetails);
        return responseEntity.getBody();
    }

    @PostMapping("/updateCustomerFormData")
    public Object updateCustomerFormData(@RequestBody Object customerDetails){
        ResponseEntity<Object> responseEntity = fileService.updateCustomerTableData(customerDetails);
        return responseEntity.getBody();
    }

    @PostMapping("/saveOrder")
    public Object saveOrderData(@RequestBody Object orderDetails){
        ResponseEntity<Object> responseEntity = fileService.saveOrderData(orderDetails);
        return responseEntity.getBody();
    }
}
