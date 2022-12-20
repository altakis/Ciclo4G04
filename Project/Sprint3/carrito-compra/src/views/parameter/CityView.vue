<template>
    <div class="container">
        <form id="city">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de Ciudades</p>
                </div>
                <!-- Datos de entarada del formulario -->
                <div class="form-group">
                    <input type="hidden" v-model="id">

                    <label class="form-label mt-1">Código</label>
                    <input type="text" class="form-control" v-model="codigo" placeholder="Ingresar código">

                    <label class="form-label mt-1">Nombre</label>
                    <input type="text" class="form-control" v-model="nombre" placeholder="Ingresar nombre">

                    <label class="form-label mt-1">Departamentos</label>
                    <select class="form-select" v-model="departmentId">
                        <option disabled :selected="true" value="">-- Seleccione --</option>
                        <option v-for="item in listDepartment" :key="item.id" :value="item.id">{{ item.nombre}}
                        </option>
                    </select>
                    
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
                        <td>Ciudad</td>
                        <td>Departamento</td>
                        <td>Estado</td>
                        <td>Editar</td>
                        <td>Eliminar</td>
                    </tr>
                </thead>
                <tbody id="dataResult">
                    <tr v-for="item in listData" :key="item.id">
                        <td>{{ item.codigo }}</td>
                        <td>{{ item.nombre }}</td>
                        <td>{{ item.departmentId.nombre }}</td>
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
import Swal from 'sweetalert2'

export default {
    name: 'DepartmentView',

    data() {
        return {
            id: 0,
            codigo: '',
            nombre: '',
            estado: '',
            listData: [],
            listDepartment:[],
            listValidar: []
        }
    },
    created() {
        this.loadData();
    },
    methods: {
        loadData: function () {
            axios.get('http://150.136.125.111:8080/api/cities').then(result => {
                this.listData = result.data
            })
            axios.get('http://150.136.125.111:8080/api/departments').then(result => {
                this.listDepartment = result.data
            })
            axios.get('http://150.136.125.111:8080/api/cities').then(result => {
                this.listValidar = result.data
            })
        },
        findByid: function (id) {
            // metodo para consutlar por el ig del boton impreso en la vista
            axios.get('http://150.136.125.111:8080/api/cities/' + id).then(result => {
                this.id = result.data.id;
                this.codigo = result.data.codigo;
                this.nombre = result.data.nombre;
                this.departmentId = result.data.departmentId.id;
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
                        axios.delete('http://150.136.125.111:8080/api/cities/' + id).then(() => {
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
                departmentId:{
                    id:this.departmentId
                },
                estado: parseInt(this.estado)
            };
            axios.post('http://150.136.125.111:8080/api/cities', data).then(result => {
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
                departmentId:{
                    id:this.departmentId
                },
                estado: parseInt(this.estado)
            };
            axios.put('http://150.136.125.111:8080/api/cities/' + this.id, data).then(result => {
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
                if (item.departmentId.id == id) {
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
                this.estado = '',
                this.listData = []
        }
    }
}
</script>
  