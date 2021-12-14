package com.crud.biz;

import com.crud.entity.User;
import com.crud.entity.UserResp;
import java.util.List;

/**
 * @author tommy
 * @date 11/6/21
 */
public interface IUserService {

    List<UserResp> findUserList();

    void saveUser(User user);

    Boolean updateUser(User user);

    void deleteUser(Long id);

}
