<script>
export default {
  name: 'JobTypeDetails',
  props: ['jobType']
}
</script>

<template>
  <div>
    <h2>Job Type: {{ jobType.type }}</h2>
    <h2>Price: {{ jobType.price }}</h2>
  </div>
</template>

<style scoped>
  div {
    text-align: center;
  }
</style>
