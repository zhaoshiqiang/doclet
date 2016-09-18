<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<html>
<title>匠才汇接口文档</title>
<style type="text/css">
    body{font: 12px/1.125 Arial, Helvetica, sans-serif;}
    .custom{
        border-collapse:collapse;
        border:gray;
        width: 100%;
        display: table;
        text-align: left;
        margin-bottom: 20px;
    }
    .custom .tbF1{width: 116px;}
    .custom .tbF2{width: 218px;}
    .custom th{
        padding: 12px 0;
        background: #e9e9e9;
        border: 1px solid #e8eaec;
        padding-left: 10px;
        font-weight: 700;
        font-size: 14px;
        text-align: left;
        color: #000;
    }
    .custom td{
        background: #fff;
        padding-left: 10px;
        padding: 7px 10px;
        line-height: 20px;
        border: 1px solid #e8eaec;
    }
    .custom pre{overflow: hidden;}
    a{
        text-decoration: none;
        color: #3c7cb3;
    }
    a:hover{text-decoration: underline;}
</style>

<#list classes as classitem>
<div>
    <table class = "custom">
        <colgroup><col class = "tbF1"><col class = "tbF2"><col></colgroup>
        <tr>
            <th colspan="3"><#list classitem.description as a>${a}</#list></th>
        </tr>
		<#assign classuri><#list classitem.uri as a>${a}</#list></#assign>
        <#assign readnum = 0/>
        <#assign writenum = 0/>
		<#list classitem.methods as method>
            <#assign type><#list method.type as a>${a}</#list></#assign>
		    <#if type == "read">
                <#assign readnum = readnum+1>
                <#if readnum == 1>
                    <tr>
                        <td id="read${classitem_index}">读取接口</td>
                        <td><a href="<#list method.html as a>${a}</#list>"><#list method.uri as a>${classuri+"/"+a}</#list></a></td>
                        <td><#list method.path as a>${a}</#list></td>
                    </tr>
                <#else>
                    <tr>
                        <td><a href="<#list method.html as a>${a}</#list>"><#list method.uri as a>${classuri+"/"+a}</#list></a></td>
                        <td><#list method.path as a>${a}</#list></td>
                    </tr>
                </#if>
            </#if>
        </#list>
        <#list classitem.methods as method>
            <#assign type><#list method.type as a>${a}</#list></#assign>
            <#if type == "write">
                <#assign writenum = writenum+1>
                <#if writenum == 1>
                    <tr>
                        <td id="write${classitem_index}">写入接口</td>
                        <td><a href="<#list method.html as a>${a}</#list>"><#list method.uri as a>${classuri+"/"+a}</#list></a></td>
                        <td><#list method.path as a>${a}</#list></td>
                    </tr>
                <#else>
                    <tr>
                        <td><a href="<#list method.html as a>${a}</#list>"><#list method.uri as a>${classuri+"/"+a}</#list></a></td>
                        <td><#list method.path as a>${a}</#list></td>
                    </tr>
                </#if>
		    </#if>
        </#list>
        <input id="readnum${classitem_index}" hidden="hidden" value="${readnum}">
        <input id="writenum${classitem_index}" hidden="hidden" value="${writenum}">
    </table>
</div>
</#list>
<script>
    for(var i=0 ; i < ${classes?size} ; i++ )
    {
        var read = document.getElementById("read"+i);
        if(read){
            var readnum = document.getElementById("readnum"+i);
            read.setAttribute("rowspan",readnum.value);
        }
        var write = document.getElementById("write"+i);
        if(write){
            var writenum = document.getElementById("writenum"+i);
            write.setAttribute("rowspan",writenum.value);
        }

    }
    var alist = document.getElementsByTagName("a");
    var date = new Date();
    for(var j=0 ; j < alist.length ; j++ ){
        alist[j].setAttribute("href",alist[j].getAttribute("href")+ "?" + date.getTime());
    }
</script>
</html>