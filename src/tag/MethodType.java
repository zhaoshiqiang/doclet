package tag;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoshiqiang on 2016/9/10.
 */
public class MethodType implements Serializable{
    /*
    *如果对象序列化后存到硬盘上，可是后来你却更改了类的field(增加或减少或改名)，
    * 当你反序列化时，就会出现Exception的，这样就会造成不兼容性的问题
    *但当serialVersionUID相同时，它就会将不一样的field以type的缺省值赋值(如int型的是0,String型的是null等)，
    * 这个可以避开不兼容性的问题。所以最好给serialVersionUID赋值
    * */
    private static final long serialVersionUID = 7991552226614088458L;
    private List<Tag> tagList;
    private List<Tag> classList;
    private static Map<String,String> template;
    private Map<String,String> outpath;

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Tag> getClassList() {
        return classList;
    }

    public void setClassList(List<Tag> classList) {
        this.classList = classList;
    }

    public static Map<String, String> getTemplate() {
        return template;
    }

    public static void setTemplate(Map<String, String> template) {
        MethodType.template = template;
    }

    public Map<String, String> getOutpath() {
        return outpath;
    }

    public void setOutpath(Map<String, String> outpath) {
        this.outpath = outpath;
    }


    public Map<String,List> transformTagvalue(){
        Map<String,List> map = new HashMap<String,List>();
        for (Tag tag : tagList){
            map.put(tag.getName(),tag.transformTagvalue());
//            System.out.println(tag.getName()+"---->"+tag.transformTagvalue());
        }

        for (Tag tag : classList){
            map.put("class_" + tag.getName(), tag.transformTagvalue());
//            System.out.println(tag.getName() + "---->" + tag.transformTagvalue());
        }

        return map;
    }
}
