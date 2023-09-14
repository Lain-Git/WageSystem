package cn.lain.dao;

import cn.lain.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

// MyBatis提供用于标识dao接口的
// SpringBoot可以通过@MapperScan这个扫描注解来扫描标记了@Mapper的接口，并将该接口实现类注入到IOC容器中，供service层调用
@Mapper
public interface UserDao extends BaseMapper<User> {
    //BaseMapper<E>这个接口提供大量的增删改查方法
}
