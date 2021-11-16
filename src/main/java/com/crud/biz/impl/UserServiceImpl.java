package com.crud.biz.impl;

import com.crud.biz.IUserService;
import com.crud.entity.User;
import com.crud.mapper.UserMapper;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author tommy
 * @date 11/6/21
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findUserList() {
        return userMapper.selectList(null);
    }

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public Boolean updateUser(User user) {
        if(Objects.isNull(user.getId())){
            return Boolean.FALSE;
        }
        userMapper.updateById(user);
        return Boolean.TRUE;
    }

    @Override
    public void deleteUser(Long id) {
        if(Objects.isNull(id)){
            throw new RuntimeException("id should not be null");
        }
        userMapper.deleteById(id);
    }
}
