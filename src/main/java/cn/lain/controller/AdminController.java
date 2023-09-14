package cn.lain.controller;

import cn.lain.utils.JwtUtils;
import cn.lain.utils.R;
import cn.lain.domain.Admin;
import cn.lain.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @PostMapping("/login")
    public R adminLogin(@RequestBody Admin admin){

        Admin a = iAdminService.login(admin);

        // 登录成功
        if (a != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", a.getId());
            claims.put("username", a.getUsername());
            claims.put("adminname", a.getAdminname());

            String jwt = JwtUtils.generateJwt(claims);
            return new R(true, "success", jwt);
        }else {
            // 登录失败
            return new R(false, "failed", null);
        }

    }

}
