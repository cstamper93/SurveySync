<template>
  <div class="component-container">
    <div class="client-card">
      <h2 class="client-name">{{ client.firstName }} {{ client.lastName }}</h2>
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

</style>
