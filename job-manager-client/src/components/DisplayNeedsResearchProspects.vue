<template>
  <div class="needs-research-container">
    <h1>Needs Research</h1>
    <h2>Prospect Id: {{ needsResearchProspect.prospectId }}</h2>
    <h2>Name: {{ needsResearchProspect.intakeDate }} </h2>
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
  computed () {

  }

}
</script>

<style>

</style>
