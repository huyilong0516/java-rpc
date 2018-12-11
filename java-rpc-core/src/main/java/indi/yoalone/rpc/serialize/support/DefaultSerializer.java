package indi.yoalone.rpc.serialize.support;

import indi.yoalone.rpc.serialize.Serializer;
import indi.yoalone.rpc.serialize.packet.RequestBody;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/12/10.
 */
public class DefaultSerializer implements Serializer {



    public RequestBody serialize(Method method, Object[] args) throws IllegalAccessException, InstantiationException {
        if (method == null) {
            return null;
        }
        Class<RequestBody> destClass = RequestBody.class;
        RequestBody requestBody = destClass.newInstance();
        Class sourceClass = method.getDeclaringClass();
        requestBody.setClassName(sourceClass.getName());
        requestBody.setMethodName(method.getName());
        requestBody.setArgs(args);

        Class[] paramTypes = new Class[args.length];
        for (int i = 0; i< args.length; i++) {
            paramTypes[i] = args[i].getClass();
        }
        requestBody.setParamTypes(paramTypes);
        return requestBody;
    }
}
