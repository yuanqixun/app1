package com.superbpm.platform.core.app1.dao.test;

import com.superbpm.platform.core.app1.entity.test.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TestDao {

  @Insert("insert into SBP_APP1_TEST(d_uuid,d_username, d_password, d_salt) values(#{uuid},#{username},#{password},#{salt})")
  int createUser(final Test test);

  @Update("update SBP_APP1_TEST set d_username=#{username}, d_password=#{password}, d_salt=#{salt} where d_uuid=#{uuid}")
  int updateUser(Test test);

  @Delete("delete from SBP_APP1_TEST where d_uuid=#{uuid}")
  int deleteUser(String uuid);

  @Select("select * from SBP_APP1_TEST where D_UUID=#{uuid} ")
  @ResultMap({"Test"})
  @One
  Test findOne(String uuid);

  @Select("select * from SBP_APP1_TEST")
  @ResultMap({"Test"})
  @Many
  List<Test> findAll();

  @Select("select * from SBP_APP1_TEST where d_username=#{username}")
  @ResultMap({"Test"})
  @Many
  Test findByUsername(String username);

}
