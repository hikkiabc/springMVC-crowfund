package com.cf.controller;

import com.cf.beans.Member;
import com.cf.beans.Permission;
import com.cf.beans.User;
import com.cf.service.MemberService;
import com.cf.service.UserService;
import com.cf.utils.Md5;
import com.cf.utils.Md5Salt;
import com.cf.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    //    @Autowired
//    TestService ts;
    @Autowired
    UserService userService;
    @Autowired
    MemberService memberService;

    @RequestMapping("/index")
    public String index() {


        return "index";
    }

    @RequestMapping("/gotologin")
    public String goToLogin(@CookieValue(value = "username", required = false) String username,
                            @CookieValue(value = "password", required = false) String password,
                            @CookieValue(value = "type",required = false) String type,
                            RedirectAttributes attributes) {

        if (!Utils.isEmpty(username) && !Utils.isEmpty(password)) {
            attributes.addFlashAttribute("username", username);
            attributes.addFlashAttribute("password", password);
            attributes.addFlashAttribute("type", type);

            return "redirect:/login";
        }
        return "login";
    }

    @RequestMapping("/goToMain")
    public String goToMain(HttpSession session) {
        return "main";
    }

    @ResponseBody
    @RequestMapping("/login")
    public Object login(HttpServletRequest request, HttpServletResponse response, String accname, String password, Boolean remember,
                        String type, HttpSession session, @ModelAttribute("username") String cookieUsername,
                        @ModelAttribute("password") String cookiePassword, @ModelAttribute("type") String cookieType) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("autoLogin",false);
        if (!Utils.isEmpty(cookiePassword) && !Utils.isEmpty(cookieUsername) && !Utils.isEmpty(cookieType)) {
            map.put("accname", cookieUsername);
            map.put("password", cookiePassword);
            map.put("type", cookieType);
            map.replace("autoLogin",true);

        }
//        password = Md5.md52(password);
        else {
            map.put("accname", accname);
            map.put("password", password);
            map.put("type", type);

        }


        if ("user".equals(map.get("type"))) {
            try {
                System.out.println(1);
                Member member = memberService.login(map);
                map.put("success", true);

                session.setAttribute("user", member);

            } catch (Exception e) {
                map.put("success", false);
                e.printStackTrace();
            }
        } else if ("admin".equals(map.get("type"))) {

            try {
                System.out.println(2);
                User user = userService.login(map);
                map.put("success", true);
                map.put("msg", "Login success");
                session.setAttribute("user", user);

//            User user = (User) session.getAttribute("user");
                List<Permission> permissionList = userService.queryPermissionsByUserId(user.getId());

                Map<String, Object> permissionUrlsMap = userService.queryPermissionsUrls(user.getId());
//            System.out.println(permissionList);
                session.setAttribute("permissionList", permissionList);
                session.setAttribute("permissionUrlsMap", permissionUrlsMap);


            } catch (Exception e) {
                e.printStackTrace();

                map.put("success", false);
                map.put("msg", "Accname and Password don't match");
            }
        }

        if (!Utils.isEmpty(remember)) {
            if (remember) {
                Cookie cookie = new Cookie("username", accname.trim());
                Cookie cookie1 = new Cookie("password", password);
                Cookie cookie2 = new Cookie("type", type);
                cookie.setMaxAge(60 * 60);
                cookie.setPath("/");
                cookie1.setPath("/");
                cookie2.setPath("/");
                cookie1.setMaxAge(60 * 60);
                cookie2.setMaxAge(60 * 60);
                response.addCookie(cookie);
                response.addCookie(cookie2);
                response.addCookie(cookie1);
            }
        }

        Cookie[] cookies = request.getCookies();

        if (true==(Boolean) map.get("autoLogin")){
            if (true==(Boolean) map.get("success")){
                if ("user".equals(map.get("type"))) response.sendRedirect(request.getContextPath()+"/toMemberIndex");
               else response.sendRedirect(request.getContextPath()+"/goToMain");
            }
            else{
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")||cookie.getName().equals("password")||cookie.getName().equals("type")){
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
                response.sendRedirect(request.getContextPath()+"/gotologin");

                }

            }

         return map;

    }

    @RequestMapping("/toMemberIndex")
    public String toMemberIndex() {
        return "/member/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
