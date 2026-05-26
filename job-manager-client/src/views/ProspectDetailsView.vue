<template>
  <div class="page-container">
    <h2>Status: {{ jobDetails.jobStatus }}</h2>
    <div class="client-list">
      <h2>Client:</h2>
      <client-details
        v-for="client in clients"
        :key="client.clientId"
        :client="client"
      />
    </div>
    <h2>Properties</h2>
    <property-details
      v-for="property in properties"
      :key="property.propId"
      :property="property"
    />
    <h2>Description</h2>
    <p>{{ jobDetails.jobDescription }}</p>
    <job-type-details
      v-for="jobType in jobTypes"
      :key="jobType.jobTypeId"
      :jobType="jobType"
    />

  </div>
</template>

<script>
import JobCardService from "@/Services/JobCardService";
import ClientService from "@/Services/ClientService";
import PropertyService from "@/Services/PropertyService";
import ClientDetails from "@/components/ClientDetails";
import PropertyDetails from "@/components/PropertyDetails";
import JobTypeService from "@/Services/JobTypeService";
import JobTypeDetails from "@/components/JobTypeDetails";

  export default {
    name: 'ProspectDetails',
    components: {
      ClientDetails,
      PropertyDetails,
      JobTypeDetails
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
        properties: [],
        jobTypes: []
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
      JobTypeService.getJobTypesByJob(this.$route.params.id).then((response) => {
        this.jobTypes = response.data;
        })
    }
  }
</script>

<style scoped>
  .page-container {
    text-align: center;
  }
  .client-list {
    display: flex;
    align-items: center;
    justify-content: center;
  }
</style>
