package com.example.AngularJSSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public ResponseEntity<Object> getTableData() {
        JSONParser jsonParser = new JSONParser();
        JSONArray courses = new JSONArray();
        try (FileReader reader = new FileReader("F:\\AngularJS-Spring\\Resultantfiles\\demo.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject)obj;
            courses = (JSONArray)jsonObject.get("Courses");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(courses, HttpStatus.OK);
    }

    public ResponseEntity<Object> updateTableData(Object courseDetails) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        JSONArray attributess = new JSONArray();
        Object object = null;
        try (FileReader reader = new FileReader("F:\\AngularJS-Spring\\Resultantfiles\\demo.json"))
        {
            Object obj = jsonParser.parse(reader);
            jsonObject = (JSONObject)obj;
            jsonObject.put("Courses", courseDetails);
            object = jsonObject.get("Courses");
            FileWriter file = new FileWriter("F:\\AngularJS-Spring\\Resultantfiles\\demo.json");
            file.write(jsonObject.toJSONString()+"\n");
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }


    public ResponseEntity<Object> getFormData() {
        JSONParser jsonParser = new JSONParser();
        JSONArray customers = new JSONArray();
        try (FileReader reader = new FileReader("F:\\AngularJS-Spring\\Resultantfiles\\demo.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject)obj;
            customers = (JSONArray)jsonObject.get("Customers");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(customers, HttpStatus.OK);
    }


    public ResponseEntity<Object> updateFormData(Object myObject) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            FileWriter tempFile = new FileWriter("F:\\AngularJS-Spring\\Resultantfiles\\customer1.json");
            ObjectMapper om = new ObjectMapper();
            om.writeValue(tempFile, myObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(myObject, HttpStatus.OK);
    }



    public ResponseEntity<Object> updateCustomerTableData(Object customerDetails) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        JSONArray attributess = new JSONArray();
        Object object = null;
        try (FileReader reader = new FileReader("F:\\AngularJS-Spring\\Resultantfiles\\demo.json"))
        {
            Object obj = jsonParser.parse(reader);
            jsonObject = (JSONObject)obj;
            jsonObject.put("Customers", customerDetails);
            object = jsonObject.get("Customers");
            FileWriter file = new FileWriter("F:\\AngularJS-Spring\\Resultantfiles\\demo.json");
            file.write(jsonObject.toJSONString()+"\n");
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(object, HttpStatus.OK);
    }


    public ResponseEntity<Object> saveOrderData(Object orderDetails){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        Object object = null;
        try (FileReader reader = new FileReader("F:\\AngularJS-Spring\\Resultantfiles\\demo.json"))
        {
            Object obj = jsonParser.parse(reader);
            jsonObject = (JSONObject)obj;
            jsonObject.put("Order", orderDetails);
            object = jsonObject.get("Order");
            FileWriter file = new FileWriter("F:\\AngularJS-Spring\\Resultantfiles\\demo.json");
            file.write(jsonObject.toJSONString()+"\n");
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>(orderDetails, HttpStatus.OK);
    }
}
