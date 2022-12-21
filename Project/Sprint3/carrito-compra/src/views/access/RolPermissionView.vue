<template>    
    <div class="container">
        <form id="rol">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de permisos por Rol</p>
                </div>
                <!-- Datos de entrada del formulario -->
                <div class="form-group">
                    <input type="hidden" v-model="id">
                    
                    <div>
                        <label class="form-label mt-1" name="selectRoleS">Rol</label>
                        <br>                        
                        <select name="selectRoleS" v-model="rolId">
                            <option v-for="option in listRoles" v-bind:value="option.id" v-bind:key="option.codigo">
                                {{ JSON.stringify(option) }}
                            </option>
                        </select>                        
                    </div>

                    <div>
                        <label class="form-label mt-1" name="selectPermissionS">Permission</label>
                        <br>                        
                        <select name="selectPermissionS" v-model="permissionId">
                            <option v-for="option in listPermissions" v-bind:value="option.id" v-bind:key="option.codigo">
                                {{ JSON.stringify(option) }}
                            </option>
                        </select>                        
                    </div>
                </div>

                <!-- Botones -->
                <div>
                    <br>
                    <button type="button" class="btn btn-outline-success" @click="dataAdd()">Agregar</button>
                    &nbsp;                    
                </div>
            </fieldset>
        </form>

        <!-- Registros -->
        <div>
            <br>
            <table class="table table-hover">
                <thead>
                    <tr class="table-active">
                        <td>Id</td>
                        <td>Rol</td>
                        <td>Permiso</td>                        
                        <td>Eliminar</td>
                    </tr>
                </thead>
                <tbody id="dataResult">
                    <tr v-for="item in listData" :key="item.id">
                        <td>{{ item.id }}</td>
                        <td>{{ item.rolId }}</td>
                        <td>{{ item.permissionId }}</td>                        
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
import {ROLES_PERMISSIONS_ENDPOINT, ROLES_ENDPOINT, PERMISSIONS_ENDPOINT} from '../../endpoint_config.js';

export default {
    name: 'RolPermissionView',

    data() {
        return {
            id: 0,
            rolId: '',
            permissionId: '',            
            listData: [],
            listRoles:[],
            listPermissions:[],
            listValidar: []            
        }
    },
    created() {
        this.loadData();
    },
    methods: {
        loadData: function () {
            axios.get(ROLES_PERMISSIONS_ENDPOINT).then(result => {
                this.listData = result.data
                // console.log(this.listData)          
            })
            axios.get(ROLES_ENDPOINT).then(result => {
                this.listRoles = result.data
                // console.log(this.listRoles)
            })
            axios.get(PERMISSIONS_ENDPOINT).then(result => {
                this.listPermissions = result.data
                // console.log(this.listPermissions)
            })
            axios.get(ROLES_PERMISSIONS_ENDPOINT).then(result => {
                this.listValidar = result.data
            })
        },
        findByid: function (id) {
            // metodo para consutlar por el ig del boton impreso en la vista
            axios.get(ROLES_PERMISSIONS_ENDPOINT + '/' + id).then(result => {
                this.id = result.data.id;
                this.rolId = result.data.rolId;
                this.permissionId = result.data.permissionId;                
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
                        axios.delete(ROLES_PERMISSIONS_ENDPOINT + '/' + id).then(() => {
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
                rolId:{
                    id: this.rolId,                    
                },
                permissionId:{
                    id: this.permissionId                    
                }
            };
            console.log(data);
            axios.post(ROLES_PERMISSIONS_ENDPOINT, data).then(result => {
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
                this.rolId = '',
                this.permissionId = '',                
                this.listData = []
        }
    }
}
</script>