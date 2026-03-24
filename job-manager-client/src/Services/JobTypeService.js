import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addJobType (jobType) {
    return http.post('/add-job-type', jobType)
  },

  getJobTypeById (id) {
    return http.get(`/job-type/${id}`)
  },

  getJobTypesByJob (jobId) {
    return http.get(`/job-types/${jobId}`)
  },

  editJobType (jobType) {
    return http.put('/job-type', jobType)
  },

  deleteJobType (id) {
    return http.delete(`/job-type/${id}`)
  },

  deleteJobTypesByJob (jobId) {
    return http.delete(`/job-type-job/${jobId}`)
  }

}
