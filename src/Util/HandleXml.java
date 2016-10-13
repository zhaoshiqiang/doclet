package Util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import tag.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoshiqiang on 2016/9/10.
 */
public class HandleXml {

    private HandleXml() {
    }

    public static void handlexml(String xmlAddress) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(xmlAddress));
        Element root = document.getRootElement();
//        System.out.println(root.getName());

        //处理包的标签
        Element packages = root.element("package");
        //设置包模板路径
        List<Element> packageviewpathes = packages.elements("viewpath");
        TypeFactory.getPACKAGETYPE().setTemplate(handlePackagePath(packageviewpathes));

        List<Element> packageOutpathes = packages.elements("outpath");
        TypeFactory.getPACKAGETYPE().setOutpath(handlePackagePath(packageOutpathes));

        Element packageBasepath = packages.element("basepath");
        if (packageBasepath.getText().endsWith("/")){
            TypeFactory.getPACKAGETYPE().setBasepath(packageBasepath.getText());
        }else {
            TypeFactory.getPACKAGETYPE().setBasepath(packageBasepath.getText()+"/");
        }

        //处理类的标签
        Element classtags = root.element("class");
        //设置类模板路径
        List<Element> classPathes = classtags.elements("viewpath");
        List<Map<String,String>> classpathList = handleMethodOrClassPath(classPathes);
        TypeFactory.getCLASSTYPE().setTemplate(classpathList.get(0));
        TypeFactory.getCLASSTYPE().setOutpath(classpathList.get(1));
        //处理类模板标签
        List<Element> classtaglist = classtags.elements("tag");
        TypeFactory.getCLASSTYPE().setTagList(handleTags(classtaglist));

        //处理方法的标签
        Element methodtags = root.element("method");
        //设置方法模板路径
        List<Element> methodPathes = methodtags.elements("viewpath");
        List<Map<String,String>> methodpathList = handleMethodOrClassPath(methodPathes);
        TypeFactory.getMETHODTYPE().setTemplate(methodpathList.get(0));
        TypeFactory.getMETHODTYPE().setOutpath(methodpathList.get(1));

        //处理方法model标签
        List<Element> methodtaglist = methodtags.elements("tag");
        TypeFactory.getMETHODTYPE().setTagList(handleTags(methodtaglist));

    }

    private static Map<String,String> handlePackagePath(List<Element> elementList){
        Map<String,String> path = new HashMap<String,String>();
        for (Element element : elementList){
            path.put(element.element("name").getText(), element.element("value").getText());
        }
        return path;
    }

    private static List<Map<String,String>> handleMethodOrClassPath(List<Element> elementList){
        List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
        Map<String,String> Template = new HashMap<String,String>();
        Map<String,String> Outpath = new HashMap<>();
        mapList.add(Template);
        mapList.add(Outpath);

        for (Element viewpath : elementList){
            Template.put(viewpath.element("name").getText(), viewpath.element("value").getText());
            Outpath.put(viewpath.element("name").getText(),"");
        }
        return mapList;
    }

    private static List<Tag> handleTags(List<Element> elementList){
        List<Tag> tagList = new ArrayList<Tag>();
        for (Element methodtag: elementList){
            Tag tag = new Tag();
            tagList.add(tag);

            Element name = methodtag.element("name");
            tag.setName(name.getText());

            Element type = methodtag.element("type");
            if ("split".equals(type.getText())){
                tag.setType(2);

                Element symbol = methodtag.element("symbol");
                tag.setSymbol(symbol.getText());

                List<Element> items = methodtag.elements("item");
                List<String> itemnames = new ArrayList<String>();
                for (Element item : items){
                    itemnames.add(item.getText());
                }
                tag.setItems(itemnames);
            }else if ("string".equals(type.getText())){
                tag.setType(1);
            }
        }
        return tagList;
    }

}
