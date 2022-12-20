<template>  
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Carrito de Compras</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02"
          aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor02">
          <ul class="navbar-nav me-auto">

            <!-- Parámetros -->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                aria-expanded="false">Sucursales</a>
              <div class="dropdown-menu">
                <router-link class="dropdown-item" to="/parametro-departamento">Registro Departamentos</router-link>
                <router-link class="dropdown-item" to="/parametro-ciudad">Registro Ciudades</router-link>
              </div>
            </li>

            <!-- <div class="dropdown-divider"></div> -->
            <!-- Seguridad -->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                aria-expanded="false">Personal</a>
              <div class="dropdown-menu">
                <router-link class="dropdown-item" to="/seguridad-persona">Registro Personas</router-link>
                <router-link class="dropdown-item" to="/seguridad-usuario">Registro Usuarios</router-link>
              </div>
            </li>

            <!-- <div class="dropdown-divider"></div> -->
            <!-- Acceso -->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                aria-expanded="false">Access</a>
              <div class="dropdown-menu">
                <router-link class="dropdown-item" to="/acceso-rol">Registro Rol</router-link>
                <router-link class="dropdown-item" to="/acceso-permiso">Registro Permisos</router-link>
                <router-link class="dropdown-item" to="/acceso-rolUser">Registro Rol-Usuario</router-link>
                <router-link class="dropdown-item" to="/acceso-rolPermiso">Registro Rol-Permisos</router-link>
              </div>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-sm-2" type="search" placeholder="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            &nbsp;
            <button type="button" class="btn btn-primary" onclick="CerrarSesion();">Salir</button>
          </form>
        </div>
      </div>
    </nav>
  </div>
  <router-view />
</template>

<style>
body {
  margin-top: 2%;
}
</style>
