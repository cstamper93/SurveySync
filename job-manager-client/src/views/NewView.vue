<template>
  <div class="container">
    <h1>New Prospect</h1>
    <form class="prospect-form">
        <h3>Client Details</h3>
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
        <label for="clientNotes"
        class="input-label"
        >Client Notes: </label>
        <textarea class="input-box"
        id="clientNotes"
        cols="30"
        rows="10"
        placeholder="Put client notes here"
        ></textarea>
    </form>
  </div>
</template>

<script>
export default {
  name: 'NewView',
  data () {
    return {}
  }

}
</script>

<style>
  .container {
    margin-left: 20%;
    text-align: center;
  }
</style>
