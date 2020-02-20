package life.majiang.community.cache;

import life.majiang.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fanshijun on 2020/2/20.
 */
public class TagCache {

    public static List<TagDTO> get(){
        List<TagDTO> tagDTOs=new ArrayList<>();
        TagDTO program=new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("javascript","php","css","java","node.js","python","c++","c","golang"));
        tagDTOs.add(program);

        TagDTO framework=new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("spring","spring boot","struts","flask","koa","express","larayel"));
        tagDTOs.add(framework);

        TagDTO server=new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","ubuntu","tomcat","unix"));
        tagDTOs.add(server);

        TagDTO db=new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql","redis","mongodb","oracle","sqlite","sqlserver","memcached"));
        tagDTOs.add(db);
        return tagDTOs;

    }
    public static String filterInvalid(String tags){
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOs = get();

        List<String> tabList = tagDTOs.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tabList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}