import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  storeContact (contact) {
    return http.post('/contact', contact)
  },

  fetchContactById (id) {
    return http.get(`/contact-id/${id}`)
  },

  fetchAllContacts () {
    return http.get('/contact-all')
  },

  fetchContactsByJob (jobId) {
    return http.get(`/contact-job/${jobId}`)
  },

  fetchContactsByClient (clientId) {
    return http.get(`/contact-client/${clientId}`)
  },

  fetchContactsByUser (userId) {
    return http.get(`/contact-user/${userId}`)
  },

  fetchContactsByDate (date) {
    return http.get('/contact-date', date)
  },

  updateContact (contact) {
    return http.put('/contact', contact)
  },

  deleteContact (id) {
    return http.delete(`/contact-single/${id}`)
  },

  deleteContactByJob (jobId) {
    return http.delete(`/contact-job/${jobId}`)
  }

}
