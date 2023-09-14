package cn.lain.service;

import cn.lain.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IAdminService extends IService<Admin> {

    Admin login(Admin login);
}
