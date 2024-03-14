
<%@page import="DAOImpl.CartiDaoImpl"%>
<%@page import="DAOImpl.AutoriDaoImpl"%>
<%@page import="pojo.carti"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.autori"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editura</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeEdituri").hide();
                $("#modificaEdituri").hide();

                $("#update").click(function () {
                    $("#modificaEdituri").show();
                    $("#stergeEdituri").hide();
                });
                $("#delete").click(function () {
                    $("#stergeEdituri").show();
                    $("#modificaEdituri").hide();
                });
            });
        </script>
		<link href="css/tabelaEdituri.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div>
    	<hr>
    	<hr>
        <%
            AutoriDaoImpl autorDaoImpl = new AutoriDaoImpl();
            CartiDaoImpl carteDaoImpl = new CartiDaoImpl();
            List<autori> listaAutori = new ArrayList();
            listaAutori = autorDaoImpl.afiseazaAutori();
            List<carti> listaCarti = new ArrayList();
            listaCarti = carteDaoImpl.afiseazaCarti();
            request.setAttribute("listaAutori", listaAutori);
            request.setAttribute("listaCarti", listaCarti);
        %>
        
        <h1 align="center"> Tabela Edituri:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>ideditura:</b></td>
                <td><b>idautor:</b></td>
                <td><b>nume:</b></td>
                <td><b>orenume:</b></td>
                <td><b>varsta:</b></td>
                <td><b>gen:</b></td>
                <td><b>idcarte:</b></td>
                <td><b>titlu:</b></td>
                <td><b>categorie:</b></td>
                <td><b>rating:</b></td>
                <td><b>nume_editura:</b></td>
                <td><b>data_publicarii:</b></td>
                <td><b>copii_vandute:</b></td>
                <td><b>tara:</b></td>
            </tr>
            <c:forEach var="edituri" items="${listaEdituri}">
                <tr>
                    <td>${edituri.ideditura}</td>
                    <td>${edituri.autori.idautor}</td>
                    <td>${edituri.autori.nume}</td>
                    <td>${edituri.autori.prenume}</td>
                    <td>${edituri.autori.varsta}</td>
                    <td>${edituri.autori.gen}</td>
                    <td>${edituri.carti.idcarte}</td>
                    <td>${edituri.carti.titlu}</td>
                    <td>${edituri.carti.categorie}</td>
                    <td>${edituri.carti.rating}</td>
                    <td>${edituri.nume_editura}</td>
                    <td>${edituri.data_publicarii}</td>
                    <td>${edituri.copii_vandute}</td>
                    <td>${edituri.tara}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="EdituriController" method="POST">
            <div align="center">
                Modifica: <input type="radio" id="update" name="modifica_sterge" onclick="document.getElementById('nume_editura').disabled = false;
                	document.getElementById('idautor').disabled = false;
            		document.getElementById('idcarte').disabled = false;
            		document.getElementById('data_publicarii').disabled = false;
            		document.getElementById('copii_vandute').disabled = false;
            		document.getElementById('tara').disabled = false;">
            	
            	Sterge: <input type="radio" id="delete" name="modifica_sterge" onclick="document.getElementById('nume_editura').disabled = true;
            		document.getElementById('idautor').disabled = true;
            		document.getElementById('idcarte').disabled = true;
            		document.getElementById('data_publicarii').disabled = true;
            		document.getElementById('copii_vandute').disabled = true;
            		document.getElementById('tara').disabled = true;"><br><br>
                
                ideditura:
                <select name="ideditura">
                    <c:forEach items="${listaEdituri}" var="edituri">
                        <option value="${edituri.ideditura}">${edituri.ideditura}</option>
                    </c:forEach>
                 </select>
                <br><br>
                <table>
            		<tr>
            			<td align="right"> Idautor:</td>
            			<td> <select name="idautor" id="idautor">
                    			<c:forEach items="${listaAutori}" var="autori">
                        			<option value="${autori.idautor}">${autori.idautor}, ${autori.nume}, ${autori.prenume} ${idautor.varsta}, ${idautor.gen}</option>
                    			</c:forEach>
                			</select>
                		</td>
            		</tr>
            		<tr>
            			<td align="right"> Idcarte:</td>
            			<td> <select name="idcarte" id="idcarte">
                    			<c:forEach items="${listaCarti}" var="carti">
                        			<option value="${carti.idcarte}">${carti.idcarte}, ${carti.titlu}, ${carti.categorie}, ${carti.rating}</option>
                    			</c:forEach>
                			</select>
                		</td>
            		</tr>
            		<tr>
            			<td align="center">Modifica Nume Editura:</td>
            			<td> <input id="nume_editura" type="text" name="nume_editura" required="required"></td>
            		</tr>
            		<tr>
                		<td align="right">Modifica Data Publicarii:</td>
                		<td><input id="data_publicarii" type="text" name="data_publicarii" required="required"></td>
                	</tr>
                	<tr>
                		<td align="right">Modifica Copii Vandute:</td>
                		<td><input id="copii_vandute" type="number"  name="copii_vandute" required="required"></td>
                	</tr>
                	<tr>
                		<td align="right">Modifica Tara:</td>
                		<td><input id="tara" type="text" name="tara" required="required"></td>
                	</tr>
            	</table>
            	<br/>
                <button type="submit" id="modificaEdituri" name="modificaEdituri"> Modifica</button>
                <button type="submit" id="stergeEdituri" name="stergeEdituri"> Sterge </button>
                <br/>
            </div>
        </form>
        <div align="center">
	        <table>
				<tr>
					<td><form action="adauga_Editura.jsp" method="POST">
	            		<p align="center"><input type="submit" value="AdaugaEdituri"> &nbsp;<br>
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
