
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.*;

/**
 * Created by rdd03 on 2016/3/8.
 */
public class index {

    private static String DIRPATH="D:/api2/2.0/";
    private static String DES_DIRPATH="D:/api2/";

    public static void main(String[] args) throws Exception {
        //创建configuration对象
        Configuration cfg = new Configuration();
        //指定模板路径
        File file = new File("");

        //为什么这里的路径不是D:\ProgramZhaoShiqiang\JavaWeb\DocletTest\src而是D:\ProgramZhaoShiqiang\JavaWeb\DocletTest
//        System.out.println(file.getAbsolutePath());
        //设置要解析的模板所在的目录，并加载模板文件
        cfg.setDirectoryForTemplateLoading(file);
        //设置编码方式
        cfg.setDefaultEncoding("UTF-8");
        Template indexTemplate = cfg.getTemplate("src/index.ftl");
//        System.out.print(indexTemplate.getRootTreeNode());

        Map indexRoot = new HashMap();
        List<Map> divlist = new ArrayList<>();
        indexRoot.put("divlist", divlist);
        indexRoot.put("date",new Date());
        File dirfile = new File(DIRPATH);
        File[] templist = dirfile.listFiles();
        for (int i = 0; i< templist.length ; i++)
        {
            if (templist[i].isFile())   //是文件，读取文件内容
            {
                File readfile = new File(DIRPATH + templist[i].getName());
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readfile),"UTF-8"));
                StringBuffer filecontent = new StringBuffer();
                String s = null;
                while ((s = reader.readLine()) != null)
                {
                    filecontent.append(s);
                }
                Map div = new HashMap();
                div.put("content",filecontent.toString());
                divlist.add(div);
                reader.close();
            }
        }

        File indexfile = new File("D:/api2/2.0.html");
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexfile),"UTF-8"));
        indexTemplate.process(indexRoot,write);
        write.flush();
        write.close();

    }
}
