<template>
  <div class="container">
    <h1>Prospects</h1>
    <div class="needs-research-container">
      <NeedsResearchDisplay v-for="needsResearchProspect in needsResearchList" v-bind:key="needsResearchProspect.prospectId" v-bind:needsResearchProspect="needsResearchProspect" />
    </div>

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

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import NeedsResearchDisplay from '../components/DisplayNeedsResearchProspects.vue'
import NeedsQuoteDisplay from '../components/DisplayNeedsQuoteProspects.vue'
import ReadyToCallDisplay from '../components/DisplayReadyToCallProspects.vue'
import ReadyToSendDisplay from '../components/DisplayReadyToSendProspects.vue'
import JobCardService from '../Services/JobCardService.vue'

export default {
  name: 'ProspectsView',
  data () {
    return {
      needsResearchList: [],
      needsQuoteList: [],
      readyToCallList: [],
      readyToSendList: []
    }
  },
  components: {
    NeedsResearchDisplay,
    NeedsQuoteDisplay,
    ReadyToCallDisplay,
    ReadyToSendDisplay
  },
  created () {
    JobCardService.filterByStatus('needs research').then((response) => {
      this.needsResearchList = response.data
    })
  }
}
</script>

<style scoped>
  .container {
    margin-left: 20%;
  }

  button {
    margin: 10px;
  }
</style>
