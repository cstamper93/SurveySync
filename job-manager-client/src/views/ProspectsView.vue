<template>
  <div class="container">
    <h1>Prospects</h1>
    <div class="needs-research-container">

    </div>

    <div class="needs-quote-container">

    </div>

    <div class="ready-to-call-container">

    </div>

    <div class="ready-to-send-container">

    </div>

  </div>

</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'ProspectsView',
  data () {
    return {

    }
  },
  components: {

  }
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
