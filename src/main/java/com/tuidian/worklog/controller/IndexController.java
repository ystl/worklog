package com.tuidian.worklog.controller;

import com.tuidian.worklog.common.CommonMsg;
import com.tuidian.worklog.persistent.entity.User;
import com.tuidian.worklog.persistent.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@Controller
public class IndexController {

    @Resource
    UserRepository userRepository;

    @RequestMapping("init")
    @ResponseBody
    public CommonMsg init(HttpSession session) {
        User user = (User) session.getAttribute("TDUSER");
        CommonMsg cm = new CommonMsg(user);
        return cm;
    }

    @RequestMapping("add")
    @ResponseBody
    public CommonMsg add(HttpSession session, User user) {
        System.out.println("update---------");
        System.out.println(user.toString());
        User nowUser = (User) session.getAttribute("TDUSER");
        Date date = new Date();
        nowUser.setCreateTime(date);
        nowUser.setPlanDesc(user.getPlanDesc());
        nowUser.setState("1");
        userRepository.saveAndFlush(nowUser);
        return new CommonMsg();

    }

    @RequestMapping("/")
    public ModelAndView index(HttpSession session) {
        if (null == session.getAttribute("TDUSER")) {
            return new ModelAndView("index");
        }
        return home(session);
    }

    @RequestMapping("home")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("home");
        CommonMsg cm = new CommonMsg();
        modelAndView.addObject("user", session.getAttribute("TDUSER"));
        return modelAndView;
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonMsg login(HttpSession session, User user) {
        System.out.println(user.toString());
        CommonMsg cm = new CommonMsg();
        User verifyUser = new User();
        verifyUser.setUsername(user.getUsername());
        Optional<User> userOptional = userRepository.findOne(Example.of(verifyUser));
        System.out.println(Example.of(verifyUser).toString());
        System.out.println(userOptional.toString());
        if(!userOptional.isPresent()) {
            cm.setMsg("用户名不存在");
            return cm;
        }
        verifyUser = userOptional.get();
        if(!verifyUser.getPassword().equals(user.getPassword())) {
            cm.setMsg("密码错误");
            return cm;
        }
        session.setAttribute("TDUSER", verifyUser);
        System.out.println("ok");
        return cm;
    }

}
