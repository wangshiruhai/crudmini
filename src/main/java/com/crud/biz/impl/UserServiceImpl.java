package com.crud.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.crud.biz.IUserService;
import com.crud.entity.User;
import com.crud.entity.UserResp;
import com.crud.mapper.UserMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
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
    public List<UserResp> findUserList() {
        List<User> userList = userMapper.selectList(null);
        if(CollectionUtils.isEmpty(userList)){
            return Collections.EMPTY_LIST;
        }
        ArrayList<UserResp> userResps = new ArrayList<>();
        UserResp userResp = null;
        for (User user : userList) {
            userResp = new UserResp();
            BeanUtils.copyProperties(user,userResp);
            userResp.setId(String.valueOf(user.getId()));
            userResps.add(userResp);
        }
        return userResps;
    }

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public Boolean updateUser(User user) {
        if (Objects.isNull(user.getId())) {
            return Boolean.FALSE;
        }
        User dbUser = userMapper.selectById(user.getId());
        user.setVersion(dbUser.getVersion());
        int updateById = userMapper.updateById(user);
        return updateById > 0;
    }

    @Override
    public void deleteUser(Long id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("id should not be null");
        }
        userMapper.deleteById(id);
    }
}
