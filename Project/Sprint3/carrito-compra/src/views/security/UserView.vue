<template>
    <div class="container">
        <form id="user">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de Usuarios</p>
                </div>
                <!-- Datos de entarada del formulario -->
                <div class="form-group">
                    <input type="hidden" v-model="id">

                    <label class="form-label mt-1">Usuario</label>
                    <input type="text" class="form-control" v-model="usuario" placeholder="Ingresar usuario">

                    <label class="form-label mt-1">Contraseña</label>
                    <input type="password" class="form-control" v-model="contrasenia" placeholder="Ingresar su contraseña">

                    <label class="form-label mt-1">Estado</label>
                    <select class="form-select" v-model="estado">
                        <option disabled selected='true' >-- Seleccione --</option>
                        <option value="1">Activo</option>
                        <option value="0">Inactivo</option>
                    </select>
                </div>

                <!-- Botones -->
                <div>
                    <br>
                    <button type="button" class="btn btn-outline-success" @click="dataAdd()">Agregar</button>
                    &nbsp;
                    <button type="button" class="btn btn-outline-warning" @click="dataUpdate()">Modificar</button>
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
                    <tr v-for="item in listData" :key="item.id">
                        <td>{{ item.usuario }}</td>
                        <td>******</td>
                        <td>{{ item.estado == true ? 'Activo' : 'Inactivo' }}</td>
                        <td><button @click="findById(item.id)">➤</button></td>
                        <td><button @click="deleteById(item.id)">➤</button></td>
                    </tr>               
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import Swal from 'sweetalert2';
import {PERSONS_ENDPOINT, USERS_ENDPOINT} from '../../endpoint_config.js';
export default {
    name: 'PersonView',
    data() {
        return {
            id: 0,
            usuario: '',
            contrasenia: '',
            estado: '',
            listData: []
        }
    },
    created() {
        this.loadData();
    },
    methods: {
        loadData: function () {
            axios.get(USERS_ENDPOINT).then(result => {
                this.listData = result.data
            })
            axios.get(PERSONS_ENDPOINT).then(result => {
                this.listValidar = result.data
            })
        },
        findById: function (id) {
            // metodo para consutlar por el ig del boton impreso en la vista
            axios.get(USERS_ENDPOINT + '/' + id).then(result => {
                this.id = result.data.id;                
                this.usuario = result.data.usuario;
                // this.contrasenia = result.data.contrasenia;
                this.estado = (result.data.estado == true ? 1 : 0);
            })
        },
        deleteById: function (id) {
            // metodo para eliminar el registro por ID
            var bandera = this.validarReferencia(id);
            if (bandera == true) {
                Swal.fire({
                    title: 'Esta usted seguro de eliminar?',
                    text: "No pordrá revertir los cambios!",
                    icon: 'Advertencia',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, borrar!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        axios.delete(USERS_ENDPOINT + '/' + id).then(() => {
                            Swal.fire({
                                icon: 'success',
                                title: "'El registro se eliminó de forma correcta.'",
                                showConfirmButton: false,
                                timer: 1500
                            });
                            this.loadData();
                        })
                    }
                })
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Error, registro tiene asociado un permiso al rol.'
                })
            }
        },
        dataAdd: function () {
            let data = {                
                usuario: this.usuario,
                contrasenia: this.contrasenia,                
                estado: parseInt(this.estado)
            };
            axios.post(USERS_ENDPOINT, data).then(result => {
                if (result.data) {
                    Swal.fire({
                        icon: 'success',
                        title: "'El registro se guardó de forma correcta.'",
                        showConfirmButton: false,
                        timer: 1500
                    });
                    this.loadData();
                    this.clearList();
                }
            });

        },
        dataUpdate: function () {
            let data = {
                id: this.id,
                usuario: this.usuario,
                contrasenia: this.contrasenia,                
                estado: parseInt(this.estado)
            };
            axios.put(USERS_ENDPOINT + '/' + this.id, data).then(result => {
                if (result.data) {
                    Swal.fire({
                        icon: 'success',
                        title: "'El registro se guardó de forma correcta.'",
                        showConfirmButton: false,
                        timer: 1500
                    });
                    this.loadData();
                    this.clearList();
                }
            });

        },
        validarReferencia: function (id) {
            var bandera = true;

            this.listValidar.forEach((item, index) => {
                if (item.usuarioId.id == id) {
                    bandera = false
                }
                console.log(index)
            })
            return bandera;

        },
        clearList: function () {
            this.id = 0,
            this.usuario = '',
            this.contrasenia = '',            
            this.listData = []
        }
    }
}
</script>