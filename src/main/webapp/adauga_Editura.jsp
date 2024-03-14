<%@page import="DAOImpl.AutoriDaoImpl"%>
<%@page import="DAOImpl.CartiDaoImpl"%>
<%@page import="pojo.autori"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.carti"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editura</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Autor</title>
        <link href="css/adauga.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div>
    	<hr>
    	<hr>
<%
		AutoriDaoImpl autorDaoImpl = new AutoriDaoImpl();
		CartiDaoImpl carteDaoImpl = new CartiDaoImpl();
        List<carti> listaCarti = new ArrayList();
        listaCarti = carteDaoImpl.afiseazaCarti();
        List<autori> listaAutori = new ArrayList();
        listaAutori = autorDaoImpl.afiseazaAutori();
        request.setAttribute("listaCarti", listaCarti);
        request.setAttribute("listaAutori", listaAutori);
%>
        <div align="center" id="add">
            <h1> Adauga Editura:</h1>
            <br/>
            <form action="EdituriController" method="GET">
                <table>
                    <tr>
                        <td> Autor: </td>
                        <td>
                            <select name="idautor">
                                <c:forEach items="${listaAutori}" var="autori">
                                    <option value="${autori.idautor}">${autori.idautor}, ${autori.nume}, ${autori.prenume}, ${autori.varsta}, ${autori.gen}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> Carte: </td>
                        <td>
                            <select name="idcarte">
                                <c:forEach items="${listaCarti}" var="carti">
                                    <option value="${carti.idcarte}">${carti.idcarte}, ${carti.titlu}, ${carti.categorie}, ${carti.rating}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> Titlu Editura: </td>
                        <td><input type="text" name="nume_editura" required="required"></td>
                    </tr>
                    <tr>
                        <td> Data Publicarii: </td>
                        <td><input type="text" name="data_publicarii" required="required"></td>
                    </tr>
                    <tr>
                        <td> Copii vandute: </td>
                        <td><input type="text" name="copii_vandute" required="required"></td>
                    </tr>
                    <tr>
                        <td> Tara: </td>
                        <td><input type="text" name="tara" required="required"></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" name="adaugaEdituri" value="Adauga">
            </form>
      </div>
        <div align="center">
	        <table>
				<tr>
					<td><form action="EdituriController" method="POST">
	            		<p align="center"><input type="submit" name="afiseazaEdituri" value="Edituri"> &nbsp;<br>
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