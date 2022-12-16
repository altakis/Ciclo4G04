<template>
    <div class="container">
        <form id="person">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de Ciudades</p>
                </div>
                <!-- Datos de entarada del formulario -->
                <div class="form-group">
                    <input type="hidden" id="id">

                    <label class="form-label mt-1">Tipo Documento</label>
                    <select class="form-select" id="tipoDocumento">
                        <option disabled selected='true' >-- Seleccione --</option>
                        <option value="CC">CC</option>
                        <option value="TI">TI</option>
                        <option value="CE">CE</option>
                    </select>

                    <label class="form-label mt-1">Documento</label>
                    <input type="text" class="form-control" id="documento" placeholder="Ingresar código">

                    <label class="form-label mt-1">Priemr Nombre</label>
                    <input type="text" class="form-control" id="primerNombre" placeholder="Ingresar código">

                    <label class="form-label mt-1">Segundo Nombre</label>
                    <input type="text" class="form-control" id="segundoNombre" placeholder="Ingresar código">

                    <label class="form-label mt-1">Primer Apellido</label>
                    <input type="text" class="form-control" id="primerApellido" placeholder="Ingresar código">

                    <label class="form-label mt-1">Segundo Apellido</label>
                    <input type="text" class="form-control" id="segundoApellido" placeholder="Ingresar código">

                    <label class="form-label mt-1">Correo</label>
                    <input type="text" class="form-control" id="correo" placeholder="Ingresar código">

                    <label class="form-label mt-1">Teléfono</label>
                    <input type="text" class="form-control" id="telefono" placeholder="Ingresar código">

                    <label class="form-label mt-1">Fecha Nacimiento</label>
                    <input type="date" class="form-control" id="correo" placeholder="Ingresar fecha nacimmiento">

                    <label class="form-label mt-1">Dirección</label>
                    <input type="text" class="form-control" id="direccion" placeholder="Ingresar dirección">

                    <label class="form-label mt-1">Usuario</label>
                    <select class="form-select" id="usuarioId"></select>

                    <label class="form-label mt-1">Ciudad</label>
                    <select class="form-select" id="ciudadId"></select>

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
                        <td>Tipo Documento</td>
                        <td>Documento</td>
                        <td>Primer Nombre</td>
                        <td>Segundo Nombre</td>
                        <td>Primer Apellido</td>
                        <td>Segundo Apellido</td>
                        <td>Correo</td>
                        <td>Teléfono</td>
                        <td>Fecha Nacimiento</td>
                        <td>Dirección</td>
                        <td>Usuario</td>
                        <td>Ciudad</td>
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