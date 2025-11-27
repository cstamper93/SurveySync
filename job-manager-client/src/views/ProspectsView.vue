<template>
  <!-- <h1>Prospects</h1> -->
  <div class="container">
    <div class="needs-research-container">
      <h3>Needs Research</h3>
      <NeedsResearchDisplay v-for="needsResearchProspect in needsResearchList" v-bind:key="needsResearchProspect.jobId" v-bind:needsResearchProspect="needsResearchProspect" />
    </div>

    <div class="needs-quote-container">
      <NeedsQuoteDisplay v-for="needsQuoteProspect in needsQuoteList" v-bind:key="needsQuoteProspect.jobId" v-bind:needsQuoteProspect="needsQuoteProspect" />
    </div>

    <div class="ready-to-call-container">
      <ReadyToCallDisplay v-for="readyToCallProspect in readyToCallList" v-bind:key="readyToCallProspect.jobId" v-bind:readyToCallProspect="readyToCallProspect" />
    </div>

    <div class="ready-to-send-container">
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
// import ProspectDisplayService from '@/Services/ProspectDisplayService'
import JobCardService from '../Services/JobCardService.js'

// reactive state
const needsResearchJobCards = ref([])
const needsQuoteJobCards = ref([])
const readyToCallJobCards = ref([])
const readyToSendJobCards = ref([])

onMounted(() => {
  JobCardService.filterByStatus('needs research').then((response) => {
    console.log(response.data)
    needsResearchJobCards.value = response.data
  })

  JobCardService.filterByStatus('needs quote').then((response) => {
    console.log(response.data)
    needsQuoteJobCards.value = response.data
  })

  JobCardService.filterByStatus('ready to call').then((response) => {
    console.log(response.data)
    readyToCallJobCards.value = response.data
  })

  JobCardService.filterByStatus('ready to send').then((response) => {
    console.log(response.data)
    readyToSendJobCards.value = response.data
  })
})
</script>

<style scoped>
  .container {
    margin-left: 20%;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
  }

  button {
    margin: 10px;
  }
</style>
