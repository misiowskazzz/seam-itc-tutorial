<#-- @ftlvariable name="content" type="java.lang.String" -->
<#-- @ftlvariable name="date" type="java.util.Date" -->
<#-- @ftlvariable name="currentUser" type="pl.itcrowd.seam.tutorial.itc.view.EmailMsg" -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<p align="right">This is mail sent on ${date?string("yyyy-MM-dd")} </p>
Hi
<br/><br/>
<hr/>
${content}
<hr/>
<img src="${mailContext.insert("footer-logo.png")}" align="middle"/>
</body>
</html>
