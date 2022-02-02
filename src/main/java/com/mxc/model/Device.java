package com.mxc.model;

public class Device {
    private String ID;
    private String IP;

    public Device(String ID, String IP) {

        this.IP = IP;
        this.ID = ID;
    }
    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
