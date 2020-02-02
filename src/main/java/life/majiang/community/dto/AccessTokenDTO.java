package life.majiang.community.dto;

import lombok.Data;

/**
 * Created by fanshijun on 2019/12/1.
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}
