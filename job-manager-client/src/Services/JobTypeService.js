import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addJobType (jobType) {
    http.post('/add-job-type', jobType)
  },

  getJobTypeById (id) {
    http.get(`/job-type/${id}`)
  },

  getJobTypeByJob (jobId) {
    http.get(`/job-types/${jobId}`)
  },

  editJobType (jobType) {
    http.put('/job-type', jobType)
  },

  deleteJobType (id) {
    http.delete(`/job-type/${id}`)
  },

  deleteJobTypesByJob (jobId) {
    http.delete(`/job-type-job/${jobId}`)
  }

}
