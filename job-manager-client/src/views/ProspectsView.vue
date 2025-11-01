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
import ProspectDisplayService from '@/Services/ProspectDisplayService'

// reactive state
const needsResearchList = ref([])
const needsQuoteList = ref([])
const readyToCallList = ref([])
const readyToSendList = ref([])

onMounted(() => {
  ProspectDisplayService.getProspectDisplayList('needs research').then((response) => {
    // console.log(response.data)
    needsResearchList.value = response.data
  })

  ProspectDisplayService.getProspectDisplayList('needs quote').then((response) => {
    console.log(response.data)
    needsQuoteList.value = response.data
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
