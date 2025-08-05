import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addClient (client) {
    return http.post('/add-client', client)
  }
}
