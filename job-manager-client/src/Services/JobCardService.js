import axios from 'axios'

const http = axios.create({
  baseURL: 'http://localhost:9000'
})

export default {

  addJobCard (jobCard) {
    return http.post(`/add-card}`, jobCard)
  },

  addClientToJoinTable (jobId, clientId) {
    return http.post(`/add-job-client/${jobId}/${clientId}`)
  },

  addPropertyToJoinTable (jobId, propertyId) {
    return http.post(`/add-job-prop/${jobId}/${propertyId}`)
  },

  getCardById (jobCardId) {
    return http.get(`/job-card/${jobCardId}`)
  },

  getAllJobCards () {
    return http.get('/job-cards')
  },

  filterCardsByNumber (prospectNum) {
    return http.get(`/job-cards-by-num/${prospectNum}`)
  },

  filterActiveJobsByNumber (num) {
    return http.get(`/active-cards-by-num/${num}`)
  },

  editCard (card) {
    return http.put('/job-cards', card)
  },

  deleteCard (cardId) {
    return http.delete(`/job-cards/${cardId}`)
  },

  filterByStatus (status) {
    return http.get(`/jobs-by-status/${status}`)
  },

  filterByContractSent (date) {
    return http.get(`/contract-sent/${date}`)
  },

  filterByContractSignedNoLetters () {
    return http.get('/contract-signed')
  },

  filterByLettersSentNotPlotted () {
    return http.get('/letters-sent')
  },

  getJobsByClient (clientId) {
    return http.get(`/clients-jobs/${clientId}`)
  },

  getMatchingJobId (clientId, propertyId) {
    return http.get (`/job-match/${clientId}/${propertyId}`)
  }

}
