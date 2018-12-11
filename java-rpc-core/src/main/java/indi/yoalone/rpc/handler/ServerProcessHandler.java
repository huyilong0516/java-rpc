package indi.yoalone.rpc.handler;

import indi.yoalone.rpc.registry.LocaleRegistry;
import indi.yoalone.rpc.serialize.packet.RequestBody;
import indi.yoalone.rpc.serialize.packet.ResponseBody;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static com.sun.deploy.util.ReflectionUtil.invoke;

/**
 * Created by admin on 2018/12/11.
 */
public class ServerProcessHandler implements Runnable{


    private Socket socket;

    public ServerProcessHandler(Socket socket) {
        this.socket =socket;
    }


    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            RequestBody requestBody = (RequestBody) inputStream.readObject();
            String className = requestBody.getClassName();
            Object o = null;
            if (LocaleRegistry.containsKey(className)){
                Object service = LocaleRegistry.get(className);
                o = invoke(service, requestBody.getMethodName(), requestBody.getParamTypes(), requestBody.getArgs());
            }
            ResponseBody responseBody = new ResponseBody();
            responseBody.setType(o==null? null : o.getClass());
            responseBody.setResponseData(o);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(responseBody);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
