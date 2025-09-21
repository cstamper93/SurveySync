<template>
  <div>
    <h3>Ready To Call</h3>
    <h4>Prospect Id: {{ readyToCallProspect.prospectId }}</h4>
    <h4>Intake Date: {{ readyToCallProspect.intakeDate }}</h4>
  </div>
</template>

<script>
export default {
  name: 'ReadyToCallDisplay',
  data () {

  },
  props: {
    readyToCallProspect: Object
  }

}
</script>

<style>

</style>
