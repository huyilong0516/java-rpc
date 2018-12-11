package indi.yoalone.rpc;

import indi.yoalone.rpc.handler.ServerProcessHandler;
import indi.yoalone.rpc.registry.LocaleRegistry;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @desc 服务端
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public class Server extends ServerSocket{


    ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1));

    public Server(int port) throws IOException {
        super(port);
    }

    public void addListener(Object service){
        if (service == null){
            return;
        }
        Class[] classes = service.getClass().getInterfaces();
        for (Class clazz : classes) {
            LocaleRegistry.register(clazz.getName(), service);
        }

    }

    public void start(){
        Socket socket;
        try {
            while ((socket = this.accept()) != null) {
                executor.execute(new ServerProcessHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
