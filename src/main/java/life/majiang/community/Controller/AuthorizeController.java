package life.majiang.community.Controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import life.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by fanshijun on 2019/12/1.
 */
@Controller
public class AuthorizeController {
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.redirect.url}")
    private String redirectUrl;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state") String state,
                           HttpServletRequest request, HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setCode(code);
        System.out.print("-------->>"+code);
        accessTokenDTO.setState(state);
        System.out.print("--------->>"+state);
        String accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubuser=githubProvider.getUser(accessToken);
        System.out.println(githubuser.getName());
        if(githubuser!=null && githubuser.getId()!=null){
            //登录成功写cookie和session
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubuser.getName());
            user.setAccountId(String.valueOf(githubuser.getId()));
            user.setAvatarUrl(githubuser.getAvatarUrl());
            userService.createOrUpdate(user);
            //userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else{
            //登录失败,重新登录
            return "redirect:/";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){

        request.getSession().removeAttribute("user");

        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/";
    }
}
