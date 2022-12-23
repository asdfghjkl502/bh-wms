package io.ukoko.bhwms.aop;

import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Object logAround(ProceedingJoinPoint joinPoint){
        BufferedReader br = null;
        Object proceed = null;
        try {
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
            //读取xdb文件的输入流
            ClassPathResource cpr = new ClassPathResource("xdb/ip2region.xdb");
            //获取文件输入流
            InputStream in = cpr.getInputStream();
            //获取jar包文件所在的路径
            ApplicationHome home = new ApplicationHome(getClass());
            File file = home.getSource();//当前jar包的真实文件路径
            //获取jar包文件的父目录
            String path = file.getParentFile().getPath();

            //判断当前目录下是否存在ip2region.xdb文件
            File f = new File(path + "ip2region.xdb");
            if(!f.exists()){
                //将文件复制到jar所在目录
                FileOutputStream out = new FileOutputStream(f);
                byte[] buff = new byte[128];
                int len=0;
                while((len=in.read(buff))!=-1){
                    out.write(buff,0,len);
                }
                //关流
                out.close();
                in.close();
            }
            //获取Searcher实例
            Searcher searcher = Searcher.newWithFileOnly(f.getPath());
            String search = searcher.search(request.getRemoteAddr());

            if(search.contains("内网")){ //说明是内网IP,不会确定城市信息
                String ip="https://ip.chinaz.com/";//https://ip.chinaz.com/
                URL url = new URL(ip);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                StringBuilder sb = new StringBuilder();
                String read="";
                while ((read=br.readLine())!=null){
                    sb.append(read+"\r\n");
                }
                Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
                Matcher m = p.matcher(sb.toString());
                if(m.find()){
                    String ipStr = m.group(1);
                    search = searcher.search(ipStr);
                }
            }
            //客户端城市定位
            LOGGER.info("客户端城市定位==>>{}",search);
            proceed = joinPoint.proceed();
            //获取结果
            LOGGER.info("方法返回值为 ==>>{}",proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new BhWmsException(BhWmsStatus.ERROR);
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        LOGGER.info("----------------------------------------------------------------");
        return proceed;
    }

}
