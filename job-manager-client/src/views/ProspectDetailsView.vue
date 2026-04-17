<template>
  <div>
    <h1>Client</h1>
    <p>{{ jobDetails.jobStatus }}</p>
    <h1>Property</h1>
  </div>
</template>

<script>
import JobCardService from "@/Services/JobCardService";
// import ClientService from "@/Services/ClientService";

  export default {
    name: 'ProspectDetails',
    data() {
      return {
        jobDetails: {
          prospectId: null,
          activeJobId: null,
          billingClientId: null,
          createdAt: null,
          markLinesLength: null,
          jobDescription: '',
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
        client: {
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
        property: {
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
        }
      }
    },
    created() {
      JobCardService.getCardById(this.$route.params.id).then((response) => {
        this.jobDetails = response.data;
      })
    }
  }
</script>

<style scoped>
  p {
    text-align: center;
  }
</style>
