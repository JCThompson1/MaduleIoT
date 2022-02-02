package com.mxc.config;

public class HTTPBody {
    private String FunctionName;
    private String arg;
    private String returnMessage;

    public String getFunctionName() {
        return FunctionName;
    }

    public void setFunctionName(String functionName) {
        FunctionName = functionName;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
