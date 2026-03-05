<template>
  <div class="ready-to-send-container">
      <div class="row">
        <h4>Intake Date: </h4><p>{{ readyToSendProspect.intakeDate }}</p>
      </div>
      <div class="row">
        <h4>Client Name: </h4><p>{{ readyToSendProspect.clientFirstName }} {{ readyToSendProspect.clientLastName }}</p>
      </div>
      <div class="row">
        <h4>Job Address: </h4><p>{{ readyToSendProspect.jobAddress }}, {{ readyToSendProspect.jobTown }}</p>
      </div>
      <div class="row">
        <h4>County: </h4><p>{{ readyToSendProspect.jobCounty }}</p>
      </div>
      <div class="row">
        <h4>Job Types: </h4>
        <div class="job-type-tags">
        <span
          v-for="(type, index) in readyToSendProspect.jobTypes"
          :key="index"
          :class="['job-tag', tagColor(type)]">
          {{ type }}
        </span>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'ReadyToSendDisplay',
  data () {
    return {}
  },
  props: {
    readyToCallProspect: Object
  },
  methods: {
    tagColor (type) {
      switch (type) {
        case 'FS':
          return 'tag-FS'
        case 'EPS':
          return 'tag-EPS'
        case 'Division':
          return 'tag-Div'
        case 'Recombination':
          return 'tag-Recomb'
        case 'Site Plan':
          return 'tag-SP'
        default:
          return 'tag-default'
      }
    }
  }
}
</script>

<style scoped>
  .job-type-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 8px;
  }
  .job-tag {
    background-color: #2c7be5;
    color: white;
    padding: 4px 10px;
    border-radius: 20px;
    font-size: 0.8rem;
    font-weight: 500;
  }
  .tag-FS {
    background-color: #2c7be5;
  }
  .tag-EPS {
    background-color: #00a854;
  }
  .tag-Div {
    background-color: #f0ad4e;
  }
  .tag-Recomb {
    background-color: #ff69b4;
  }
  .tag-SP {
    background-color: red;
  }
  .tag-default {
    background-color: #6c757d;
  }
  .ready-to-send-container {
    display: flex;
    flex-direction: column;
    border: 2px solid black;
    border-radius: 5px;
  }
  .row {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 5px;
  }
  h4 {
    margin-right: 5px;
  }
  p {
    margin-right: 5px;
  }
</style>
