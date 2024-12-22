<%-- 
    Document   : DangNhap
    Created on : Nov 24, 2024, 1:30:14 PM
    Author     : ngoco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
    <style>
        *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Times New Roman', Times, serif;
}
body{
    background-image: url("images/bg.jpg");
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
}
.wrapper{
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: rgb(0, 0, 0, 0.2);
}
.login_box{
    position: relative;
    width: 450px;
    backdrop-filter: blur(25px);
    border: 2px solid white;
    border-radius: 15px;
    padding: 7.5em 2.5em 4em 2.5em;
    box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.3);
}
.title{
    position: absolute;
    top: 0;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: gray;
    width: 140px;
    height: 70px;
    border-radius: 0 0 20px 20px;
}
.title span{
    font-size: 25px;
    color : black
}
.input{
    position: relative;
    display: flex;
    flex-direction: column;
    margin: 20px 0;
}
.input-field{
    width: 100%;
    height: 55px;
    font-size: 16px;
    background: transparent;
    padding-inline: 20px 50px;
    border-radius: 20px;
    outline: none;
}
#user{
    margin-bottom: 10px;
}
.label{
    position: absolute;
    top: 15px;
    left: 20px;
    transition: .2s;
}
.input-field:focus ~ .label,
.input-field:valid ~ .label{
    position: absolute;
    top: -10px;
    left: 20px;
    font-size: 14px;
    background-color: gray;
    border-radius: 20px;
    padding: 0 10px;
}
.icon{
    position: absolute;
    top: 10px;
    right: 25px;
    font-size: 20px;
    align-items: center;
}
.input-submit{
    width: 100%;
    height: 50px;
    background: white;
    font-size: 16px;
    font-weight: 500;
    border: none;
    border-radius: 25px;
    cursor: pointer;
    transition: .3s;
}
.input-submit:hover{
    background-color: gray;
}
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="login_box">
            <div class="title">
                <span>Login</span>
            </div>
            <form action="DangNhapServlet" method="post">
                <div class="input">
                    <input type="text" id="user" name="username" class="input-field" required>
                    <label for="user" class="label">Username</label>
                    <i class="bx bx-user icon"></i>
                </div>
                <div class="input">
                    <input type="password" id="pass" name="password" class="input-field" required>
                    <label for="pass" class="label">Password</label>
                    <i class="bx bx-lock-alt icon"></i>
                </div>
                <div class="input_box">
                    <input type="submit" class="input-submit" value="Login">
                </div>
            </form>
            <% 
        String errorMessage = (String) request.getAttribute("errorMessage"); 
        if (errorMessage != null) { 
    %>
        <p style="color: red;"><%= errorMessage %></p>
    <% 
        } 
    %>
        </div>
    </div>
    
</body>
</html>
