<template>
  <div class="ready-to-send-container">
    <div class="grid">
      <span>{{ readyToSendProspect.jobId }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToSendProspect.intakeDate }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToSendProspect.clientFirstName }} {{ readyToSendProspect.clientLastName }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToSendProspect.jobAddress }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToSendProspect.jobTown }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToSendProspect.jobCounty }}</span>
    </div>
    <div class="grid">
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
    readyToSendProspect: Object
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
    display: grid;
    grid-template-columns: repeat(7, 1fr)
  }
  .ready-to-send-container > .grid {
    padding: 8px 4px;
    border-left: 1px solid black;
    border-bottom: 1px solid black;
    border-right: 1px solid black;
    border-top: 1px solid black;
  }
  h4 {
    margin-right: 5px;
  }
  p {
    margin-right: 5px;
  }
</style>
