package com.superbpm.platform.core.app1.entity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yqx on 10/7/15.
 */
@Entity
@Table(name = "SBP_APP1_TEST")
public class Test implements Serializable {

  @Id
  @Column(name = "D_UUID", nullable = false, length = 64)
  protected String uuid;

  @Id
  @Column(name = "D_NAME", nullable = false, length = 64)
  private String username; //用户名

  @Column(name = "D_PASSWORD", length = 255)
  private String password; //密码

  @Column(name = "D_SALT", length = 255)
  private String salt; //加密密码的盐

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }
}
