package life.majiang.community.Controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setCode(code);
        System.out.print("-------->>"+code);
        accessTokenDTO.setState(state);
        System.out.print("--------->>"+state);
        String accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user=githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
