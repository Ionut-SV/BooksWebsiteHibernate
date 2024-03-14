
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autori</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeAutor").hide();
                $("#modificaAutori").hide();

                $("#update").click(function () {
                    $("#modificaAutori").show();
                    $("#stergeAutor").hide();
                });
                $("#delete").click(function () {
                    $("#stergeAutor").show();
                    $("#modificaAutori").hide();
                });
            });
        </script>
		<link href="css/tabelaAutori.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div>
    	<hr>
    	<hr>
        <h1 align="center">Tabela Autori:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>IdAutor:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Varsta:</b></td>
                <td><b>Gen:</b></td>
            </tr>
            <c:forEach var="autori" items="${listaAutori}">
                <tr>
                    <td>${autori.idautor}</td>
                    <td>${autori.nume}</td>
                    <td>${autori.prenume}</td>
                    <td>${autori.varsta}</td>
					<td>${autori.gen}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="AutoriController" method="POST">
            <p align="center">
                 Modifica: <input type="radio" id="update" name="modifica_sterge"onclick="document.getElementById('nume').disabled = false;
            		document.getElementById('prenume').disabled = false;
		            document.getElementById('varsta').disabled = false;
		            document.getElementById('gen').disabled = false;">
		         Sterge: <input type="radio" id="delete" 
		            name="modifica_sterge" onclick="document.getElementById('nume').disabled = true;
		            document.getElementById('prenume').disabled = true;
		            document.getElementById('varsta').disabled = true;
		            document.getElementById('gen').disabled = true;"><br><br>
               
                <select name="idautor">
                    <c:forEach items="${listaAutori}" var="autori">
                        <option value="${autori.idautor}">${autori.idautor}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica Nume: <input id="nume" type="text" name="nume"><br><br>
                Modifica Prenume: <input id="prenume" type="text" name="prenume"> <br><br>
                Modifica Varsta: <input id="varsta" type="number" name="varsta"> <br><br>
                Modifica Gen: <input id="gen" type="text" name="gen"> <br><br>
                <button type="submit" id="modificaAutori" name="modificaAutori"> Modifica</button> <br> <br>
                <button type="submit" id="stergeAutori" name="stergeAutori"> Sterge </button>
            </p>
        </form>
         	<div align="center">
	        <table>
				<tr>
					<td><form action="adauga_Autor.jsp" method="POST">
	            		<p align="center"><input type="submit" value="Adauga autor"> &nbsp;<br>
	        			</p></form>
	        		</td>
	        		<td><form action="index.html" method="POST">
	            		<p align="center"><input type="submit" value="Home"> &nbsp; <br>
	        			</p></form>
	        		</td>
				</tr>
			</table>
	        </div>
	        <hr>
	        <hr>
    </div>
    </body>
</html>
