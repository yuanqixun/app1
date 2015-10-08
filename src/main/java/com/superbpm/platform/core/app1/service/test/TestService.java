package com.superbpm.platform.core.app1.service.test;

import com.superbpm.platform.core.app1.dao.test.TestDao;
import com.superbpm.platform.core.app1.entity.test.Test;
import com.superbpm.platform.core.service.security.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class TestService {
  @Autowired
  private TestDao testDao;

  @Autowired
  private PasswordHelper passwordHelper;

  /**
   * 创建用户
   *
   * @param user
   */
  public Test createUser(Test user) {
    user.setUuid(UUID.randomUUID().toString());
    //加密密码
    testDao.createUser(user);
    return user;
  }

  public Test updateUser(Test user) {
    testDao.updateUser(user);
    return testDao.findOne(user.getUuid());
  }

  public void deleteUser(String userId) {
    testDao.deleteUser(userId);
  }

  /**
   * 修改密码
   *
   * @param userId
   * @param newPassword
   */
  public void changePassword(String userId, String newPassword) {
    Test user = testDao.findOne(userId);
    user.setPassword(newPassword);
    testDao.updateUser(user);
  }

  public Test findOne(String uuid) {
    return testDao.findOne(uuid);
  }

  public List<Test> findAll() {
    return testDao.findAll();
  }

  /**
   * 根据用户名查找用户
   *
   * @param username
   * @return
   */
  public Test findByUsername(String username) {
    return testDao.findByUsername(username);
  }

  /**
   * 验证登录
   *
   * @param username   用户名
   * @param password   密码
   * @param salt       盐
   * @param encryptpwd 加密后的密码
   * @return
   */
  public boolean checkUser(String username, String password, String salt, String encryptpwd) {
    String pwd = passwordHelper.encryptPassword(username, password, salt);
    return pwd.equals(encryptpwd);
  }


}
