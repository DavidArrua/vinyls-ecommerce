const app = Vue.

createApp({
    data() {
        return {
            products : [],
        }
    },

    created(){
        axios.get("/api/products")
            .then(response => {
                this.products = response.data;
            })
            .catch((error) =>{
                console.log(error);
            });
        axios.get("/api/loans")
        .then(response => {
            this.loans = response.data
        })
    },
    methods: {
        
    },
}).mount('#app');