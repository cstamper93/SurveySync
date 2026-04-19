import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addClient (client) {
    return http.post('/add-client', client)
  },

  getClientById (id) {
    return http.get(`/client/${id}`)
  },

  getClientByName (first, last) {
    return http.get(`/client/name/${first}/${last}`)
  },

  getClientsByJobId (jobId) {
    return http.get(`client-name/${jobId}`)
  },

  getAllClients () {
    return http.get('/clients')
  },

  editClient (client) {
    return http.put('/client', client)
  },

  deleteClient (id) {
    return http.delete(`/client/${id}`)
  }
}
