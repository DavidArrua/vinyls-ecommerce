let urlParams = new URLSearchParams(window.location.search);
let urlName = urlParams.get("id");

const app = Vue.

createApp({
    data() {
        return {
            products: [],
            productId:[]

        }
    },

    created(){
        axios.get("/api/products")
            .then(response => {
                this.products = response.data;
                this.productId = this.products.find(product => product.id == urlName)
                console.log(this.productId.productType)
            })
            .catch((error) =>{
                console.log(error);
            });

    },
    methods: {
        formattedNumber(balance){
            return balance = new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}).format(balance)
        },
    },
}).mount('#app');

