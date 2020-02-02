package life.majiang.community.model;

import lombok.Data;

/**
 * Created by fanshijun on 2020/1/27.
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;//图像地址
}
