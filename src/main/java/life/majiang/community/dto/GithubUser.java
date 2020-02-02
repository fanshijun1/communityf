package life.majiang.community.dto;

import lombok.Data;

/**
 * Created by fanshijun on 2019/12/1.
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
