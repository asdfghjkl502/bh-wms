package io.ukoko.bhwms.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger("BH-WMS");


    /**
     * 统一日志
     */
    @Pointcut(value = "execution(* io.ukoko.bhwms.controller.*.*(..))")
    public void log(){}

    /**
     * 环绕通知
     */
    @Around(value = "log()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //获取主机IP地址
        LOGGER.info("客户端IP地址==>>{}",request.getRemoteAddr());
        //获取请求客户端地址
        LOGGER.info("请求URL地址==>>{}",request.getRequestURL().toString());
        //获取请求方式
        LOGGER.info("请求方式==>>{}",request.getMethod());
        //获取类名和方法名
        LOGGER.info("类名==>>{} |￥￥| 方法名==>>{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        //方法的入参
        Object[] args = joinPoint.getArgs();
        if(args!=null&& args.length>0){
            List<Object> list = Arrays.asList(args);
            LOGGER.info("方法入参==>{}",list);
        }else{
            LOGGER.info("方法入参==>{}","");
        }
        //获取结果
        LOGGER.info("方法返回值为 ==>>{}",proceed);
        Searcher searcher = null;
        try {

            //获取jar包中文件的输入流
            //将其保存到jar包文件所在目录
            //读取文件


            //通过 https://gitee.com/lionsoul/ip2region/tree/master/binding/java获取IP地址对应的省市区信息
            //获取Search实例
           // searcher = Searcher.newWithFileOnly(resource.getPath());
            //String info = searcher.searchByStr(request.getRemoteAddr());
            //客户的省市区
            LOGGER.info("123客户访问地址 ==>>{}");
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info("客户访问地址 ==>>{}","地址信息未知");
        }finally {
            if(searcher!=null){
                //关闭资源
                searcher.close();
            }
        }



        LOGGER.info("----------------------------------------------------------------");
        return proceed;
    }

}
