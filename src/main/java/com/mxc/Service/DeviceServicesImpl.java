package com.mxc.Service;

import com.alibaba.fastjson.JSON;
import com.mxc.config.HTTPBody;
import com.mxc.config.IDIPHash;
import com.mxc.config.PLUSArgData;
import com.mxc.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class DeviceServicesImpl implements DeviceServices {


    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private IDIPHash idipHash;

    @Override
    public String getter(Device device) {
        String url = device.getIP();
        //url = url + "/student";
        //ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:8081/student", String.class);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();//200OK
        int statusCodeValue = responseEntity.getStatusCodeValue();//200
        HttpHeaders headers = responseEntity.getHeaders();//headers[Content-Type:"application/json"
                                                            // , Transfer-Encoding:"chunked", Date:"Wed, 03 Nov 2021 07:18:52 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
        System.out.println("body:" + body);//body
        return body;
    }

    @Override
    public String putter(Device device){

        String body = "enable";
        String url = device.getIP();
        restTemplate.put(url, body, 100);
        return "end";
    }

    @Override
    public int posterPLUSLocal(String fun, int A, int B) {
        //for instance PLUS
        int res = A + B;
        return res;
    }



    @Override
    public int posterPLUSFarEnd(String fun, Device device, int A, int B) {
        return 0;
    }
//    @Override
//    public int posterPLUSFarEnd(String fun, Device device, int A, int B){
//        System.out.println("test start!");
//        String url = device.getIP();
//        HTTPBody httpBody = new HTTPBody();
//        httpBody.setA(A);
//        httpBody.setB(B);
//        httpBody.setFunctionName(fun);
//        String httpBodyJsonString = JSON.toJSONString(httpBody);
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpBodyJsonString, String.class);
//        System.out.println(responseEntity.getBody());
//        int res = 0;
//        try{
//            res = Integer.parseInt(responseEntity.getBody());
//        }catch (NumberFormatException e){
//            res = -1;
//        }
//        return res;
//    }

    @Override
    public int posterFarEnd(String fun, Device device){
        return 0;
    }

    @Override
    public <T> String poster(String method, T arg, Device device) {

        String url = device.getIP();
        HTTPBody httpBody = new HTTPBody();
        if(method.equals("PLUS")){
            PLUSArgData temp = (PLUSArgData)arg;
            //httpBody.setFunctionName("PLUS");
            
            //PLUSArgData plusArgData = new PLUSArgData();
            String argJsonString = JSON.toJSONString(temp);
            httpBody.setFunctionName(method);
            httpBody.setArg(argJsonString);
            httpBody.setReturnMessage("");

            String httpBodyString = JSON.toJSONString(httpBody);
            //****************
           

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpBodyString, String.class);
            System.out.println(responseEntity.getBody());
            int res = 0;
            try{
                res = Integer.parseInt(Objects.requireNonNull(responseEntity.getBody()));
            }catch (NumberFormatException e){
                res = Integer.MIN_VALUE;
            }
            return res+"";
            //END IF PLUS
        }else if(method.equals("GET")){
            httpBody.setFunctionName(method);
            String argString = (String)arg;
            httpBody.setArg(argString);
            httpBody.setReturnMessage("");

            String httpBodyString = JSON.toJSONString(httpBody);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpBodyString, String.class);
            System.out.println(responseEntity.getBody());
            String res = responseEntity.getBody();
            return res;
        }
        else{
            httpBody.setFunctionName(method);
            String argString = (String)arg;
            httpBody.setArg(argString);
            httpBody.setReturnMessage("");

            String httpBodyString = JSON.toJSONString(httpBody);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpBodyString, String.class);
            System.out.println(responseEntity.getBody());
            String res = responseEntity.getBody();
            return res;
        }
//******************************************************************
        /**///String res = arg.getClass().toString();
        //return res;
    }

    @Override
    public <T> String poster(String method, T arg) {
        if(method.equals("PLUS")){
            PLUSArgData temp = (PLUSArgData)arg;
            int res = temp.getA() + temp.getB();
            return res+"";
        }else if(method.equals("MINUS")){
          
            PLUSArgData temp = (PLUSArgData)arg;
            int res = temp.getA() - temp.getB();
            return res+"";
        }
        else{
            return "Input Error!";
        }
    }

    @Override
    public String zhuanFaZhuCe(){

        return "";
    }

    @Override
    public void setipv4(String ipv4) {
    }
}
