<template>
    <div class="container">
        <form id="user">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de Usuarios</p>
                </div>
                <!-- Datos de entarada del formulario -->
                <div class="form-group">
                    <input type="hidden" id="id">

                    <label class="form-label mt-1">Usuario</label>
                    <input type="text" class="form-control" id="usuario" placeholder="Ingresar usuario">

                    <label class="form-label mt-1">Contraseña</label>
                    <input type="password" class="form-control" id="contrasenia" placeholder="Ingresar su contraseña">

                    <label class="form-label mt-1">Estado</label>
                    <select class="form-select" id="estado">
                        <option disabled selected='true' >-- Seleccione --</option>
                        <option value="1">Activo</option>
                        <option value="0">Inactivo</option>
                    </select>
                </div>

                <!-- Botones -->
                <div>
                    <br>
                    <button type="button" class="btn btn-outline-success" onclick="addData()">Agregar</button>
                    &nbsp;
                    <button type="button" class="btn btn-outline-warning" onclick="updateData()">Modificar</button>
                </div>
            </fieldset>
        </form>

        <!-- Registros -->
        <div>
            <br>
            <table class="table table-hover">
                <thead>
                    <tr class="table-active">                        
                        <td>Usuario</td>
                        <td>Contraseña</td>
                        <td>Estado</td>
                        <td>Editar</td>
                        <td>Eliminar</td>
                    </tr>
                </thead>
                <tbody id="dataResult">
                    <!-- Estos datos llegan de la API-->                   
                </tbody>
            </table>
        </div>
    </div>
</template>