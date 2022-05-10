package com.qf.sys.dao;

import com.qf.sys.po.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityDao {
    boolean addAuth(Authority authority);
    List<Authority> getAllAuth();
    List<Authority> getAuthByRole(@Param("roleId") int roleId);
}
