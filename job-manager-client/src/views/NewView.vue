<template>
  <div class="container">
    <h1>New Prospect</h1>
    <form class="prospect-form">
        <h3>Client Details</h3>
        <label for="firstName"
        class="input-label"
        >First Name: </label>
        <input
        type="text"
        id="firstName"
        class="input-box"
        placeholder="First Name"
        />
    </form>
  </div>
</template>

<script>
export default {
  name: 'NewView',
  data () {
    return {}
  }

}
</script>

<style>
  .container {
    margin-left: 20%;
    text-align: center;
  }
</style>
