<template>
  <div class="page-container">
    <h2>{{ jobDetails.jobStatus }}</h2>
    <h1>Client</h1>
    <client-details
      v-for="client in clients"
      :key="client.clientId"
      :client="client"
    />
    <h1>Properties</h1>
    <property-details
      v-for="property in properties"
      :key="property.propId"
      :property="property"
    />
  </div>
</template>

<script>
import JobCardService from "@/Services/JobCardService";
import ClientService from "@/Services/ClientService";
import PropertyService from "@/Services/PropertyService";
import ClientDetails from "@/components/ClientDetails";
import PropertyDetails from "@/components/PropertyDetails";

  export default {
    name: 'ProspectDetails',
    components: {
      ClientDetails,
      PropertyDetails
    },
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
          clientId: null,
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
        clients: [],
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
        },
        properties: []
      }
    },
    created() {
      console.log(this.$route.params.id)
      JobCardService.getCardById(this.$route.params.id).then((response) => {
        this.jobDetails = response.data;
      })
      ClientService.getClientsByJobId(this.$route.params.id).then((response) => {
        this.clients = response.data;
      })
      PropertyService.getPropertiesByJob(this.$route.params.id).then((response) => {
        this.properties = response.data;
      })
    }
  }
</script>

<style scoped>
  .page-container {
    text-align: center;
  }
</style>
