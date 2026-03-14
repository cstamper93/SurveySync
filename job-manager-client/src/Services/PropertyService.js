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

  getPropertyByAddress (address, town) {
    return http.get(`/property/${address}/${town}`)
  },

  getPropertyByPin (pin, pid) {
    return http.get(`/property/${pin}/${pid}`)
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
