package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    //rest api
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(@RequestParam("username")String username,
                      @RequestParam("password")String password){
        //1.validate username and password
        //2.gen token
        //3.缓存用户
    }
}
