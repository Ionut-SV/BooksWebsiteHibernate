
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autori</title>
         <link href="css/adauga.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    	<div>
		<hr>
		<hr>

        <div id="add" align="center">
            <h1>Adauga Autor </h1>
            <form action="AutoriController" method="GET">
                <table>
                    <tr>
                        <td>Nume: </td>
                        <td><input type="text" name="nume" required="required"></td>
                    </tr>
                    <tr>
                        <td>Prenume: </td>
                        <td><input type="text" name="prenume" required="required"></td>
                    </tr>
                    <tr>
                        <td>Varsta: </td>
                        <td><input type="number" name="varsta" required="required"></td>
                    <tr>
                        <td>Gen: </td>
                        <td><input type="text" name="gen" required="required"></td>
                    </tr>    
                </table>
                <br/>
                <input type="submit" name="adaugaAutori" value="Adauga">
            </form>
            </div>

        	<div align="center">
	        <table>
				<tr>
					<td><form action="AutoriController" method="POST">
	            		<p align="center"><input type="submit" name="afiseazaAutori" value="Autori"> &nbsp;<br>
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
