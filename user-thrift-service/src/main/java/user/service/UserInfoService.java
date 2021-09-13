package user.service;

import UserInfo.UserService;
import UserInfo.UserInfo;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.mapper.UserMapper;

@Service
public class UserInfoService implements UserService.Iface{

    @Autowired
    public UserMapper userMapper;

    @Override
    public UserInfo getUserById(int id) throws TException {
        return userMapper.getUserInfoById(id);
    }

    @Override
    public UserInfo getUserByname(String username) throws TException {
        return userMapper.getUserByname(username);
    }

    @Override
    public void regiserUser(UserInfo userInfo) throws TException {
        userMapper.regiserUser(userInfo);
    }
}
