
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carti</title>
         <link href="css/adauga.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div id="add"  align="center" >
            <h1> Adauga Carte </h1>
            <form action="CartiController" method="GET">
                <table>
                    <tr>
                        <td> Titlu: </td>
                        <td><input type="text" name="titlu"></td>
                    </tr>
                    <tr>
                        <td> Categorie: </td>
                        <td><input type="text" name="categorie"></td>
                    </tr>
                    <tr>
                        <td> Rating: </td>
                        <td><input type="text" name="rating"></td>
                    </tr>
                    
                </table>
                <br/>
                <input type="submit" name="adaugaCarti" value="Adauga">
            </form>
	        <table>
				<tr>
					<td><form action="CartiController" method="POST">
	            		<p align="center"><input type="submit" name="afiseazaCarti" value="Carti"> &nbsp;<br>
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
</html>
