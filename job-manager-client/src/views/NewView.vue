<template>
  <div class="container">
    <h1>New Prospect</h1>
    <form class="prospect-form" @submit.prevent="addClient">

        <h2>Client Details</h2>
        <div class="flex-row">
        <div class="flex-group">

        <label for="firstName"
        class="input-label"
        >First Name: </label>
        <input
        type="text"
        id="firstName"
        class="input-box"
        placeholder="First Name"
        v-model="newClient.firstName"
        />

        <label for="lastName"
        class="input-label"
        >Last Name: </label>
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
        >Cell Phone Number: </label>
        <input
        type="text"
        id="cellPhoneNumber"
        class="input-box"
        placeholder="Cell Phone Number"
        v-model="newClient.cellPhoneNumber"
        />

        <label for="homePhoneNumber"
        class="input-label"
        >Home Phone Number: </label>
        <input
        type="text"
        id="homePhoneNumber"
        class="input-box"
        placeholder="Home Phone Number"
        v-model="newClient.homePhoneNumber"
        />

        <label for="workPhoneNumber"
        class="input-label"
        >Work Phone Number: </label>
        <input
        type="text"
        id="workPhoneNumber"
        class="input-box"
        placeholder="Work Phone Number"
        v-model="newClient.workPhoneNumber"
        />
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

        <label for="altEmail"
        class="input-label"
        >Alternate Email Address: </label>
        <input
        type="text"
        id="altEmail"
        class="input-box"
        placeholder="Alternate Email"
        v-model="newClient.altEmail"
        />
        </div>
        </div>

        <h3>Billing Info</h3>
        <div class="billing-info">
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

        <h3>Client Notes</h3>
        <button class="add-note-btn" v-if="!addNote" @click="addNote = !addNote">Add Note</button>
        <button class="add-note-btn" v-if="addNote" @click="addNote = !addNote">Cancel</button>
        <textarea v-if="addNote" class="input-box"
        id="clientNotes"
        cols="30"
        rows="10"
        placeholder="Put client notes here"
        v-model="newClient.firstName"
        ></textarea>

        <h2>Job Details</h2>

        <button class="new-prospect-btn" type="submit">Add Prospect</button>
    </form>
  </div>
</template>

<script>
import ClientService from '../Services/ClientService.js'
export default {
  name: 'NewView',
  data () {
    return {
      newClient: {
        firstName: null,
        lastName: null,
        company: null,
        cellPhoneNumber: null,
        homePhoneNumber: null,
        workPhoneNumber: null,
        billingAddress: null,
        billingTown: null,
        billingState: null,
        billingZip: null,
        clientEmail: null,
        altEmail: null,
        clientNotes: null
      },
      addNote: false
    }
  },
  methods: {
    addClient () {
      ClientService.addClient(this.newClient).then((response) => {
        if (response.status === 201) {
          alert('New client added.')
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
</style>
