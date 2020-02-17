package life.majiang.community.advice;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.ResultDTO;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fanshijun on 2020/2/10.
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e,
                                     Model model,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        String contentType = request.getContentType();
        if ("Application/json".equals(contentType)){
            ResultDTO resultDTO=null;
            //返回json
            if (e instanceof CustomizeException){
                resultDTO= ResultDTO.errorOf((CustomizeException) e);
            }else{
                resultDTO= ResultDTO.errorOf(CustomizeErrorCode.SYSTEM_ERROR);
            }
            try {
                response.setCharacterEncoding("utf-8");
                response.setStatus(200);
                response.setContentType("application/json");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e1) {
            }
            return null;
        }
        else{
            //错误页面跳转
            if (e instanceof CustomizeException){
                model.addAttribute("message",e.getMessage());
            }else{
                model.addAttribute("message",CustomizeErrorCode.SYSTEM_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }

    }
}
