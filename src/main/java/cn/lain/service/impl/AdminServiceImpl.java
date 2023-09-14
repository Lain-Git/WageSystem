package cn.lain.service.impl;

import cn.lain.dao.AdminDao;
import cn.lain.domain.Admin;
import cn.lain.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements IAdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.getByUsernameAndPassword(admin);
    }
}
