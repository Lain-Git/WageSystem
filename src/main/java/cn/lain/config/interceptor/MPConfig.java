package cn.lain.config.interceptor;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 什么是拦截器？
 * ==============
 * 一种重要的组件，设计目的在于对请求进行预处理或后处理，转交控制权给下一个处理器
 * 基于Java的AOP思想实现
 * 拦截一组请求 -> 进行一定的处理或者修改 -> 转发给下一个处理器
 */

// 配置MP提供的分页查询拦截器
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // MP提供的分页查询拦截器PaginationInnerInterceptor()
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
