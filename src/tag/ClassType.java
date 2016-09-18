package tag;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoshiqiang on 2016/9/10.
 */
public class ClassType implements Serializable{
    private static final long serialVersionUID = -8834559347461591191L;
    private static Map<String,String> template;
    private List<MethodType> methodTypeList;
    private List<Tag> tagList;
    private Map<String,String> outpath;

    public List<MethodType> getMethodTypeList() {
        return methodTypeList;
    }

    public void setMethodTypeList(List<MethodType> methodTypeList) {
        this.methodTypeList = methodTypeList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public static Map<String, String> getTemplate() {
        return template;
    }

    public static void setTemplate(Map<String, String> template) {
        ClassType.template = template;
    }

    public Map<String, String> getOutpath() {
        return outpath;
    }

    public void setOutpath(Map<String, String> outpath) {
        this.outpath = outpath;
    }


    public Map<String,List> transformTagvalue(){
        Map<String,List> map = new HashMap<>();
        //转换class注解上的值
        for (Tag tag : tagList){
            map.put(tag.getName(),tag.transformTagvalue());
        }
        //转换class中method中的值
        List methodvalues = new ArrayList();
        for (MethodType methodType : methodTypeList){
            methodvalues.add(methodType.transformTagvalue());
        }
        map.put("methods",methodvalues);
        return map;
    }
}
