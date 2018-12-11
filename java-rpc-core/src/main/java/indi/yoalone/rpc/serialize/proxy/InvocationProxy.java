package indi.yoalone.rpc.serialize.proxy;

import indi.yoalone.rpc.serialize.Deserializer;
import indi.yoalone.rpc.serialize.Serializer;
import indi.yoalone.rpc.serialize.packet.RequestBody;
import indi.yoalone.rpc.serialize.packet.ResponseBody;
import indi.yoalone.rpc.serialize.support.DefaultDeserializer;
import indi.yoalone.rpc.serialize.support.DefaultSerializer;
import indi.yoalone.rpc.transport.Remote;
import indi.yoalone.rpc.transport.support.DefaultRemoteProcedureCall;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by admin on 2018/12/11.
 */
public class InvocationProxy implements InvocationHandler {

    private String host;

    private int port;

    public <T> T get(Class<T> clazz) {
        return getInstance(clazz);
    }

    private <T> T getInstance(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    public InvocationProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Serializer serializer = new DefaultSerializer();
        RequestBody requestBody = serializer.serialize(method, args);
        Remote remote = new DefaultRemoteProcedureCall(this.host, this.port);
        ResponseBody responseBody = remote.invoke(requestBody);
        Deserializer deserializer = new DefaultDeserializer();
        return deserializer.deserialize(responseBody);
    }
}
