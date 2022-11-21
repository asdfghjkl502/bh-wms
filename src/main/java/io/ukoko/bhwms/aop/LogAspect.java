package io.ukoko.bhwms.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        ObjectMapper om = new ObjectMapper();
        Object[] args = joinPoint.getArgs();
        LOGGER.info("方法入参==>{}",args);
        //获取结果
        LOGGER.info("方法返回值为 ==>>{}",proceed);
        LOGGER.info("----------------------------------------------------------------");
        return proceed;
    }

}
