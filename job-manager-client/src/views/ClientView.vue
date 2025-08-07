<template>
  <div class="container">
    <h1>This is the clients page</h1>
    <div class="all-clients-display">
      <DisplayAllClients v-for="client in listOfAllClients" v-bind:key="client.clientId" v-bind:client="client" />
    </div>
  </div>
</template>

<script>
import DisplayAllClients from '../components/DisplayAllClients.vue'
import ClientService from '@/Services/ClientService.js'

export default {
  name: 'ClientView',
  data () {
    return {
      listOfAllClients: []
    }
  },
  created () {
    ClientService.getAllClients().then((response) => {
      this.listOfAllClients = response.data
    })
  },
  methods: {},
  components: { DisplayAllClients }
}
</script>

<style>

</style>
