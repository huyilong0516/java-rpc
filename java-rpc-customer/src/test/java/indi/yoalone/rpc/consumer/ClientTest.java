package indi.yoalone.rpc.consumer;

import indi.yoalone.rpc.Client;
import indi.yoalone.rpc.api.demo.IHelloService;
import org.junit.Test;

import java.util.List;

/**
 * Created by admin on 2018/12/11.
 */
public class ClientTest {


    @Test
    public void test(){
        //创建客户端实例，连接服务端
        Client client = new Client("localhost", 8888);
        //获取服务实例
        IHelloService helloService = client.getService(IHelloService.class);
        //调用服务
        System.out.println(helloService.sayHello("yoalone"));
        List<String> stringList = helloService.array2List(new String[]{"111","222"});
    }
}
