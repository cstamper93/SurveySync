<template>
  <!-- <h1>Prospects</h1> -->
  <div class="container">
    <div class="needs-research-container">
      <h3>Needs Research</h3>
      <router-link to="/prospect-details"><div class="grid">
        <span>
          <strong>ID</strong>
        </span>
        <span>
          <strong>Intake Date</strong>
        </span>
        <span>
          <strong>Name</strong>
        </span>
        <span>
          <strong>Address</strong>
        </span>
        <span>
          <strong>Town</strong>
        </span>
        <span>
          <strong>County</strong>
        </span>
        <span>
          <strong>Job Types</strong>
        </span>
      </div></router-link>
      <NeedsResearchDisplay
        v-for="needsResearchProspect in needsResearchProspects"
        :key="needsResearchProspect.jobId"
        v-bind:needsResearchProspect="needsResearchProspect" />
    </div>

    <div class="needs-quote-container">
      <h3>Needs Quote</h3>
      <div class="grid">
        <span>
          <strong>ID</strong>
        </span>
        <span>
          <strong>Intake Date</strong>
        </span>
        <span>
          <strong>Name</strong>
        </span>
        <span>
          <strong>Address</strong>
        </span>
        <span>
          <strong>Town</strong>
        </span>
        <span>
          <strong>County</strong>
        </span>
        <span>
          <strong>Job Types</strong>
        </span>
      </div>
      <NeedsQuoteDisplay v-for="needsQuoteProspect in needsQuoteJobCards" v-bind:key="needsQuoteProspect.jobId" v-bind:needsQuoteProspect="needsQuoteProspect" />
    </div>

    <div class="ready-to-call-container">
      <h3>Ready To Call</h3>
      <div class="grid">
        <span>
          <strong>ID</strong>
        </span>
        <span>
          <strong>Intake Date</strong>
        </span>
        <span>
          <strong>Name</strong>
        </span>
        <span>
          <strong>Address</strong>
        </span>
        <span>
          <strong>Town</strong>
        </span>
        <span>
          <strong>County</strong>
        </span>
        <span>
          <strong>Job Types</strong>
        </span>
      </div>
      <ReadyToCallDisplay v-for="readyToCallProspect in readyToCallList" v-bind:key="readyToCallProspect.jobId" v-bind:readyToCallProspect="readyToCallProspect" />
    </div>

    <div class="ready-to-send-container">
      <h3>Send Contract</h3>
      <div class="grid">
        <span>
          <strong>ID</strong>
        </span>
        <span>
          <strong>Intake Date</strong>
        </span>
        <span>
          <strong>Name</strong>
        </span>
        <span>
          <strong>Address</strong>
        </span>
        <span>
          <strong>Town</strong>
        </span>
        <span>
          <strong>County</strong>
        </span>
        <span>
          <strong>Job Types</strong>
        </span>
      </div>
      <ReadyToSendDisplay v-for="readyToSendProspect in readyToSendList" v-bind:key="readyToSendProspect.jobId" v-bind:readyToSendProspect="readyToSendProspect" />
    </div>

  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import NeedsResearchDisplay from '../components/DisplayNeedsResearchProspects.vue'
import NeedsQuoteDisplay from '../components/DisplayNeedsQuoteProspects.vue'
import ReadyToCallDisplay from '../components/DisplayReadyToCallProspects.vue'
import ReadyToSendDisplay from '../components/DisplayReadyToSendProspects.vue'
import ProspectDisplayService from '../Services/ProspectDisplayService.js'
// import JobTypeService from '../Services/JobTypeService.js'

// reactive state
const needsResearchProspects = ref([])
// const needsResearchJobTypes = ref([])
const needsQuoteJobCards = ref([])
const readyToCallList = ref([])
const readyToSendList = ref([])
// const jobTypeList = ref([])

onMounted(() => {
  ProspectDisplayService.getProspectDisplayList('needs research').then((response) => {
    // console.log(response.data)
    needsResearchProspects.value = response.data
  })

  ProspectDisplayService.getProspectDisplayList('needs quote').then((response) => {
    console.log(response.data)
    needsQuoteJobCards.value = response.data
  })

  ProspectDisplayService.getProspectDisplayList('ready to call').then((response) => {
    console.log(response.data)
    readyToCallList.value = response.data
  })

  ProspectDisplayService.getProspectDisplayList('ready to send').then((response) => {
    console.log(response.data)
    readyToSendList.value = response.data
  })
})
</script>

<style scoped>
  .grid {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
  }
  .grid > span {
    padding: 8px 4px;
    border-left: 1px solid black;
    border-bottom: 1px solid black;
    border-right: 1px solid black;
    border-top: 1px solid black;
  }

  .container {
    margin-left: 21%;
  }

  .needs-research-container {
    /* width: 300px; */
  }

  button {
    margin: 10px;
  }
</style>
