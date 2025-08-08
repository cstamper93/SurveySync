import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addProperty (property) {
    return http.post('/add-property', property)
  }
}
