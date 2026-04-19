<template>
  <div>
    <span>{{ client.firstName }}</span>
    <span>{{ client.lastName }}</span>
  </div>
</template>

<script>
export default {
  name: 'clientDetails',
  props: ['client'],
  data() {
    return {}
  }
}
</script>

<style scoped>

</style>
