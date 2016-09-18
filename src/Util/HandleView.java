package Util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import tag.ClassType;
import tag.MethodType;
import tag.PackageType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoshiqiang on 2016/9/12.
 */
public class HandleView {

    private static Map<String,Template> template = new HashMap<String,Template>();

    public static void init() throws Exception {
        //创建configuration对象
        Configuration cfg = new Configuration();
        //设置编码方式
        cfg.setDefaultEncoding("UTF-8");

        Map<String,String> packagemap = PackageType.getTemplate();
        for (String key : packagemap.keySet()){
            String filepath = packagemap.get(key);
            File file = new File(filepath.substring(0,filepath.lastIndexOf("/")));
            cfg.setDirectoryForTemplateLoading(file);
            Template template = cfg.getTemplate(filepath.substring(filepath.lastIndexOf("/")+1));
//            System.out.println(template.getRootTreeNode());
            HandleView.template.put(key, template);
        }

        Map<String,String> classmap = ClassType.getTemplate();
        for (String key : classmap.keySet()){
            String filepath = classmap.get(key);
            File file = new File(filepath.substring(0,filepath.lastIndexOf("/")));
            cfg.setDirectoryForTemplateLoading(file);
            Template template = cfg.getTemplate(filepath.substring(filepath.lastIndexOf("/") + 1));
//            System.out.println(template.getRootTreeNode());
            HandleView.template.put(key, template);
        }

        Map<String,String> methodmap = MethodType.getTemplate();
        for (String key : methodmap.keySet()){
            String filepath = methodmap.get(key);
            File file = new File(filepath.substring(0,filepath.lastIndexOf("/")));
            cfg.setDirectoryForTemplateLoading(file);
            Template template = cfg.getTemplate(filepath.substring(filepath.lastIndexOf("/") + 1));
//            System.out.println(template.getRootTreeNode());
            HandleView.template.put(key, template);
        }
    }

    public static void createfile(Map data, Map<String, String> outpath) throws Exception {

        Map<String,Template> map = null;

        for (String key : outpath.keySet()){
            File file = new File(PackageType.getBasepath()+outpath.get(key));
//            System.out.println(file.getPath());
            if (!file.getParentFile().exists()){
                //如果目录不存在则创建目录
                file.getParentFile().mkdirs();
            }
//            System.out.println(file.getPath());
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            template.get(key).process(data, write);
            write.flush();
            write.close();
        }

    }

}
