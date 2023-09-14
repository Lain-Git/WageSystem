package cn.lain.controller;

import cn.lain.utils.R;
import cn.lain.domain.User;
import cn.lain.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping
    public R getAll() {
        return new R(true, iUserService.list());
    }

    @PostMapping
    public R save(@RequestBody User user) throws IOException {
        if (user.getName().equals("000") )throw new IOException();
        boolean flag = iUserService.save(user);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public R update(@RequestBody User user) {
        return new R(iUserService.updateById(user));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(iUserService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {

        return new R(true, iUserService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize) {
//        IPage<User> page = iUserService.getPage(currentPage, pageSize);
//        // 若当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (currentPage > page.getPages()) {
//            page = iUserService.getPage((int) page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize, User user) {
        IPage<User> page = iUserService.getPage(currentPage, pageSize, user);
        // 若当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = iUserService.getPage((int) page.getPages(), pageSize, user);
        }
        return new R(true, page);
    }

}
