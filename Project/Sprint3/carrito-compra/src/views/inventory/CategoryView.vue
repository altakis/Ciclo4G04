<template>    
    <div class="container">
        <form id="rol">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de Permisos</p>
                </div>
                <!-- Datos de entrada del formulario -->
                <div class="form-group">
                    <input type="hidden" v-model="id">

                    <label class="form-label mt-1">Código</label>
                    <input type="text" class="form-control" v-model="codigo" placeholder="Ingresar código">

                    <label class="form-label mt-1">Nombre</label>
                    <input type="text" class="form-control" v-model="nombre" placeholder="Ingresar nombre">
                    
                    <label class="form-label mt-1">Ruta</label>
                    <input type="text" class="form-control" v-model="ruta" placeholder="Ingresar ruta">
                    
                    <label class="form-label mt-1">Estado</label>
                    <select class="form-select" v-model="estado">
                        <option disabled :selected="true" value="">-- Seleccione --</option>
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
                        <td>Codigo</td>
                        <td>Permiso</td>                        
                        <td>Ruta</td>
                        <td>Estado</td>
                        <td>Editar</td>
                        <td>Eliminar</td>
                    </tr>
                </thead>
                <tbody id="dataResult">
                    <tr v-for="item in listData" :key="item.id">
                        <td>{{ item.codigo }}</td>
                        <td>{{ item.nombre }}</td>                        
                        <td>{{ item.ruta }}</td> 
                        <td>{{ item.estado == true ? 'Activo' : 'Inactivo' }}</td>
                        <td><button @click="findByid(item.id)">➤</button></td>
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
import {PERMISSIONS_ENDPOINT, ROLES_PERMISSIONS_ENDPOINT} from '../../endpoint_config.js';

export default {
    name: 'CategoryView',

    data() {
        return {
            id: 0,
            codigo: '',
            nombre: '',
            ruta: '',
            estado: '',
            listData: [],            
            listRolPermissions:[],
            listValidar: []
        }
    },
    created() {
        this.loadData();
    },
    methods: {
        loadData: function () {
            axios.get(PERMISSIONS_ENDPOINT).then(result => {
                this.listData = result.data
            })
            axios.get(ROLES_PERMISSIONS_ENDPOINT).then(result => {
                this.listRolPermissions = result.data
            })            
            axios.get(PERMISSIONS_ENDPOINT).then(result => {
                this.listValidar = result.data
            })
        },
        findByid: function (id) {
            // metodo para consutlar por el ig del boton impreso en la vista
            axios.get(PERMISSIONS_ENDPOINT + '/' + id).then(result => {
                this.id = result.data.id;
                this.codigo = result.data.codigo;
                this.nombre = result.data.nombre;              
                this.ruta = result.data.ruta;
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
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, borrar!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        axios.delete(PERMISSIONS_ENDPOINT + '/' + id).then(() => {
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
                codigo: this.codigo,
                nombre: this.nombre,                
                ruta: this.ruta,
                estado: parseInt(this.estado)
            };
            axios.post(PERMISSIONS_ENDPOINT, data).then(result => {
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
                codigo: this.codigo,
                nombre: this.nombre, 
                ruta: this.ruta,               
                estado: parseInt(this.estado)
            };
            axios.put(PERMISSIONS_ENDPOINT + '/' + this.id, data).then(result => {
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
                if (item.rolId == id) {
                    bandera = false
                }
                console.log(index)
            })
            return bandera;

        },
        clearList: function () {
            this.id = 0,
                this.codigo = '',
                this.nombre = '',
                this.ruta = '',
                this.estado = '',
                this.listData = []
        }
    }
}
</script>