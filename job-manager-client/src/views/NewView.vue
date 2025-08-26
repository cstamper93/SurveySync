<template>
  <div class="container">
    <h1>New Prospect</h1>
    <form class="prospect-form" @submit.prevent="addClient">

        <h2>Client Details</h2>

        <div class="flex-row">
        <div class="flex-group">

        <label for="firstName"
        class="input-label"
        >Name: </label>
        <input
        type="text"
        id="firstName"
        class="input-box"
        placeholder="First Name"
        v-model="newClient.firstName"
        />
        <input
        type="text"
        id="lastName"
        class="input-box"
        placeholder="Last Name"
        v-model="newClient.lastName"
        />

        <label for="company"
        class="input-label"
        >Company: </label>
        <input
        type="text"
        id="company"
        class="input-box"
        placeholder="Company"
        v-model="newClient.company"
        />
        </div>

        <div class="flex-group">
        <label for="cellPhoneNumber"
        class="input-label"
        >Phone: </label>
        <input
        type="text"
        id="cellPhoneNumber"
        class="input-box"
        placeholder="Cell Phone"
        v-model="newClient.cellPhone"
        />

        <div class="flex-group">
        <input
        type="text"
        id="workPhone"
        class="input-box"
        placeholder="Home Phone"
        v-model="newClient.homePhone"
        />

        <input
        type="text"
        id="workPhone"
        class="input-box"
        placeholder="Work Phone"
        v-model="newClient.workPhone"
        />
        </div>
        </div>

        <div class="flex-group">
        <label for="clientEmail"
        class="input-label"
        >Email Address: </label>
        <input
        type="text"
        id="clientEmail"
        class="input-box"
        placeholder="Email Address"
        v-model="newClient.clientEmail"
        />
        <input
        type="text"
        id="clientEmail"
        class="input-box"
        placeholder="Alternate Email"
        v-model="newClient.altEmail"
        />

        </div>
        </div>

        <button class="add-billing-btn" v-if="!addBilling"
        @click.prevent="addBilling = !addBilling">+ Add Billing Info</button>
        <button class="hide-billing-btn" v-if="addBilling"
        @click.prevent="addBilling = !addBilling">- Hide Billing Info</button>

        <div v-if="addBilling" class="billing-info">
        <div class="billing-field">
        <label for="billingAddress"
        class="input-label"
        >Billing Address: </label>
        <input
        type="text"
        id="billingAddress"
        class="input-box"
        placeholder="Billing Address"
        v-model="newClient.billingAddress"
        />
        </div>

        <div class="billing-field">
        <label for="billingTown"
        class="input-label"
        >Billing Town: </label>
        <input
        type="text"
        id="billingTown"
        class="input-box"
        placeholder="Billing Town"
        v-model="newClient.billingTown"
        />
        </div>

        <div class="billing-field">
        <label for="billingState"
        class="input-label"
        >Billing State: </label>
        <input
        type="text"
        id="billingState"
        class="input-box"
        placeholder="Billing State"
        v-model="newClient.billingState"
        />
        </div>

        <div class="billing-field">
        <label for="billingZip"
        class="input-label"
        >Billing Zip: </label>
        <input
        type="text"
        id="billingZip"
        class="input-box"
        placeholder="Billing Zip"
        v-model="newClient.billingZip"
        />
        </div>
        </div>

        <button class="add-note-btn" v-if="!addNote" @click="addNote = !addNote">+Add Client Note</button>
        <button class="add-note-btn" v-if="addNote" @click="addNote = !addNote">Cancel</button>
        <textarea v-if="addNote" class="input-box"
        id="clientNotes"
        cols="30"
        rows="10"
        placeholder="Put client notes here"
        v-model="newClient.clientNotes"
        ></textarea>

        <h2 class="property-details-title">Property Details</h2>

        <div class="property-location">
        <div class="owner-name">
        <label for="ownerFirstName"
        class="input-label"
        >Owner Name: </label>
        <input type="text"
        id="ownerFirstName"
        class="input-box"
        placeholder="First Name"
        v-model="newProperty.ownerFirstName" />

        <input type="text"
        id="ownerLastName"
        class="input-box"
        placeholder="Last Name"
        v-model="newProperty.ownerLastName" />
        </div>

        <div class="flex-column">
        <label for="address"
        class="input-label"
        >Property Address: </label>
        <input type="text"
        id="address"
        class="input-box"
        v-model="newProperty.address" />

        <label for="town"
        class="input-label"
        >Town: </label>
        <input type="text"
        id="town"
        class="input-box"
        v-model="newProperty.town" />
        </div>

        <div class="state-zip-county">
        <label for="state"
        class="input-label"
        >State: </label>
        <input type="text"
        id="state"
        class="input-box"
        v-model="newProperty.state" />

        <label for="zip"
        class="input-label"
        >Zip: </label>
        <input type="text"
        id="zip"
        class="input-box"
        v-model="newProperty.zip" />

        <label for="county"
        class="input-label"
        >County: </label>
        <input type="text"
        id="county"
        class="input-box"
        v-model="newProperty.county" />
        </div>
        </div>

        <div class="subdivision-container">
        <label for="subdivision"
        class="input-label"
        >Subdivision: </label>
        <input type="text"
        id="subdivision"
        class="input-box"
        v-model="newProperty.subdivision" />

        <label for="lotNum"
        id="lot-label"
        class="input-label"
        >Lot: </label>
        <input type="text"
        id="lotNum"
        class="input-box"
        v-model="newProperty.lotNum" />
        </div>

        <div class="deed-map-container">
        <label for="deed1"
        class="input-label"
        >Deed 1: </label>
        <input type="text"
        id="deed1"
        class="input-box"
        placeholder="book/page"
        v-model="newProperty.deed1" />

        <label for="map1"
        class="input-label"
        >Map 1: </label>
        <input type="text"
        id="map1"
        class="input-box"
        placeholder="book/page"
        v-model="newProperty.map1" />
        </div>

        <div class="deed-map-container">
        <label for="deed2"
        class="input-label"
        >Deed 2: </label>
        <input type="text"
        id="deed2"
        class="input-box"
        placeholder="book/page"
        v-model="newProperty.deed2" />

        <label for="map2"
        class="input-label"
        >Map 2: </label>
        <input type="text"
        id="map2"
        class="input-box"
        placeholder="book/page"
        v-model="newProperty.map2" />
        </div>

        <div class="deed-map-container">
        <label for="deed3"
        class="input-label"
        >Deed 3: </label>
        <input type="text"
        id="deed3"
        class="input-box"
        placeholder="book/page"
        v-model="newProperty.deed3" />

        <label for="map3"
        class="input-label"
        >Map 3: </label>
        <input type="text"
        id="map3"
        class="input-box"
        placeholder="book/page"
        v-model="newProperty.map3" />
        </div>

        <label for="perimeter"
        class="input-label"
        >Perimeter: </label>
        <input type="number"
        id="perimeter"
        class="input-box"
        placeholder="ex: 500'"
        v-model="newProperty.perimeter" />

        <label for="acreage"
        class="input-label"
        >Acreage: </label>
        <input type="number"
        id="acreage"
        class="input-box"
        placeholder="ex: 1.5 acres"
        v-model="newProperty.acreage" />
        <p>acres</p>

        <label for="driveTime"
        class="input-label"
        >Drive Time: </label>
        <input type="time"
        id="driveTime"
        class="input-box"
        v-model="newProperty.driveTime" />

        <label for="pid"
        class="input-label"
        >Parcel ID: </label>
        <input type="text"
        id="pid"
        class="input-box"
        v-model="newProperty.pid" />

        <label for="pin"
        class="input-label"
        >PIN / REID: </label>
        <input type="text"
        id="pin"
        class="input-box"
        v-model="newProperty.pin" />

        <label for="township"
        class="input-label"
        >Township: </label>
        <input type="text"
        id="township"
        class="input-box"
        v-model="newProperty.township" />

        <button class="add-note-btn" v-if="!addPropNote" @click.prevent="addPropNote = !addPropNote">+ Property Note</button>
        <button class="add-note-btn" v-if="addPropNote" @click.prevent="addPropNote = !addPropNote">Cancel</button>
        <textarea v-if="addPropNote" class="input-box"
        id="propNotes"
        cols="30"
        rows="10"
        placeholder="Put property notes here"
        v-model="newProperty.propNotes"
        ></textarea>

        <h2>Job Details</h2>

        <label for="billingClient"
        class="input-label"
        >Client to Bill: </label>
        <input type="text"
        id="billingClient"
        class="input-box"
        v-model="newJob.billingClientId" />

        <label for="markLinesLength"
        class="input-label"
        >Lines to mark (ft): </label>
        <input type="number"
        id="markLinesLength"
        class="input-box"
        v-model="newJob.markLinesLength" />

        <label for="jobDescription"
        class="input-label"
        >Description: </label>
        <textarea class="input-box"
        id="jobDescription"
        cols="30"
        rows="10"
        placeholder="Put job description here"
        v-model="newJob.description"
        ></textarea>

        <label for="housePlanName"
        class="input-label"
        >House Plan Name: </label>
        <input type="text"
        id="housePlanName"
        class="input-box"
        v-model="newJob.housePlanName" />

        <label for="readyDate"
        class="input-label"
        >Job Ready Date: </label>
        <input type="date"
        id="readyDate"
        class="input-box"
        v-model="newJob.readyDate" />

        <label for="completeByDate"
        class="input-label"
        >Complete By Date: </label>
        <input type="date"
        id="completeByDate"
        class="input-box"
        v-model="newJob.completeByDate" />

        <h2>Job Type:</h2>

        <label for="jobType"
        class="input-label"
        >Job Type: </label>
        <input type="text"
        id="jobType"
        class="input-box"
        v-model="jobType.jobType" />

        <label for="price"
        class="input-label"
        >Price: </label>
        <input type="text"
        id="price"
        class="input-box"
        v-model="jobType.price" />

        <button class="add-type-btn" v-if="!addType"
        @click.prevent="addType = !addType"
        >+Add Type</button>
        <button class="add-type-btn" v-if="addType"
        @click.prevent="addType = !addType"
        >Cancel</button>

        <button class="new-prospect-btn" type="submit">+Add Prospect</button>
    </form>
  </div>
</template>

<script>
// FS + EPS: lines to be marked
// Recombination: two or more properties
// Division: acres to be divided, new lot lines to be marked
// ALTA: table A

import ClientService from '../Services/ClientService.js'
import PropertyService from '../Services/PropertyService.js'
import JobCardService from '../Services/JobCardService.js'
import JobTypeService from '../Services/JobTypeService.js'
import JobNoteService from '../Services/JobNoteService.js'

export default {
  name: 'NewView',
  data () {
    return {
      newClient: {
        firstName: null,
        lastName: null,
        cellPhone: null,
        homePhone: null,
        workPhone: null,
        email: null,
        altEmail: null,
        company: null,
        billingAddress: null,
        billingTown: null,
        billingState: null,
        billingZip: null,
        clientNotes: null
      },
      clientArr: {},
      addPhone: false,
      addEmail: false,
      addBilling: false,
      addNote: false,
      newProperty: {
        ownerFirstName: null,
        ownerLastName: null,
        address: null,
        town: null,
        state: 'NC',
        zip: null,
        county: null,
        deed1: null,
        deed2: null,
        deed3: null,
        map1: null,
        map2: null,
        map3: null,
        perimeter: null,
        acreage: null,
        driveTime: null,
        subdivision: null,
        pid: null,
        pin: null,
        township: null,
        lotNum: null,
        propNotes: null
      },
      addPropNote: false,
      newJob: {
        prospectId: null,
        activeJobId: null,
        billingClientId: null,
        intakeDate: null,
        intakeTime: null,
        markLinesLength: null,
        description: null,
        housePlanName: null,
        jobStatus: 'Needs Research',
        readyDate: null,
        completeByDate: null,
        contractSentDate: null,
        contractSigned: false,
        contractSignedDate: null,
        lettersSent: null,
        lettersSentDate: null,
        isPlotted: false,
        plottedBy: null
      },
      jobType: {
        jobId: null,
        jobType: null,
        price: null,
        typeDescription: null,
        estimatedFieldHours: null
      },
      jobNote: {
        noteContent: null,
        userId: null,
        dateCreated: null,
        timeCreated: null,
        jobId: null
      },
      addType: false
    }
  },
  methods: {
    addClient () {
      ClientService.addClient(this.newClient).then((response) => {
        if (response.status === 201) {
          alert('New client added.')
          this.$router.go()
        }
      })
    },
    addProperty () {
      PropertyService.addProperty(this.newProperty).then((response) => {
        if (response.status === 201) {
          alert('New property added.')
        }
      })
    },
    addJobCard () {
      JobCardService.addJobCard(this.newJob).then((response) => {
        if (response.status === 201) {
          alert('new job added.')
        }
      })
    },
    addJobType () {
      JobTypeService.addJobType(this.jobType).then((response) => {
        if (response.status === 201) {
          alert('job type added.')
        }
      })
    },
    createJobNote () {
      JobNoteService.createJobNote(this.jobNote).then((response) => {
        if (response.status === 201) {
          alert('Job note added.')
        }
      })
    }
  }

}
</script>

<style>

  .container {
    margin-left: 20%;
    text-align: center;
  }

  .prospect-form {
    display: flex;
    flex-direction: column;
  }

  .input-box {
    margin-left: auto;
    margin-right: auto;
    width: 200px;
    margin-bottom: 15px;
  }

  .flex-row {
    display: flex;
  }

  .flex-group {
    display: flex;
    flex-direction: column;
    margin-left: auto;
    margin-right: auto;
  }

  .billing-info {
    display: flex;
    justify-content: space-around;
    margin-bottom: 15px;
  }

  .billing-field {
    display: flex;
    flex-direction: column;
  }

  button {
    width: 150px;
    margin-left: auto;
    margin-right: auto;
  }

  .owner-name {
    display: flex;
    flex-direction: column;
  }

  .property-location {
    display: flex;
    justify-content: space-around;
    margin-left: 10rem;
    margin-right: 10rem;
  }

  .state-zip-county {
    display: flex;
    flex-direction: column;
  }

  .flex-row {
    display: flex;
  }

  .flex-column {
    display: flex;
    flex-direction: column;
  }

  #state {
    width: 25px;
  }

  #zip {
    width: 50px;
  }

  #county {
    width: 80px;
  }

  .add-note-btn, .add-billing-btn, .hide-billing-btn {
    margin-top: 20px;
  }

  .property-details-title {
    margin-top: 50px;
  }

  #lot-label {
    margin-left: 20px;
  }

</style>
