<%@page import="manejador.ManejadorWeb"%>
<%@page import="model.Dia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>AEMET</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
	<%
	ManejadorWeb manejador = new ManejadorWeb("https://www.aemet.es/xml/municipios/localidad_45168.xml");
	ArrayList<Dia> dias = manejador.parsear();
	%>
    <div class="container shadow">
        <div class="row">
        	<%
        		for (Dia dia:dias){%>
		        	<div class="col-md-6">
		                <div class="card">
		                    <div class="row">
		                        <div class="col-4"><img src="https://www.aemet.es/imagenes/png/estado_cielo/<%=dia.getIcono() %>_g.png" class="card-img-top" alt="..."></div>
		                        <div class="col-8">
		                            <div class="card-body">
		                                <h5 class="card-title"><%=dia.getFecha() %></h5>
		                                <h6 class="card-subtitle mb-2 text-muted "><%=dia.getProno() %></h6>
		                                <p class="card-text">Max: <%=dia.getMax() %>� Min: <%=dia.getMin() %>�</p>
		                                <p class="card-text">Probalidad de Precipitaci�n: <%=dia.getPreci()%> %</p>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
        		<%}
        	%>
           
        </div>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
        </script>
</body>

</html>