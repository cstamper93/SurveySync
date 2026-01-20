<template>
  <div class="needs-research-container">
    <h4>Prospect Id: </h4><p>{{ needsResearchProspect.prospectId }}</p>
    <h4>Intake Date: </h4><p>{{ needsResearchProspect.intakeDate }}</p>
    <h4>Client Name: </h4><p>{{ needsResearchProspect.clientFirstName }} {{ needsResearchProspect.clientLastName }}</p>
    <h4>Job Address: </h4><p>{{ needsResearchProspect.jobAddress }}, {{ needsResearchProspect.jobTown }}</p>
    <h4>County: </h4><p>{{ needsResearchProspect.jobCounty }}</p>
    <h4>Job Type: <DisplayJobTypes v-for="jobType in jobTypeList" v-bind:key="jobType.jobId" v-bind:jobType="jobType"/></h4>
    <p> {{ this.jobTypeList }}</p>
    <p>------------------------------</p>
  </div>
</template>

<script>
import JobTypeService from '../Services/JobTypeService.js'
import DisplayJobTypes from './DisplayJobTypes.vue'
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
      return JobTypeService.getJobTypesByJob(this.needsResearchProspect.jobId)
    }
  },
  components: { DisplayJobTypes }

}
</script>

<style scoped>

</style>
