package com.mxc.Service;

import com.mxc.model.Device;

public interface DeviceServices {
    String getter(Device device);
    String putter(Device device);
    //int putter();
    int posterPLUSLocal(String fun, int A, int B);
    int posterPLUSFarEnd(String fun, Device device, int A, int B);
    int posterFarEnd(String fun, Device device);
     <T> String poster(String method, T arg, Device device);
     <T> String poster(String method, T arg);
    public String zhuanFaZhuCe();
    void setipv4(String ipv4);
}
