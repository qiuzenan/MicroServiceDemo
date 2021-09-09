package user.service;

import UserInfo.UserService;
import UserInfo.UserInfo;
import org.apache.thrift.TException;

public class UserInfoService implements UserService.Iface{
    @Override
    public UserInfo getUserById(int id) throws TException {
        return null;
    }

    @Override
    public UserInfo getUserByname(String username) throws TException {
        return null;
    }

    @Override
    public void regiserUser(UserInfo userInfo) throws TException {

    }
}
