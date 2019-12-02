package life.majiang.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fanshijun on 2019/11/28.
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}

