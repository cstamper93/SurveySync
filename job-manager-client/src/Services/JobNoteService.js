import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  createJobNote (jobNote) {
    http.post('/job-note', jobNote)
  },

  getNoteById (id) {
    http.get(`/job-note-by-id/${id}`)
  },

  getNotesByJob (jobId) {
    http.get(`/job-notes-by-job/${jobId}`)
  },

  editNote (note) {
    http.put('/job-note', note)
  },

  deleteNote (id) {
    http.delete(`/job-note/${id}`)
  },

  deleteNotesByJob (jobId) {
    http.delete(`/job-notes/${jobId}`)
  }

}
