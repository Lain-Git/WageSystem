package cn.lain.service.impl;

import cn.lain.dao.UserDao;
import cn.lain.domain.User;
import cn.lain.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    // 将Spring容器中的Bean自动和我们所需的Bean的类组装在一起
    @Autowired
    private UserDao userDao;

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage<User> page = new Page<>(currentPage, pageSize);
        userDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 为什么没设置模糊查询语句却自动进行模糊查询？
        // like()通过拼接Sql语句实现的模糊查询条件，底层已经做好了模糊查询相关事宜，不需要再次写
        // 该方法的一个参数SqlLike.DEFAULT实现了MP中ISqlLike接口中的left(String str)和right(String str)两个方法
        // left(String str)：返回一个以str作为前缀的通配符字符串
        // right(String str)：返回一个以str作为后缀的通配符字符串
        // SqlLike.DEFAULT：其默认实现则是使用 % 作为通配符
        // 而 % 就是进行模糊匹配的关键
        wrapper.like(Strings.isNotEmpty(user.getWorkid()), User::getWorkid, user.getWorkid());
        // User::getXxx -> Java8引入的语法（lambda表达式），用于方法引用，表示对User类的getXxx()方法的引用，这里是作获取列名的作用
        // 这里如果使用字符串作为作为column参数时，需要手动拼接Sql语句，容易出现Sql注入等安全问题，使用lambda表达式则使程序更安全
        wrapper.like(Strings.isNotEmpty(user.getName()), User::getName, user.getName());
        IPage<User> page = new Page<>(currentPage, pageSize);
        userDao.selectPage(page, wrapper);
        return page;
    }
}
