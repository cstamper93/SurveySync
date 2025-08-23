import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addProperty (property) {
    return http.post('/add-property', property)
  },

  getPropertyById (id) {
    return http.get(`/property/${id}`)
  },

  getPropertiesByJob (jobId) {
    return http.get(`/properties/${jobId}`)
  },

  fixProperty (property) {
    return http.put('/property')
  },

  removeProperty (id) {
    return http.delete(`/property/${id}`)
  }
}
