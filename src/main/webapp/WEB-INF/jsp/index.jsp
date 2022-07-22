<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>My Personal Blog-OYHX</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>

<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>My First Blog </h1>
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

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-md-4">
            <h2>About Me</h2>
            <h5>Photo of me:</h5>
            <div class="fakeimg" src="../../../../../../resources/eggman.jpg" >Image</div>
            <!-----test blog content!-->
            <p>this is my first blog</p>
            <h3>Some Links of Tutorials ralated to my project</h3>
            <p>Lorem ipsum dolor sit ame.</p>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="https://www.w3schools.com/bootstrap4/default.asp">Bootstrap 4</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://www.javatpoint.com/spring-mvc-tutorial">Spring MVC</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://spring.io/">Spring.io</a>
                </li>

            </ul>
            <hr class="d-sm-none">
        </div>
        <div class="col-md-7 offset-md-1">

               <c:forEach var="blog" items="${blogs}">
                        <div class="row">

                            <H2>${{blog.title}}<br></H2>
                            <form:form action="delete_blog/" >
                                <input type = "hidden" name = "blog_id" value=${{blog.blog_id}} />
                                <input type="submit" value="Delete" />
                            </form:form>
                        </div>
                            <p><br></p>
                        <div class="row">
                            ${{blog.content}}

                        </div>
                        <div>
                            <p>
                                Copyright prophet12505,20220721
                            </p>
                        </div>


                </c:forEach>

        </div>



    </div>

</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>

</body>
</html>