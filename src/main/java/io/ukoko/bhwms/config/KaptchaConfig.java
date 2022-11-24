package io.ukoko.bhwms.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置
 */
@Configuration
public class KaptchaConfig {

    /**
     * 创建验证码核心对象,将其加入到IOC容器中
     */
    @Bean
    public DefaultKaptcha createDefaultKaptcha(Config config){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //初始化验证码配置
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    /**
     * 初始化验证码配置,加入到IOC容器中
     * @return
     */
    @Bean
    public Config createConfig(){
        Properties properties = new Properties();
        //声称验证码的长度
        properties.setProperty("kaptcha.textproducer.char.length","1");
        //设置高度
        properties.setProperty("kaptcha.image.height","38");
        //设置宽度
        properties.setProperty("kaptcha.image.width","155");
        //设置字体大小
        properties.setProperty("kaptcha.textproducer.font.size","30");
        //设置生成图片是否存在边框(yes存在,no不存在)
        properties.setProperty("kaptcha.border","no");
        Config config = new Config(properties);
        return config;
    }
}
