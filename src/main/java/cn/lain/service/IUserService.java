package cn.lain.service;

import cn.lain.domain.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {
    // IService<E>同样提供了大量的增删改查方法

    IPage<User> getPage(int currentPage, int pageSize);
    IPage<User> getPage(int currentPage, int pageSize, User user);
}
