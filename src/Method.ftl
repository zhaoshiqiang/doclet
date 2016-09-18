<!DOCTYPE html>
<html>
<meta charset=utf8>
<head>
    <title></title>
</head>
<style type="text/css">
    body{
        font: 12px/1.125 Arial, Helvetica, sans-serif;
    }

    .wiki_title{
        line-height: 37px;
        border-bottom: 1px solid #e5e5e5;
        margin: 16px 0 8px 0;
        font-size: 20px;
        color: #333;
        font-family: "Microsoft Yahei";
        font-weight: 300;
    }

    h1.wiki_title{
        font-size: 24px;
    }

    a{
        color: #3c7cb3;
        text-decoration: none;
    }

    table{
        border-collapse: collapse;
        border-spacing: 0;
    }

    table.parameters{
        border-top-width: 1px;
        border-right-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        -webkit-border-horizontal-spacing: 0px;
        -webkit-border-vertical-spacing: 0px;
        width: 100%;
    }

    th,td{
        text-align: center;
        font-weight: bolder;
        border: 1px solid #cccccc;
        height: 20px;
    }

    .code_type{
        text-transform: uppercase;
        margin-bottom: 5px;
        display: inline-block;*
    display: inline;*
    zoom: 1;
        background: #b4e3b4;
        border-radius: 2px;
        color: #008200;
        padding: 2px 8px;
    }
    a:hover{
        text-decoration: underline;
    }
</style>
<body>
<h1 class="wiki_title">
    <span class="mw-headline">${uri}</span>
</h1>
<p>${describe}</p>
<h2 class="wiki_title">
    <span class="mw-headline">URL</span>
</h2>
<p>
        <span style="font-weight:600">
            <a rel="nofollow" class="external free" href="">${uri}</a>
        </span>
</p>
<h2 class="wiki_title">
    <span class="mw-headline" >支持格式</span>
</h2>
<p>
    <span style="text-transform:uppercase;font-weight:600">${support!"JSON"}</span>
</p>

<h2 class="wiki_title">
    <span class="mw-headline" >HTTP请求方式</span>
</h2>
<p>
    <span style="text-transform:uppercase;font-weight:600">${requesttype!"POST"}</span>
</p>

<h2 class="wiki_title">
    <span class="mw-headline" >请求参数</span>
</h2>

<table border="1" cellspacing="0" cellpadding="0" width="100%" class="parameters" style="border-color: #CCCCCC;">

    <tbody>
    <tr>
        <th width="10%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">名称</th>
        <th width="5%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">必选</th>
        <th width="10%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">类型及范围</th>
        <th width="75%" style="text-align:center;font-weight:bolder;border:1px solid #cccccc">说明</th>
    </tr>
    <#list param as item>
    <tr>
        <td style="text-align:center;font-weight:bolder;border:1px solid #cccccc">${item.name}</td>
        <td style="text-align:center;border:1px solid #cccccc">${item.select}</td>
        <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">${item.type}</td>
        <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">${item.explain}</td>
    </tr>
    </#list>

    </tbody>
</table>

<h2 class="wiki_title">
    <span class="mw-headline">返回结果</span>
</h2>

<div class="code_type" style="text-transform:uppercase;margin-bottom:5px;">JSON示例</div>
    <pre>
    ${returnjson}
    </pre>

<h2 class="wiki_title">
    <span class="mw-headline">返回字段说明</span>
</h2>

<table border="1" cellspacing="0" cellpadding="0" width="100%" class="parameters" style="border-color: #CCCCCC;">

    <tbody>
    <tr>
        <th width="25%" style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">返回值字段</th>
        <th width="15%" style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">字段类型</th>
        <th width="60%" style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">字段说明</th>
    </tr>

    <#list returnparam as item>
    <tr>
        <td style="text-align:left;padding-left:5px;font-weight:bolder;border:1px solid #cccccc">${item.name}</td>
        <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">${item.type}</td>
        <td style="text-align:left;padding-left:5px;border:1px solid #cccccc">${item.explain}</td>
    </tr>
    </#list>
    </tbody>
</table>

<h2 class="wiki_title">
    <span class="mw-headline" >注意事项</span>
</h2>

<p>${notice!"无"}</p>
</body>
</html>