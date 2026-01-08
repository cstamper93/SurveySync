<template>
  <div>
    <h3>Needs Quote</h3>
    <h4>Prospect Id: {{ needsQuoteProspect.prospectId }}</h4>
    <h4>Intake Date: {{ needsQuoteProspect.intakeDate }}</h4>
  </div>
</template>

<script>
// Create a computed property to find list of job types based on job id. Send to another component to
// display each programmatically

export default {
  name: 'NeedsQuoteDisplay',
  data () {
    return {

    }
  },
  props: {
    needsQuoteProspect: Object
  }

}
</script>

<style>

</style>
