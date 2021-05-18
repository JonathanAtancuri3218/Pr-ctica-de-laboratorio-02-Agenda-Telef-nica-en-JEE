<%-- 
    Document   : My agenda
    Created on : 14/05/2021
    Author     : Jonathan Atancuri
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap 4 Website Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>
<c:set var = "userId" value = "${sessionScope['userID']}" />

<div class="bg-primary text-white">
	<div class="jumbotron text-center bg-secondary text-white" style="margin-bottom: 0">
		<h1>AGENDA TELEFONICA</h1>
		<p>Bienvenidos a Nuestro Sistema de Agenda Telefonica</p>
	</div>


	<!-- Search form -->
	<form class="d-flex input-group w-auto" action="busqueda">
		<input type="search" class="form-control"
			placeholder="Buscar Ahora..." name="usuario"aria-label="Search" />
		<button class="btn btn-success"  type="submit"
			data-mdb-ripple-color="dark">Search</button>
	</form>
	
	
	
	
	

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/Ejemplo-Agenda/">Inicio</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="login">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="registro">Crear Cuenta</a>
				</li>
				
				
				
				<li>
				<c:choose>
                        <c:when test="${userId == null}">
                            
                        </c:when>    
                        <c:otherwise>
                        
                        <li class="nav-item"><a class="nav-link"
					href="my-agenda">Mi perfil</a>
				</li>
                        
                        
                      
                        </c:otherwise>
                    </c:choose>
                    
                    
                 </li>
				
			</ul>
		</div>
	</nav>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<h2>Mi Agenda</h2>
				
				 
				
				<img src="https://images-na.ssl-images-amazon.com/images/I/41F0230hwpL._SX348_BO1,204,203,200_.jpg">
				<p>Mi agenda telefonica: Un sistema que permite guardar los datos de todos tus contactos con sus diferentes operadoras.</p>
				
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<h2>Operadora MOVISTAR Ecuador</h2>
				<img src="https://revistaatrevete.files.wordpress.com/2016/04/movistar.jpg" width="600"
     height="500">
				
				<p>Movistar ​​ es una empresa de telecomunicaciones filial de Telefónica. </p>
				<br>
				<h2>Operadora CLARO Ecuador</h2>
				<img src="https://www.larepublica.ec/wp-content/uploads/2015/04/claro-4g-e1428530740945.gif" width="600"
     height="500">
				<p>En Mi Claro podrás realizar consultas y transacciones sobre los servicios móviles y/o fijos que tengas activos.</p>
				
					<br>
				<h2>Operadora TUENTI Ecuador</h2>
				<img src="https://c50cashrewards.files.wordpress.com/2015/08/recargame-tuenti.jpg" width="600"
     height="500">
				<p>Bienvenido al grupo más bacan! Descarga App Tuenti para manejar todos los detalles de tu cuenta </p>
				
			</div>
		</div>
	</div>
</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<footer class="bg-dark text-center text-white">
  <!-- Grid container -->
  <div class="container p-4 pb-0">
    <!-- Section: Form -->
    <section class="">
      <form action="">
        <!--Grid row-->
        <div class="row d-flex justify-content-center">
          <!--Grid column-->
          <div class="col-auto">
            <p class="pt-2">
              <strong>Comuniquese con nosotros</strong>
            </p>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-md-5 col-12">
            <!-- Email input -->
            <div class="form-outline form-white mb-4">
              <input type="email" id="form5Example2" class="form-control" />
              <label class="form-label" for="form5Example2">Email address</label>
            </div>
          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-auto">
            <!-- Submit button -->
            <button type="submit" class="btn btn-outline-light mb-4">
              Subscribe
            </button>
          </div>
          <!--Grid column-->
        </div>
        <!--Grid row-->
      </form>
    </section>
    <!-- Section: Form -->
  </div>
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    UPS_ATANCURI_CHUQUI© 2021 Copyright:
    <a class="text-white" href="https://mdbootstrap.com/">miagenda.com</a>
    <a href="tel:+593996874100">Contactanos</a>
  </div>
  <!-- Copyright -->
</footer>
	</div>

</body>
</html>