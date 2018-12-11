package indi.yoalone.rpc.provider.demo;

import indi.yoalone.rpc.api.demo.IHelloService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2018/12/11.
 */
public class HelloServiceImpl implements IHelloService {
    public String sayHello(String msg) {
        return "hello " + msg;
    }

    public List<String> array2List(String[] strings) {
        return Arrays.asList(strings);
    }
}
