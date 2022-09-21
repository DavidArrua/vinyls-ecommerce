const app = Vue.

createApp({
    data() {
        return {
            products: [],
            productId:[],
            client:{},
            verifired:false,
        }
    },

    created(){
        axios.get("/api/clients/current")
            .then(response =>{
                this.client = response.data;
                this.verifired = this.client.validation
            })

    },
    methods: {
        formattedNumber(balance){
            return balance = new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}).format(balance)
        },
    },
}).mount('#app');

