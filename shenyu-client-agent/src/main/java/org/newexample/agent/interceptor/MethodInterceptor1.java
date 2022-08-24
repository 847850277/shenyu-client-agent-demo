package org.newexample.agent.interceptor;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import org.newexample.agent.bean.SpringCloudClientEventListener;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/8/23 2:23 下午
 **/
public class MethodInterceptor1 {


    @Advice.OnMethodEnter()
    public static void enter(@Advice.AllArguments(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object[] args) throws Throwable {

//        Object[] newArgs = new Object[args.length];
//        System.arraycopy(args, 0, newArgs, 0, args.length);
//        int index = 0;
        for (Object arg : args) {
            //System.out.println(arg);
            //System.out.println(arg);
            if(arg instanceof LinkedHashMap){
                Map maps = (Map) arg;
                String[] baseScan = (String[]) maps.get("basePackages");
                String[] newBaseScan = new String[baseScan.length + 1];
                System.arraycopy(baseScan, 0, newBaseScan, 0, baseScan.length);
                newBaseScan[baseScan.length] = "org.newexample";
                maps.put("basePackages",newBaseScan);
            }
            //index++;
        }
    }

}
