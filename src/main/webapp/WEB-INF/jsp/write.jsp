<%--
  Created by IntelliJ IDEA.
  User: 12505
  Date: 2022/7/13
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE HTML>

<html>
<head>
    <title>Write Blog</title>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <script>
        tinymce.init({
            selector: 'textarea#mytextarea'
        });
    </script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Write a Blog</h1>
        <p>Have a happy nice day!</p>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="home">Homepage</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/write">Write Blog</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>
        </div>
    </nav>

    <form action="home" method="post">
        <label>Please input your title:<br></label>
        <br>
        <input id="title" type="text" name="title"  style="width:800px;"/>
        <textarea id="mytextarea" class="text" name="mytextarea">Hello, World!</textarea>
         <input id="submitbutton" type="submit" value="Submit" />
    </form>
    <!--
    <form method="post">
        <label>Please input your title:<br></label>
        <br>
        <input id="title" type="text" name="title"  style="width:800px;"/>
        <br>
        <div id="myeditablediv">Click here to edit!</div>
        <input id="submitbutton" type="submit" value="Submit" />
    </form>
    -->

    <script>
        let cur=document.getElementById("submitbutton").innerHTML;

    </script>

</body>
</html>
