package cn.lain.dao;

import cn.lain.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao extends BaseMapper<Admin> {

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin getByUsernameAndPassword(Admin admin);
}
