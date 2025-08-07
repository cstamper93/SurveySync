<template>
  <div class="component-container">
    <div class="client-card">
      <div class="title-row-container">
        <h3>Name</h3>
        <h3>Phone</h3>
        <h3>Email</h3>
      </div>
      <div class="clients-list">
        <p class="client-name">{{ client.firstName }} {{ client.lastName }}</p>
        <p>{{ client.cellPhoneNumber }}</p>
        <p>{{ client.clientEmail }}</p>
      </div>
    </div>
  </div>
</template>

<script>
// import ClientService from '../Services/ClientService.js'
export default {
  name: 'DisplayAllClients',
  data () {
    return {

    }
  },
  props: {
    client: Object
  },
  methods: {

  }
}
</script>

<style>
.client-card {
  margin-left: 10px;
  margin-right: 10px;
  padding-left: 10px;
  padding-right: 10px;
  border: solid black 2px;
  border-radius: 2px;
}

.title-row-container {
  display: flex;
  justify-content: space-between;
}

.clients-list {
  display: flex;
  justify-content: space-between;
}
</style>
