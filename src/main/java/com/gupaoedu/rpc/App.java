package com.gupaoedu.rpc;

import com.gupaoedu.vip.IHelloService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);
        IHelloService service = rpcProxyClient.clientProxy(IHelloService.class,
                "localhost",8080);
        String result = service.sayHello("Mic");

        System.out.println(result);



    }
}
