<template>
  <div class="container">
    <h1>Prospects</h1>
    <NeedsResearchDisplay :items="needsResearchList" />

    <div class="needs-quote-container">
      <NeedsQuoteDisplay/>
    </div>

    <div class="ready-to-call-container">
      <ReadyToCallDisplay/>
    </div>

    <div class="ready-to-send-container">
      <ReadyToSendDisplay/>
    </div>

  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import NeedsResearchDisplay from '../components/DisplayNeedsResearchProspects.vue'
import NeedsQuoteDisplay from '../components/DisplayNeedsQuoteProspects.vue'
import ReadyToCallDisplay from '../components/DisplayReadyToCallProspects.vue'
import ReadyToSendDisplay from '../components/DisplayReadyToSendProspects.vue'
import JobCardService from '@/Services/JobCardService.js'

const needsResearchList = ref([])
// const needsQuoteList = ref([])
// const readyToCallList = ref([])
// const readyToSendList = ref([])

onMounted(() => {
  JobCardService.filterByStatus('needs research').then((response) => {
    needsResearchList.value = response.data
    console.log('hello!')
  })
})

</script>

<style scoped>
  .container {
    margin-left: 20%;
  }

  button {
    margin: 10px;
  }
</style>
