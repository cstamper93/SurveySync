<template>
  <div>
    <h3>Needs Quote</h3>
    <h4>Prospect Id: {{ needsQuoteProspect.prospectId }}</h4>
    <h4>Intake Date: {{ needsQuoteProspect.intakeDate }}</h4>
  </div>
</template>

<script>

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
