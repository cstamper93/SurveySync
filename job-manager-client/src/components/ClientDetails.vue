<template>
  <div>
    <span>{{ client.firstName }}</span>
    <span>{{ client.lastName }}</span>
  </div>
</template>

<script>
export default {
  name: 'ClientDetails',
  props: ['client'],
  data() {
    return {}
  }
}
</script>

<style scoped>
  div {
    text-align: center;
  }
</style>
