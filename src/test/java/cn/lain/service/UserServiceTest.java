package cn.lain.service;

import cn.lain.domain.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    void testSave() {
        User user = new User();
        user.setWorkid("280201");
        user.setName("马牛逼");
        user.setWage(6666);
        iUserService.save(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(11);
        user.setName("马美丽");
        iUserService.updateById(user);
    }

    @Test
    void testDelete() {
        iUserService.removeById(11);
    }

    @Test
    void testGetById() {
        iUserService.getById(3);
    }

    @Test
    void testAll() {
        iUserService.list();
    }

    @Test
    void testGetPage() {
        IPage<User> page = new Page<>(2, 5);
        iUserService.page(page);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }

}
