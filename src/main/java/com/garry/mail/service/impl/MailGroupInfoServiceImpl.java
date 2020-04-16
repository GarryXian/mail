package com.garry.mail.service.impl;

import com.garry.mail.dao.MailGroupInfoDAO;
import com.garry.mail.model.MailGroupInfoPO;
import com.garry.mail.service.MailGroupInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 20:52
 */
@Service
public class MailGroupInfoServiceImpl implements MailGroupInfoService {

    @Resource
    private MailGroupInfoDAO mailGroupInfoDAO;

    @Override
    public List<MailGroupInfoPO> findAll() {
        return mailGroupInfoDAO.query(null);
    }
}
