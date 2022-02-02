package com.mxc.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class IDIPHash {
    public IDIPHash(){
        this.IDIPHash.put("MXCNO1", "http://127.0.0.1:8081/insert");
    }

    static HashMap<String, String> IDIPHash = new HashMap<>();//ID IP

    public HashMap<String, String> getIDIPHash() {
        return IDIPHash;
    }

    public void setIDIP(String ID, String IP) {
        this.IDIPHash.put(ID, IP);
    }
    public String getIPFromID(String ID){
        String IP = this.IDIPHash.get(ID);
        return IP;
    }
}
