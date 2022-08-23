package org.example.agent.interceptor;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import org.example.agent.bean.SpringCloudClientEventListener;

/**
 * @author zhengpeng
 * @date 2022/8/23 2:23 下午
 **/
public class MethodInterceptor {


    @Advice.OnMethodEnter()
    public static void enter(@Advice.AllArguments(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object[] args) throws Throwable {
        SpringCloudClientEventListener springCloudClientEventListener = new SpringCloudClientEventListener();
        Object[] newArgs = new Object[args.length + 1];
        System.arraycopy(args, 0, newArgs, 0, args.length);
        newArgs[args.length] = springCloudClientEventListener;
        args = newArgs;
    }

}
