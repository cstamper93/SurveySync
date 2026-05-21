<template>
  <div>
    <span>{{ property.address}},</span>
    <span>{{ property.town }}</span>
  </div>
</template>

<script>
export default {
  name: 'PropertyDetails',
  props: ['property'],
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
