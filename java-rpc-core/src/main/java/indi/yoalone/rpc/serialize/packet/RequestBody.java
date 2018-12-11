package indi.yoalone.rpc.serialize.packet;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/12/10.
 */
public class RequestBody implements Serializable{


    private String className;

    private String methodName;

    private Class<?>[] paramTypes;

    private Object[] args;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
