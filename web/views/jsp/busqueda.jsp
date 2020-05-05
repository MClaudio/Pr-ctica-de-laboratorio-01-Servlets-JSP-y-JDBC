<%-- 
    Document   : busqueda
    Created on : 04-may-2020, 22:01:03
    Author     : claum
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/e564244708.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="public/css/styles.css">
    </head>
    <body>
        <c:set var = "users" value = "${requestScope['users']}" />
        <div class="ui container">
            <div class="ui secondary  menu">
                <div class="item logo">
                    <a href="/Practica-de-laboratorio-01"><h2><span>Book</span>Contact</h2></a>
                </div>

                <div class="right menu">
                    <div class="item">
                        <form action="busqueda">
                            <div class="ui left icon action input">
                                <i class="users icon"></i>
                                <input type="text" placeholder="Buscar..." name="usuario">
                                <input type="submit" class="ui blue submit button" value="Buscar">
                            </div>
                        </form>
                    </div>

                    <div class="item">
                        <a href="registro" class="ui primary button">Registro</a>
                    </div>
                    <div class="item">
                        <a href="login" class="ui button">Iniciar Sesion</a> 
                    </div>
                </div>
            </div>
        </div>

        <div class="ui container">
            <c:choose>
                <c:when test="${users.size() > 0}">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Contactos</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Numero de telefono</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="i" value = "${0}"/>
                            <c:forEach var="user" items="${users}">
                                <c:set var="i" value = "${i+1}"/>
                                <tr data-toggle="modal" data-target="#exampleModal${i}" data-whatever="@mdo">
                                    <td>
                                        <div class="ui middle aligned selection list">
                                            <div class="item">
                                                <img class="ui avatar image" src="public/img/img.png">
                                                <div class="content">
                                                    <div class="header">${user.nombre} ${user.nombre}</div>
                                                </div>
                                            </div>

                                    </td>
                                    <td>${user.correo}</td>
                                    <td>${user.telefonos[0].numero}</td>
                                </tr>

                            <div class="modal fade" id="exampleModal${i}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="exampleModalLabel">${user.nombre} ${user.apellido}  
                                                
                                                <a href="mailto:${user.correo}" class="ui small primary labeled icon button mail-user">
                                                    <i class="envelope icon"></i> Enviar correo
                                                </a>

                                            </h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <h5>Detalles de contacto</h5>
                                            <c:forEach var="telefono" items="${user.telefonos}">
                                                <p><i class="phone icon"></i> <a href="tel:${telefono.numero}">${telefono.numero}</a>  &#9679; ${telefono.tipo} &#9679; ${telefono.operadora}</p>

                                            </c:forEach>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>    
                <c:otherwise>
                    <h1>No hay contactos para esta busqueda</h1>
                </c:otherwise>
            </c:choose>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
    </body>
</html>
