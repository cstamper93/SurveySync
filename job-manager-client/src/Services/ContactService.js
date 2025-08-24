import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  storeContact (contact) {
    http.post('/contact', contact)
  },

  fetchContactById (id) {
    http.get(`/contact-id/${id}`)
  },

  fetchAllContacts () {
    http.get('/contact-all')
  },

  fetchContactsByJob (jobId) {
    http.get(`/contact-job/${jobId}`)
  },

  fetchContactsByClient (clientId) {
    http.get(`/contact-client/${clientId}`)
  },

  fetchContactsByUser (userId) {
    http.get(`/contact-user/${userId}`)
  },

  fetchContactsByDate (date) {
    http.get('/contact-date', date)
  },

  updateContact (contact) {
    http.put('/contact', contact)
  },

  deleteContact (id) {
    http.delete(`/contact-single/${id}`)
  },

  deleteContactByJob (jobId) {
    http.delete(`/contact-job/${jobId}`)
  }

}
