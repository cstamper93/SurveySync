<template>
  <div class="needs-research-container">
    <h2>Prospect Id: <span>{{ needsResearchProspect.prospectId }}</span></h2>
    <h2>Name: <span>{{ needsResearchProspect.billingClientId }}</span></h2>
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
  }

}
</script>

<style>

</style>
