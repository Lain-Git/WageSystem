package cn.lain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 开启了对 Servlet 组件的支持
@SpringBootApplication
public class WageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WageSystemApplication.class, args);
    }

}
