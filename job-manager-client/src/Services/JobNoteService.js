import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  createJobNote (jobNote) {
    return http.post('/job-note', jobNote)
  },

  getNoteById (id) {
    return http.get(`/job-note-by-id/${id}`)
  },

  getNotesByJob (jobId) {
    return http.get(`/job-notes-by-job/${jobId}`)
  },

  editNote (note) {
    return http.put('/job-note', note)
  },

  deleteNote (id) {
    return http.delete(`/job-note/${id}`)
  },

  deleteNotesByJob (jobId) {
    return http.delete(`/job-notes/${jobId}`)
  }

}
