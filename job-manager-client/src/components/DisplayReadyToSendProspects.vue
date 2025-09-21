<template>
  <div>
    <h3>Ready To Send</h3>
    <h4>Prospect Id: {{ readyToSendProspect.prospectId }}</h4>
    <h4>Intake Date: {{ readyToSendProspect.intakeDate }}</h4>
  </div>
</template>

<script>
export default {
  name: 'ReadyToSendDisplay',
  data () {

  },
  props: {
    readyToSendProspect: Object
  }
}
</script>

<style>

</style>
