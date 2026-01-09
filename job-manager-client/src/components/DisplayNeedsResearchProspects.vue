<template>
  <div class="needs-research-container">
    <h4>Prospect Id: {{ needsResearchProspect.prospectId }}</h4>
    <h4>Intake Date: {{ needsResearchProspect.intakeDate }}</h4>
    <h4>Client Name: {{ needsResearchProspect.clientFirstName }} {{ needsResearchProspect.clientLastName }}</h4>
    <h4>Job Address: {{ needsResearchProspect.jobAddress }}, {{ needsResearchProspect.jobTown }}</h4>
    <h4>County: {{ needsResearchProspect.jobCounty }}</h4>
    <h4>Job Type: {{ needsResearchProspect.jobType }}</h4>
    <p>------------------------------</p>
  </div>
</template>

<script>
// Create a computed property to find list of job types based on job id. Send to another component to
// display each programmatically

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
    jobTypeList () {
      return this.needsResearchProspect.
    }
  }

}
</script>

<style scoped>

</style>
