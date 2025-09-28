import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  getProspectDisplayList (status) {
    return http.get('/prospect-display', status)
  }

}
