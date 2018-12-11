package indi.yoalone.rpc.provider.test;

import indi.yoalone.rpc.Server;
import indi.yoalone.rpc.provider.demo.HelloServiceImpl;
import org.junit.Test;

import java.io.IOException;

/**
 * @desc 服务端单元测试
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:37:16
 */
public class ServerTest {

    @Test
    public void test(){
        try {
            //创建服务实例
            Server server = new Server(8888);
            //添加对象监听 对象必须实现api接口
            server.addListener(new HelloServiceImpl());
            //启动服务
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
