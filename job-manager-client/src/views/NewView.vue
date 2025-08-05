<template>
  <div class="container">
    <h1>New Prospect</h1>
    <form class="prospect-form">

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
        />
        <label for="lastName"
        class="input-label"
        >Last Name: </label>
        <input
        type="text"
        id="lastName"
        class="input-box"
        placeholder="Last Name"
        />
        <label for="company"
        class="input-label"
        >Company: </label>
        <input
        type="text"
        id="company"
        class="input-box"
        placeholder="Company"
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
        />
        <label for="homePhoneNumber"
        class="input-label"
        >Home Phone Number: </label>
        <input
        type="text"
        id="homePhoneNumber"
        class="input-box"
        placeholder="Home Phone Number"
        />
        <label for="workPhoneNumber"
        class="input-label"
        >Work Phone Number: </label>
        <input
        type="text"
        id="workPhoneNumber"
        class="input-box"
        placeholder="Work Phone Number"
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
        />
        <label for="altEmail"
        class="input-label"
        >Alternate Email Address: </label>
        <input
        type="text"
        id="altEmail"
        class="input-box"
        placeholder="Alternate Email"
        />
        </div>
        </div>

        <h3>Billing Info</h3>
        <div class="billing-info">
        <label for="billingAddress"
        class="input-label"
        >Billing Address: </label>
        <input
        type="text"
        id="billingAddress"
        class="input-box"
        placeholder="Billing Address"
        />
        <label for="billingTown"
        class="input-label"
        >Billing Town: </label>
        <input
        type="text"
        id="billingTown"
        class="input-box"
        placeholder="Billing Town"
        />
        <label for="billingState"
        class="input-label"
        >Billing State: </label>
        <input
        type="text"
        id="billingState"
        class="input-box"
        placeholder="Billing State"
        />
        <label for="billingZip"
        class="input-label"
        >Billing Zip: </label>
        <input
        type="text"
        id="billingZip"
        class="input-box"
        placeholder="Billing Zip"
        />
        </div>

        <h3>Client Notes</h3>
        <button class="add-note-btn">Add Note</button>
        <textarea v-if="addNote" class="input-box"
        id="clientNotes"
        cols="30"
        rows="10"
        placeholder="Put client notes here"
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
      }
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
    margin-bottom: 15px;
  }

  button {
    width: 150px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
