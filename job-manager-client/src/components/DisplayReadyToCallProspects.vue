<template>
  <div
    class="ready-to-call-container"
    role="link"
    tabindex="0"
    @click="goToDetails"
    @keydown.enter="goToDetails"
  >
    <div class="grid">
      <span>{{ readyToCallProspect.jobId }}</span>
    </div>
    <div class="grid">
      <span>{{ formatDate(readyToCallProspect.createdAt) }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToCallProspect.clientFirstName }} {{ readyToCallProspect.clientLastName }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToCallProspect.jobAddress }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToCallProspect.jobTown }}</span>
    </div>
    <div class="grid">
      <span>{{ readyToCallProspect.jobCounty }}</span>
    </div>
    <div class="grid">
      <div class="job-type-tags">
        <span
          v-for="(type, index) in readyToCallProspect.jobTypes"
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
  name: 'ReadyToCallDisplay',
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
    },
    formatDate (dateString) {
      if (!dateString) return ''
      const date = new Date(dateString)

      const month = String(date.getMonth() + 1).padStart(2, '0')
      const day = String(date.getDate()).padStart(2, '0')
      const year = date.getFullYear()

      return `${month}/${day}/${year}`
    },
    goToDetails () {
      this.$router.push(`/prospect-details/${this.readyToCallProspect.jobId}`)
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
  .ready-to-call-container {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    cursor: pointer;
  }
  .ready-to-call-container:hover {
    background-color: #f5f5f5;
  }
  .ready-to-call-container > .grid {
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
