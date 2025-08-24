import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addJobCard (jobCard, propertyId, clientId) {
    http.post(`/add-card/${clientId}/${propertyId}`, jobCard)
  },

  getCardById (jobCardId) {
    http.get(`/job-card/${jobCardId}`)
  },

  getAllJobCards () {
    http.get('/job-cards')
  },

  filterCardsByNumber (prospectNum) {
    http.get(`/job-cards-by-num/${prospectNum}`)
  },

  filterActiveJobsByNumber (num) {
    http.get(`/active-cards-by-num/${num}`)
  },

  editCard (card) {
    http.put('/job-cards', card)
  },

  deleteCard (cardId) {
    http.delete(`/job-cards/${cardId}`)
  },

  filterByStatus (status) {
    http.get(`/jobs-by-status/${status}`)
  },

  filterByContractSent (date) {
    http.get(`/contract-sent/${date}`)
  },

  filterByContractSignedNoLetters () {
    http.get('/contract-signed')
  },

  filterByLettersSentNotPlotted () {
    http.get('/letters-sent')
  },

  getJobsByClient (clientId) {
    http.get(`/clients-jobs/${clientId}`)
  }

}
