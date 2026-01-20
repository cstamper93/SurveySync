<template>
  <div>
    <p>{{ jobType }}</p>
  </div>
</template>

<script>
export default {
  name: 'DisplayJobTypes',
  data () {
    return {
    }
  },
  props: {
    jobType: Object
  }
}
</script>

<style>

</style>
