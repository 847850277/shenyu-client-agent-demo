package org.example.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import org.example.agent.interceptor.MethodInterceptor;

import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;


/**
 * @author zhengpeng
 * @date 2022/8/23 2:21 下午
 **/
public class AppAgent {


    public static void premain(String arg, Instrumentation instrumentation) {

        AgentBuilder.Transformer transformer = new AgentBuilder.Transformer() {
            @Override
            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, ProtectionDomain protectionDomain) {
                try {
                    builder = builder
                            .method(ElementMatchers.named("addApplicationListener"))
                            .intercept(Advice.to(MethodInterceptor.class));
                }catch (Exception e){
                }
                return builder;
            }
        };

        new AgentBuilder.Default()
                .with(DebugListener.getListener())
                //.with(AgentBuilder.Listener.StreamWriting.toSystemError())
                //.type(ElementMatchers.nameStartsWith("org.springframework.context."))
                .type(ElementMatchers.named("org.springframework.context.support.AbstractApplicationContext"))
                .transform(transformer)
                .installOn(instrumentation);


    }


}
