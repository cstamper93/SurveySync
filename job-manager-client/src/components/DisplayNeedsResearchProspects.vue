<template>
  <div class="needs-research-container">
    <h3>Needs Research</h3>
    <h4>Prospect Id: {{ needsResearchProspect.prospectId }}</h4>
    <h4>Intake Data: {{ needsResearchProspect.intakeDate }} </h4>
  </div>
</template>

<script>
export default {
  name: 'NeedsResearchDisplay',
  data () {
    return {

    }
  },
  props: {
    needsResearchProspect: Object
  },
  computed: {

  }

}
</script>

<style scoped>

</style>
