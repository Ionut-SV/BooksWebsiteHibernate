
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carti</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeCarti").hide();
                $("#modificaCarti").hide();

                $("#update").click(function () {
                    $("#modificaCarti").show();
                    $("#stergeCarti").hide();
                });
                $("#delete").click(function () {
                    $("#stergeCartie").show();
                    $("#modificaCarti").hide();
                });
            });
        </script>
		<link href="css/tabelaCarti.css" rel="stylesheet" type="text/css">
    </head>
    <body>
   	<div>
   		<hr>
    	<hr>
        <h1 align="center"> Tabela Carti:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>IdCarte:</b></td>
                <td><b>Titlu:</b></td>
                <td><b>Categorie:</b></td>
                <td><b>Rating:</b></td>
            </tr>
            <c:forEach var="carti" items="${listaCarti}">
                <tr>
                    <td>${carti.idcarte}</td>
                    <td>${carti.titlu}</td>
                    <td>${carti.categorie}</td>
                    <td>${carti.rating}</td>

                </tr>
            </c:forEach>
        </table>
        <form action="CartiController" method="POST">
             <p align="center">
                Modifica: <input type="radio" id="update" name="modifica_sterge"onclick="document.getElementById('titlu').disabled = false;
            		document.getElementById('categorie').disabled = false;
		            document.getElementById('rating').disabled = false;">
		        Sterge: <input type="radio" id="delete" 
		            name="modifica_sterge" onclick="document.getElementById('titlu').disabled = true;
		            document.getElementById('categorie').disabled = true;
		            document.getElementById('rating').disabled = true;">
		        <br><br>
                <select name="idcarte">
                    <c:forEach items="${listaCarti}" var="carti">
                        <option value="${carti.idcarte}">${carti.idcarte}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica Titlu: <input id="titlu" type="text" name="titlu" required="required"><br><br>
                Modifica Categorie:<input id="categorie" type="text" name="categorie" required="required"><br><br>
                Modifica Rating:<input id="rating" type="text" name="rating" required="required"><br><br>
                <button type="submit" id="modificaCarti" name="modificaCarti"> Modifica</button>
                <button type="submit" id="stergeCarti" name="stergeCarti"> Sterge </button>
                <br/>
            </p>
        </form>
        <div align="center">
	        <table>
				<tr>
					<td><form action="adauga_Carte.jsp" method="POST">
	            		<p align="center"><input type="submit" value="Adauga carte"> &nbsp;<br>
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
