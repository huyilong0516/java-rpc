package indi.yoalone.rpc.transport.support;

import indi.yoalone.rpc.serialize.packet.RequestBody;
import indi.yoalone.rpc.serialize.packet.ResponseBody;
import indi.yoalone.rpc.transport.Remote;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @desc 远程调用简单实现
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public class DefaultRemoteProcedureCall extends Socket implements Remote {

    public DefaultRemoteProcedureCall(String host, int port) throws IOException {
        super(host, port);
    }

    public ResponseBody invoke(RequestBody body) throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(this.getOutputStream());
        outputStream.writeObject(body);
        outputStream.flush();

        ObjectInputStream inputStream = new ObjectInputStream(this.getInputStream());
        ResponseBody responseBody = (ResponseBody)inputStream.readObject();

        return  responseBody;
    }


}
