package com.test.springbootthymeleaf.controller;

import com.test.springbootthymeleaf.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PageController {

    @GetMapping("/show")
    public String showPage(Model model, HttpServletRequest request){
        model.addAttribute("msg","Hello Thymeleaf");
        model.addAttribute("date",new Date());
        model.addAttribute("sex","男");
        model.addAttribute("id","123");
        List<User> list = new ArrayList<User>();
        list.add(new User("yy","男","25"));
        list.add(new User("xx","女","23"));
        list.add(new User("zz","男","24"));
        list.add(new User("dd","女","26"));
        model.addAttribute("list",list);
        Map<String,User> map = new HashMap<String,User>();
        map.put("user1",new User("yy","男","25"));
        map.put("user2",new User("xx","女","23"));
        map.put("user3",new User("yy","男","25"));
        map.put("user4",new User("dd","女","26"));
        model.addAttribute("map",map);

        request.setAttribute("req","request");
        request.getSession().setAttribute("ses","session");
        request.getServletContext().setAttribute("app","application");

        model.addAttribute("id","1");
        model.addAttribute("name","yx");
        return "index";
    }

    @GetMapping("/show2")
    public String showIndex(String id,String name){
        System.out.println(id+"   "+name);
        return "show";
    }

    @GetMapping("/show3/{id}/{name}")
    public String showIndexs(@PathVariable String id,@PathVariable String name){
        System.out.println(id+"  "+name);
        return "show";
    }


}
