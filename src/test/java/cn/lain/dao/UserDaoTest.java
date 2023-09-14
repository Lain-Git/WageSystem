package cn.lain.dao;

import cn.lain.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testSelectById() {
        userDao.selectById(1);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setName("马牛逼");
        user.setWorkid("280201");
        user.setWage(1000);
        userDao.insert(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(8);
        user.setName("马美丽");
        user.setWage(1200);
        user.setWorkid("280202");
        userDao.updateById(user);
    }

    @Test
    void testDelete() {
        userDao.deleteById(8);
    }

    @Test
    void testGetAll() {
        userDao.selectList(null);
    }

    @Test
    void testGetPage() {
        //需要使用MP的拦截器
        IPage<User> page = new Page<>(1, 5);
        // 该方法返回Ipage对象
        userDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetByCondition() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("college", "软件");
        userDao.selectList(wrapper);
    }

    @Test
    void testGetByCondition_2() {
        String cond = "马";

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(cond != null, User::getName, cond);
        userDao.selectList(lambdaQueryWrapper);
    }

}
