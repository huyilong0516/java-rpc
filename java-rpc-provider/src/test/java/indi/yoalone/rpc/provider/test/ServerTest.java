package indi.yoalone.rpc.provider.test;

import indi.yoalone.rpc.Server;
import indi.yoalone.rpc.provider.demo.HelloServiceImpl;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by admin on 2018/12/11.
 */
public class ServerTest {

    @Test
    public void test(){
        try {
            Server server = new Server(8888);
            server.addListener(new HelloServiceImpl());
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
