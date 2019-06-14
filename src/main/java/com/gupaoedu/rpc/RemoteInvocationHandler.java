package com.gupaoedu.rpc;

import com.gupaoedu.vip.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int post;

    public RemoteInvocationHandler(String host, int post) {
        this.host = host;
        this.post = post;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");

        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        rpcRequest.setVersion("v2.0");
        
        
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,post);
        Object result = rpcNetTransport.send(rpcRequest);

        return result;
    }
}
