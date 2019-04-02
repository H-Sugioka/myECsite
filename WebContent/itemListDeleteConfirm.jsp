<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>ItemListDeleteConfirm</title>

	<style type="text/css">
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana,Helvetica,sans-serif;
		font-size:12px;
		color:#333;
		background:#91B493;
	}

	table{
		text-align:center;
		margin:0 auto;
	}

	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
		background-color:lightgrey;
	}

	#header{
		width:100%;
		height:80px;
		background-color:black;
	}

	#main{
		width:100%;
		height:500px;
		text-align:center;
	}

	#menu{
		width:500px;
		margin:auto;
	}

	#footer{
		width:100%;
		height:80px;
		backgroubd-color:black;
		clear:both;
	}

	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>
	</div>
	<div id=menu>
		<div>
			<a href='<s:url action="ItemListDeleteCompleteAction"/>'>OK</a>
		</div>
		<div>
			<a href='<s:url action="ItemListAction"/>'>キャンセル</a>
		</div>
	</div>
</body>
</html>