import com.sun.javadoc.*;
import com.sun.tools.doclets.formats.html.ConfigurationImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * @mytag class mytag
 */
public class doclet1 {
    //类相关的注解
    private static String CLASS_DESCRIBE = "description";   //类的描述，如人脉，用户，消息
    private static String CLASS_URI = "uri";   //类的访问路径
    //方法相关的注解
    private static String METHOD_URI = "uri";   //方法访问路径
    private static String METHOD_TYPE = "type"; //方法类别
    private static String METHOD_DESCRIBE = "description"; //方法描述
    private static String METHOD_PATH = "path"; //UE中如何找到接口
    private static String METHOD_SUPPORT = "datatype";   //支持格式（json）
    private static String METHOD_REQUESTTYPE = "method";   //请求方式（get/post）
    private static String METHOD_PARAM = "param";   //传入参数描述，描述格式为：名称~必选~类型~说明（若为非必选，须说明什么情况下不选）
    private static String METHOD_NOTICE = "notice"; //注意事项
    private static String METHOD_RETURNJSON = "returnjson"; //返回的json格式
    private static String METHOD_RETURNPARAM = "returnparam";   //输出参数描述，描述格式为：名称~类型~字段说明


    private static String HTML_CSS = "<style type=\"text/css\"> body{font: 12px/1.125 Arial, Helvetica, sans-serif; } .wiki_title{line-height: 37px; border-bottom: 1px " +
            "solid #e5e5e5; margin: 16px 0 8px 0; font-size: 20px; color: #333; font-family: \"Microsoft Yahei\"; font-weight: 300; } h1." +
            "wiki_title{font-size: 24px; } a{color: #3c7cb3; text-decoration: none; } table{border-collapse: collapse; border-spacing: 0;" +
            " } table.parameters{border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; -" +
            "webkit-border-horizontal-spacing: 0px; -webkit-border-vertical-spacing: 0px; width: 100%; } th,td{text-align: center; font-" +
            "weight: bolder; border: 1px solid #cccccc; height: 20px; } .code_type{text-transform: uppercase; margin-bottom: 5px; display" +
            ": inline-block;* display: inline;* zoom: 1; background: #b4e3b4; border-radius: 2px; color: #008200; padding: 2px 8px; } a:" +
            "hover{text-decoration: underline; } </style> ";
    private static String methodUri;
    private static String methodType;
    private static String methodDescribe;
    private static String methodPath;
    private static String methodSupport;
    private static String methodRequesttype;
    private static ArrayList<String> methodParam;
    private static String methodNotice;
    private static String methodReturnJson;
    private static ArrayList<String> methodReturnParam;


    private static String CLASSITEM="<table class = \"custom\"><colgroup><col class = \"tbF1\"><col class = \"tbF2\"><col></colgroup><tr><th colspan=\"3\">CLASS_DESCRIBE</th></tr>";
    private static String METHODITEMHEAD="<tr><td rowspan=\"METHOD_TYPE_NUM\">METHOD_TYPE</td><td><a href=\"CLASS_URI/METHOD_URI.html\">CLASS_URI/METHOD_URI</a></td>"+
            "<td>METHOD_PATH</td></tr>";
    private static String METHODITEM="<tr><td><a href=\"CLASS_URI/METHOD_URI.html\">CLASS_URI/METHOD_URI</a></td>"+
            "<td>METHOD_PATH</td></tr>";

    private static String DIRPATH="D:/api2/";

    private static String SRCNAME = "com.bluemobi.bluecollar.network";
    private static String MAPOPERATION ="map.put(\"PARAM\", PARAM);";
    private static String APIPATH = "private static final String APIPATH = \"URI\";";
    private static String packagename="package SRCNAME.request;";
    private static String importname = "import java.util.HashMap;\nimport java.util.Map;\nimport com.android.volley.Response.ErrorListener;\nimport com.android.volley.Response.Listener;\nimport SRCNAME.LlptHttpJsonRequest;\nimport SRCNAME.response.METHODNAMEResponse;";
    private static String methodname = "public class METHODNAMERequest extends LlptHttpJsonRequest<METHODNAMEResponse> {";
    private static String constructor1 = "public METHODNAMERequest(Listener<METHODNAMEResponse> listener, ErrorListener errorListener) {\n" +
            "\t\tsuper(Method.POST, APIPATH, listener, errorListener);\n" +
            "\t}";
    private static String constructor2 = "public METHODNAMERequest(int method, String partUrl, Listener<METHODNAMEResponse> listener, ErrorListener errorListener) {\n" +
            "\t\tsuper(method, partUrl, listener, errorListener);\n" +
            "\t}";
    private static String GetApiPath = "public String GetApiPath() {return APIPATH;}";
    private static String getResponse = "public Class<METHODNAMEResponse> getResponseClass() {return METHODNAMEResponse.class;}";
    private static String paramModel = "private String PARAM;\n" +
            "public String getPARAM() {return PARAM;}\n" +
            "public void setPARAM(String PARAM) {this.PARAM = PARAM;}";
    private static String GetParameters ="public Map<String, String> GetParameters() {\n" +
            "\t\tMap<String, String> map = new HashMap<String, String>();\n" +
            "mapOperation"+
            "\n\t\treturn map;\n" +
            "\t}";

    /**
     * @mytag start mytag
     * @param root
     */
    public static boolean start(RootDoc root) {


        try {
            doc(root.classes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private static String doc_class(ClassDoc classDoc, String TAG)
    {
        Tag[] Class_Describe = classDoc.tags(TAG);
//        for (int j = 0; j < Class_Describe.length; j++) {
//            System.out.println(Class_Describe[j].text());
//        }
        if (Class_Describe.length != 0)
        {
            return Class_Describe[0].text();
        }else {
            return null;
        }

    }

    private static String docMethod(MethodDoc methodDoc, String TAG)
    {

            Tag[] mcts = methodDoc.tags(TAG);

            if (mcts.length != 0)
                return mcts[0].text();
            else
                return null;
    }

    private static ArrayList<String> docMethodList(MethodDoc methodDoc, String TAG)
    {
        ArrayList<String> params = new ArrayList<String>();
        Tag[] mcts = methodDoc.tags(TAG);
        for (int i=0; i < mcts.length ; i++)
        {
            params.add(mcts[i].text());
        }
        return params;
    }
    /**
     * @mytag doc mytag
     * @param classDocs
     */
    private static void doc(ClassDoc[] classDocs) throws Exception {
        BufferedWriter write=null;

        for (int i = 0; i < classDocs.length; i++) {

            String class_describe=doc_class(classDocs[i], CLASS_DESCRIBE);
            String class_uri=doc_class(classDocs[i], CLASS_URI);

            int writenum = 0;
            int readnum = 0;
            StringBuffer writediv = new StringBuffer(); //写入块的存储
            StringBuffer readdiv = new StringBuffer();  //读取块的存储
//            StringBuffer index = new StringBuffer();    //整个写入文件
//            index.append(CLASSTABLE);
//            System.out.println(class_describe);
//            System.out.println(classDocs[i]);
            String classitem=CLASSITEM.replaceAll("CLASS_DESCRIBE",class_describe);    //替换该字符串中的方法描述

            StringBuffer destdirname= new StringBuffer();
            destdirname.append(DIRPATH).append(doc_class(classDocs[i], CLASS_URI));
            File dir = new File(destdirname.toString());
            if (dir.exists()) {
//                System.out.println("创建目录" + destdirname.toString() + "失败，目标目录已经存在");
            }
            //创建目录
            if (dir.mkdirs()) {
//                System.out.println("创建目录" + destdirname.toString() + "成功！");
            } else {
//                System.out.println("创建目录" + destdirname.toString() + "失败！");
            }

            MethodDoc[] methods = classDocs[i].methods();
//            System.out.println(methods.length);
            for(int j = 0; j< methods.length; j++){

                StringBuffer HTMLString = new StringBuffer();

                StringBuffer paramstring = new StringBuffer();
                StringBuffer parammap = new StringBuffer();

                String method_uri=docMethod(methods[j], METHOD_URI);

                String method_path=docMethod(methods[j],METHOD_PATH);
//                System.out.println(methods[j]);
                String method_type=docMethod(methods[j], METHOD_TYPE);
//                for (Tag tag: methods[j].tags()){
//                    System.out.println(tag+":"+tag.text());
//                }
                //获取uri后即可得函数名称，API路径，构造函数，
                String packagename1 = packagename.replaceAll("SRCNAME",SRCNAME);
                System.out.println(class_uri+"+"+method_uri);
                String importname1=importname.replaceAll("METHODNAME",method_uri);
                importname1=importname1.replaceAll("SRCNAME",SRCNAME);
                String methodname1 = methodname.replaceAll("METHODNAME",method_uri);
                String construct1 = constructor1.replaceAll("METHODNAME",method_uri);
                String construct2 = constructor2.replaceAll("METHODNAME",method_uri);
                String getresponsecalss1 = getResponse.replaceAll("METHODNAME",method_uri);
                String uri = "/"+class_uri+"/"+method_uri;
                String apipath = APIPATH.replaceAll("URI",uri);

                //首页数据的写入
                if (method_type.equals("write")) {
                    writenum++;
                    if (writenum == 1)
                    {
                        String methoditemhead=METHODITEMHEAD.replaceAll("METHOD_TYPE_NUM","writenum");

                        methoditemhead=methoditemhead.replaceAll("CLASS_URI",class_uri);
                        methoditemhead=methoditemhead.replaceAll("METHOD_URI",method_uri);
//                        System.out.println(class_uri);
//                        System.out.println(class_describe);
//                        System.out.println(method_path);
//                        System.out.println(method_uri);
//                        System.out.println(methoditemhead);

                        methoditemhead=methoditemhead.replaceAll("METHOD_PATH",method_path);
                        methoditemhead=methoditemhead.replaceAll("METHOD_TYPE", "写入接口");
                        writediv.append(methoditemhead);
                    }else {
                        String methoditem = METHODITEM.replaceAll("CLASS_URI",class_uri);
                        methoditem = methoditem.replaceAll("METHOD_URI",method_uri);
                        methoditem = methoditem.replaceAll("METHOD_PATH",method_path);
                        writediv.append(methoditem);
                    }
                }
                else if (method_type.equals("read"))
                {
                    readnum++;
                    if (readnum == 1)
                    {
                        String methoditemhead=METHODITEMHEAD.replaceAll("METHOD_TYPE_NUM","readnum");
                        methoditemhead=methoditemhead.replaceAll("CLASS_URI",class_uri);
                        methoditemhead=methoditemhead.replaceAll("METHOD_URI",method_uri);
                        methoditemhead=methoditemhead.replaceAll("METHOD_PATH",method_path);
                        methoditemhead=methoditemhead.replaceAll("METHOD_TYPE", "读取接口");
                        readdiv.append(methoditemhead);
                    }else {
                        String methoditem = METHODITEM.replaceAll("CLASS_URI",class_uri);
                        methoditem = methoditem.replaceAll("METHOD_URI",method_uri);
                        methoditem = methoditem.replaceAll("METHOD_PATH",method_path);
                        readdiv.append(methoditem);
                    }
                }


                HTMLString.append("<!DOCTYPE html> <html> <meta charset = utf8 > <head> <title></title> </head>");
                HTMLString.append(HTML_CSS);
                HTMLString.append("<body>");

                HTMLString.append("<h1 class=\"wiki_title\"><span class=\"mw-headline\">");
                HTMLString.append(class_uri+"/");
                HTMLString.append(method_uri);
//                System.out.println(docMethod(methods[j], METHOD_URI));
                HTMLString.append("</span></h1>");

                HTMLString.append("<p>");
                HTMLString.append(docMethod(methods[j], METHOD_DESCRIBE));
//                System.out.println(docMethod(methods[j], METHOD_DESCRIBE));
                HTMLString.append("</p>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\">URL</span> </h2>");

                HTMLString.append("<p> <span style=\"text-transform:lowercase;font-weight:600\"> <a rel=\"nofollow\" class=\"external free\" href=\"\">http://test.jchvip.net/");
                HTMLString.append(class_uri+"/");
                HTMLString.append(method_uri);
                HTMLString.append("</a> </span> </p>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\" >支持格式</span> </h2>");

                HTMLString.append("<p> <span style=\"text-transform:uppercase;font-weight:600\">");
                HTMLString.append(docMethod(methods[j], METHOD_SUPPORT));
                HTMLString.append("</span> </p>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\" >HTTP请求方式</span> </h2> ");

                HTMLString.append("<p> <span style=\"text-transform:uppercase;font-weight:600\">");
                HTMLString.append(docMethod(methods[j], METHOD_REQUESTTYPE));
                HTMLString.append("</span> </p>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\" >请求参数</span> </h2>");

                HTMLString.append("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"parameters\" style=\"border-color: #CCCCCC;\"><tbody>");
                HTMLString.append("<tr> <th width=\"10%\" style=\"text-align:center;font-weight:bolder;border:1px solid #cccccc\">名称</th> <th width=\"5%\" style=\"text-align:center;font-weight:bolder;border:1px solid #cccccc\">必选</th> <th width=\"10%\" style=\"text-align:center;font-weight:bolder;border:1px solid #cccccc\">类型及范围</th> <th width=\"75%\" style=\"text-align:center;font-weight:bolder;border:1px solid #cccccc\">说明</th> </tr>");
                ArrayList<String> params = docMethodList(methods[j], METHOD_PARAM);//list中每一项对应一个请求参数的数据
                for (int k=0; k<params.size();k++)
                {

                    String param = params.get(k);   //获取每一个参数数据
                    String[] options = param.split("~");    //拆分需要的数据
                    HTMLString.append("<tr>");

                    HTMLString.append("<td style=\"text-align:center;font-weight:bolder;border:1px solid #cccccc\">");
                    HTMLString.append(options[0]);  //名称

                    //每个参数即对应每个属性，对其进行操作
                    parammap.append(MAPOPERATION.replaceAll("PARAM",options[0]));   //对getparameters中的map添加参数
                    paramstring.append(paramModel.replaceAll("PARAM",options[0]));  //生成属性和其对应的get，set方法

                    HTMLString.append("</td>");

                    HTMLString.append("<td style=\"text-align:center;text-transform:lowercase;border:1px solid #cccccc\">");
                    HTMLString.append(options[1]);  //必选
                    HTMLString.append("</td>");

                    HTMLString.append("<td style=\"text-align:left;padding-left:5px;border:1px solid #cccccc\">");
                    HTMLString.append(options[2]);  //类型
                    HTMLString.append("</td>");

                    HTMLString.append("<td style=\"text-align:left;padding-left:5px;border:1px solid #cccccc\">");
                    HTMLString.append(options[3]);  //说明
                    HTMLString.append("</td>");

                    HTMLString.append("</tr>");
                }
                HTMLString.append("</tbody> </table>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\">返回结果</span> </h2>");
                HTMLString.append("<div class=\"code_type\" style=\"text-transform:uppercase;margin-bottom:5px;\">JSON示例</div>");
                HTMLString.append("<pre>" + docMethod(methods[j], METHOD_RETURNJSON) + "</pre>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\">返回字段说明</span> </h2>");
                HTMLString.append("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"parameters\" style=\"border-color: #CCCCCC;\"> <tbody>");
                HTMLString.append("<tr> <th width=\"25%\" style=\"text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc\">返回值字段</th> <th width=\"15%\" style=\"text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc\">字段类型</th> <th width=\"60%\" style=\"text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc\">字段说明</th> </tr>");
                ArrayList<String> returnparams = docMethodList(methods[j], METHOD_RETURNPARAM);//list中每一项对应一个返回参数的数据
                for (int k=0; k<returnparams.size();k++)
                {

                    String returnparam = returnparams.get(k);   //获取每一个参数数据
                    System.out.println(returnparam);
                    String[] options = returnparam.split("~");    //拆分需要的数据
                    HTMLString.append("<tr>");

                    HTMLString.append("<td style=\"text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc\">");
                    HTMLString.append(options[0]);  //名称

                    HTMLString.append("</td>");

                    HTMLString.append("<td style=\"text-align:left;padding-left:5px;text-transform:lowercase;border:1px solid #cccccc\">");
                    HTMLString.append(options[1]);  //类型
                    HTMLString.append("</td>");

                    HTMLString.append("<td style=\"text-align:left;padding-left:5px;border:1px solid #cccccc\">");
                    HTMLString.append(options[2]);  //说明
                    HTMLString.append("</td>");

                    HTMLString.append("</tr>");
                }
                HTMLString.append("</tbody> </table>");

                HTMLString.append("<h2 class=\"wiki_title\"> <span class=\"mw-headline\" >注意事项</span> </h2>");
                String notice = docMethod(methods[j], METHOD_NOTICE);
                if (notice != null && "".equals(notice))
                {
                    HTMLString.append("<p>" + notice + "</p>");
                }else {
                    HTMLString.append("<p>无</p>");
                }

                HTMLString.append("</body> </html>");
//                System.out.println(HTMLString.toString());

                //每个方法对应的html文件
                StringBuffer filenamepath = new StringBuffer();
                filenamepath.append(destdirname.toString());
                filenamepath.append("/");
                filenamepath.append(methods[j].name());
                filenamepath.append(".html");

                //每个方法对应的java文件
                StringBuffer javapath = new StringBuffer();
                javapath.append(destdirname.toString());
                javapath.append("/");
                javapath.append(methods[j].name());
                javapath.append(".java");

//                System.out.println(filenamepath.toString());
                StringBuffer javacode = new StringBuffer();
                javacode.append(packagename1);
                javacode.append("\n");
                javacode.append(importname1);
                javacode.append("\n");
                javacode.append(methodname1);
                javacode.append("\n");
                javacode.append(apipath);
                javacode.append("\n");
                javacode.append(paramstring.toString());
                javacode.append("\n");
                javacode.append(construct1);
                javacode.append("\n");
                javacode.append(construct2);
                javacode.append("\n");
                javacode.append(getresponsecalss1);
                javacode.append("\n");
                javacode.append(GetApiPath);
                javacode.append("\n");
                String getparameters1 = GetParameters.replaceAll("mapOperation",parammap.toString());
                javacode.append(getparameters1);
                javacode.append("\n");
                javacode.append("}");

                //输出html文件
//                System.out.println(filenamepath.toString());
                File writefile = new File(filenamepath.toString());
                write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writefile),"UTF-8"));
                write.write(HTMLString.toString());
                write.flush();
                //输出java文件
                File javafile = new File(javapath.toString());
                write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(javafile),"UTF-8"));
                write.write(javacode.toString());
                write.flush();
            }

            String readstring = readdiv.toString().replaceAll("readnum",String.valueOf(readnum));
            String writestring = writediv.toString().replaceAll("writenum",String.valueOf(writenum));

            StringBuffer indexnamepath = new StringBuffer();
            indexnamepath.append(DIRPATH);
            indexnamepath.append(class_uri);
            indexnamepath.append(".html");
            File indexfile = new File(indexnamepath.toString());
            write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexfile),"UTF-8"));
//            System.out.println(classitem+readstring + writestring+"</table>");
            write.write(classitem+readstring + writestring+"</table>");
            write.flush();
        }
        if (write != null)
            write.close();


    }

    public static int optionLength(String option) {
        // Construct temporary configuration for check
        return (ConfigurationImpl.getInstance()).optionLength(option);
    }

    public static boolean validOptions(String options[][], DocErrorReporter reporter) {
        // Construct temporary configuration for check
        return (ConfigurationImpl.getInstance()).validOptions(options, reporter);
    }


}
