<template>
  <div class="container">
    <button v-if="!viewAll" @click="viewAll = !viewAll" class="view-all-btn">View All</button>
    <button v-if="viewAll" @click="viewAll = !viewAll" class="view-all-btn">Hide</button>

    <div class="all-clients-display">
      <DisplayAllClients v-for="client in listOfAllClients" v-bind:key="client.clientId" v-bind:client="client" />
    </div>
  </div>
</template>

<script>
import DisplayAllClients from '@/components/DisplayAllClients.vue'
import ClientService from '@/Services/ClientService.js'
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'ProspectsView',
  data () {
    return {
      viewAll: false,
      listOfAllClients: []
    }
  },
  components: {
    DisplayAllClients
  },
  // created () {
  //   ClientService.getAllClients().then((response) => {
  //     this.listOfAllClients = response.data
  //   })
  // }
}
</script>

<style scoped>
  .container {
    margin-left: 20%;
  }

  button {
    margin: 10px;
  }
</style>
