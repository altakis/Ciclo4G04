<template>
    <div class="container">
        <form id="person">
            <fieldset>
                <div class="alert alert-dismissible alert-warning">
                    <p class="mb-0">Registro de Ciudades</p>
                </div>
                <!-- Datos de entrada del formulario -->
                <div class="form-group">
                    <input type="hidden" v-model="id">

                    <label class="form-label mt-1">Tipo Documento</label>
                    <select class="form-select" v-model="tipoDocumento">
                        <option disabled selected='true'>-- Seleccione --</option>
                        <option value="CC">CC</option>
                        <option value="TI">TI</option>
                        <option value="CE">CE</option>
                    </select>

                    <label class="form-label mt-1">Documento</label>
                    <input type="text" class="form-control" v-model="documento" placeholder="Ingresar código">

                    <label class="form-label mt-1">Priemr Nombre</label>
                    <input type="text" class="form-control" v-model="primerNombre" placeholder="Ingresar código">

                    <label class="form-label mt-1">Segundo Nombre</label>
                    <input type="text" class="form-control" v-model="segundoNombre" placeholder="Ingresar código">

                    <label class="form-label mt-1">Primer Apellido</label>
                    <input type="text" class="form-control" v-model="primerApellido" placeholder="Ingresar código">

                    <label class="form-label mt-1">Segundo Apellido</label>
                    <input type="text" class="form-control" v-model="segundoApellido" placeholder="Ingresar código">

                    <label class="form-label mt-1">Correo</label>
                    <input type="text" class="form-control" v-model="correo" placeholder="Ingresar código">

                    <label class="form-label mt-1">Teléfono</label>
                    <input type="text" class="form-control" v-model="telefono" placeholder="Ingresar código">

                    <label class="form-label mt-1">Fecha Nacimiento</label>
                    <input type="date" class="form-control" v-model="fechaNacimiento"
                        placeholder="Ingresar fecha nacimmiento">

                    <label class="form-label mt-1">Dirección</label>
                    <input type="text" class="form-control" v-model="direccion" placeholder="Ingresar dirección">

                    <label class="form-label mt-1">Usuario</label>
                    <select class="form-select" v-model="usuarioId">
                        <option disabled :selected="true" value="">-- Seleccione --</option>
                        <option v-for="item in listUsuario" :key="item.id" :value="item.id">{{ item.usuario }}</option>
                    </select>

                    <label class="form-label mt-1">Ciudad</label>
                    <select class="form-select" v-model="ciudadId">
                        <option disabled :selected="true" value="">-- Seleccione --</option>
                        <option v-for="item in listCiudad" :key="item.id" :value="item.id">{{ item.nombre }}</option>
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
                    <tr v-for="item in listData" :key="item.id">
                        <td>{{ item.tipoDocumento }}</td>
                        <td>{{ item.documento }}</td>
                        <td>{{ item.primerNombre }}</td>
                        <td>{{ item.segundoNombre }}</td>
                        <td>{{ item.primerApellido }}</td>
                        <td>{{ item.segundoApellido }}</td>
                        <td>{{ item.correo }}</td>
                        <td>{{ item.telefono }}</td>
                        <td>{{ item.fechaNacimiento.substring(0,10) }}</td>
                        <td>{{ item.direccion }}</td>
                        <td>{{ item.usuarioId.usuario }}</td>
                        <td>{{ item.ciudadId.nombre }}</td>
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
import {PERSONS_ENDPOINT, USERS_ENDPOINT, CITIES_ENDPOINT} from '../../endpoint_config.js';
export default {
    name: 'PersonView',
    data() {
        return {
            id: 0,
            codigo: '',
            nombre: '',
            estado: '',
            listData: [],
            listUsuario: [],
            listCiudad: []
        }
    },
    created() {
        this.loadData();
    },
    methods: {
        loadData: function () {
            axios.get(PERSONS_ENDPOINT).then(result => {
                this.listData = result.data
            })
            axios.get(USERS_ENDPOINT).then(result => {
                this.listUsuario = result.data
            })
            axios.get(CITIES_ENDPOINT).then(result => {
                this.listCiudad = result.data
            })
        },
        findById: function (id) {
            // metodo para consutlar por el ig del boton impreso en la vista
            axios.get(PERSONS_ENDPOINT + '/' + id).then(result => {
                this.id = result.data.id;
                this.tipoDocumento = result.data.tipoDocumento;
                this.documento = result.data.documento;
                this.primerNombre = result.data.primerNombre;
                this.segundoNombre = result.data.segundoNombre;
                this.primerApellido = result.data.primerApellido;
                this.segundoApellido = result.data.segundoApellido;
                this.correo = result.data.correo;
                this.telefono = result.data.telefono;
                this.fechaNacimiento = result.data.fechaNacimiento.substring(0,10);
                this.direccion = result.data.direccion;
                this.usuarioId = result.data.usuarioId.id;
                this.ciudadId = result.data.ciudadId.id;
                this.estado = (result.data.estado == true ? 1 : 0);
            })
        },
        deleteById: function (id) {
            // metodo para eliminar el registro por ID
            var bandera = true;
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
                        axios.delete(PERSONS_ENDPOINT + '/' + id).then(() => {
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
                tipoDocumento: this.tipoDocumento,
                documento: this.documento,
                primerNombre: this.primerNombre,
                segundoNombre: this.segundoNombre,
                primerApellido: this.primerApellido,
                segundoApellido: this.segundoApellido,
                correo: this.correo,
                telefono: this.telefono,
                fechaNacimiento: this.fechaNacimiento,
                direccion: this.direccion,
                usuarioId: {
                    id: this.usuarioId
                },
                ciudadId: {
                    id: this.ciudadId
                },
                estado: parseInt(this.estado)
            };
            axios.post(PERSONS_ENDPOINT, data).then(result => {
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
                tipoDocumento: this.tipoDocumento,
                documento: this.documento,
                primerNombre: this.primerNombre,
                segundoNombre: this.segundoNombre,
                primerApellido: this.primerApellido,
                segundoApellido: this.segundoApellido,
                correo: this.correo,
                telefono: this.telefono,
                fechaNacimiento: this.fechaNacimiento,
                direccion: this.direccion,
                usuarioId: {
                    id: this.usuarioId
                },
                ciudadId: {
                    id: this.ciudadId
                },
                estado: parseInt(this.estado)
            };
            axios.put(PERSONS_ENDPOINT + '/' + this.id, data).then(result => {
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
                this.tipoDocumento = '',
                this.documento = '',
                this.primerNombre = '',
                this.segundoNombre = '',
                this.primerApellido = '',
                this.segundoApellido = '',
                this.correo = '',
                this.telefono = '',
                this.fechaNacimiento = '',
                this.direccion = '',
                this.estado = '',
                this.usuarioId = '',
                this.ciudadId = '',
                this.listData = [],
                this.listUsuario = [],
                this.listCiudad = []
        }
    }
}
</script>