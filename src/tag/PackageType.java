package tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoshiqiang on 2016/9/10.
 */
public class PackageType {
    private List<ClassType> classTypes;
    private static Map<String,String> template;
    private static Map<String,String> outpath;
    private static String basepath;

    public List<ClassType> getClassTypes() {
        return classTypes;
    }

    public void setClassTypes(List<ClassType> classTypes) {
        this.classTypes = classTypes;
    }

    public static Map<String, String> getTemplate() {
        return template;
    }

    public static void setTemplate(Map<String, String> template) {
        PackageType.template = template;
    }

    public static Map<String, String> getOutpath() {
        return outpath;
    }

    public static void setOutpath(Map<String, String> outpath) {
        PackageType.outpath = outpath;
    }

    public static String getBasepath() {
        return basepath;
    }

    public static void setBasepath(String basepath) {
        PackageType.basepath = basepath;
    }

    public Map<String,List> transformTagvalue(){
        Map<String,List> map = new HashMap<>();

        List classvalues = new ArrayList();
        for (ClassType classType : classTypes){
            classvalues.add(classType.transformTagvalue());
        }
        map.put("classes",classvalues);
        return map;
    }
}
