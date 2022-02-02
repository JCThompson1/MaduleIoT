package com.mxc.web;

import com.alibaba.fastjson.JSON;
import com.mxc.Service.DeviceServicesImpl;
import com.mxc.config.IDIPHash;
import com.mxc.config.PLUSArgData;
import com.mxc.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class test {

    @Autowired
    private DeviceServicesImpl deviceServices;

    @Autowired
    private IDIPHash idipHash;

    private ArrayList<Device> deviceArrayList = new ArrayList<>();

    @GetMapping(value = "/add")
    public Object add(@RequestParam String ID, String IP){
        idipHash.setIDIP(ID, IP);
        return "add success!";
    }

    @GetMapping(value = "/GetTest")
    public Object GetTest(@RequestParam String ID){
     
        String IP = idipHash.getIPFromID(ID);
        System.out.println("IP:" + IP);
        Device device = new Device(ID, IP);
        deviceArrayList.add(device);
        String getter = deviceServices.getter(deviceArrayList.get(0));
        return "Getter is :" + getter;
    }

    @GetMapping(value = "/PUTTest")
    public Object PUTTest(@RequestParam String ID){

        return "PUTTest end!";
    }

    @GetMapping(value = "/POSTTest")
    public Object POSTTest(@RequestParam String ID, String fun){//#http://127.0.0.1:8080/POSTTest?ID=MXCNO1&fun=PLUS  17module
        String IP = idipHash.getIPFromID(ID);
        System.out.println("IP:" + IP);
        Device device = new Device(ID, IP);
        deviceArrayList.add(device);
        int getter = deviceServices.posterPLUSFarEnd("PLUS", deviceArrayList.get(0), 1, 2);
        return getter;
    }
    @GetMapping(value = "/POSTTest2")
    public Object POSTTtest2(@RequestParam String fun){

        return "POSTTest end!";
    }

    @GetMapping(value = "/student1")
    public Object test1(@RequestParam String IP){
        String ID = "127.0.0.1:8080/student";
        Device device = new Device(ID, IP);
        deviceArrayList.add(device);
        return Arrays.toString(deviceArrayList.toArray());
    }

    @GetMapping("/del")
    public Object test2(){
        deviceArrayList.remove(0);
        return Arrays.toString(deviceArrayList.toArray());
    }

    @GetMapping("/querry")
    public String test3(){
        String getter = deviceServices.getter(deviceArrayList.get(0));
        return getter;
    }

   
    @GetMapping("/fanshiTest")
    public String fanshiTest(){
        Device device = new Device("MXCNO1", "http://127.0.0.1:8081/insert");
        PLUSArgData plusArgData = new PLUSArgData();
        plusArgData.setA(1);
        plusArgData.setB(2);
        String getter = deviceServices.poster("PLUS", plusArgData,device);
        System.out.println(getter);
        return getter;
    }

    @GetMapping("/fanshiGETTest")
    public String fanshiGETTest(){
        Device device = new Device("MXCNO1", "http://127.0.0.1:8081/insert");
        
        String ArgData = "{\"NO1\":\"temperature\",\"NO2\":\"wet\"}";
        //System.out.println(ArgData);
        String getter = deviceServices.poster("GET", ArgData, device);


        return getter;
    }

    @GetMapping("/fanshiPUTTest")
    public String fanshiPUTTest(){
        Device device = new Device("MXCNO1", "http://127.0.0.1:8081/insert");
        String ID = "MXCNO1";
        String ArgData = "{\"arg1\":\"123\",\"arg2\":\"auto\",\"arg3\":\"Registered\"}";
        String method = "anyOne";
        String getter = deviceServices.poster(method, ArgData, device);
        return getter;
    }

    @PutMapping("/zhuanFaZhuCe")
    public String zhuanFaZhuCe(@RequestBody String body){
        System.out.println(body);
        return body;
    }
}
