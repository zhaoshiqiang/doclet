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
<#list divlist as div>
    ${div.content}
</#list>

</html>