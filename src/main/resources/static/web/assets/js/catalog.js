const app = Vue.

createApp({
    data() {
        return {
            products : [],
            orderProduct:"order",
            genresValue:"allGenere",
            selectGenres:[],
            genres:[],
            productType:"allType",
            productsFilter:[],
            input:"",
            condition:"allCondition",
            carrito:[{
                "id":4,
                "quantity":2,
            },
            {
                "id":2,
                "quantity":2
            }],
            delivery:"CABA"

        }
    },

    created(){
        axios.get("/api/products")
            .then(response => {
                this.products = response.data;
                this.genresFilter()  
                this.productsFilter = this.products
            })
            .catch((error) =>{
                console.log(error);
            });
    },
    methods: {
        orderProducts(){
            if(this.orderProduct == "order"){
                this.productsFilter = this.products
            }
            if(this.orderProduct == "precioMasBajo"){
                return this.productsFilter.sort((a, b) => a.price - b.price)
            }
            if(this.orderProduct == "precioMasAlto"){
                return this.productsFilter.sort((a, b) => b.price  - a.price )
            }
            if(this.orderProduct == "laconchadetumadre"){
                return this.productsFilter.sort()
            }
            if(this.orderProduct == "zA"){
                return this.productsFilter.sort((a, b) => b.name  - a.name)
            }
        },
        genresFilter(){
            this.products.forEach(genere => {
                genere.genres.forEach(element => {
                    if(!this.selectGenres.includes(element)){
                        this.selectGenres.push(element)
                    }
                });
            })
        },
        orderGenres(genresValue){
            this.productsFilter = []
            if(genresValue == "allGenere"){
                return this.productsFilter = this.products
            }
            this.products.forEach(genere => {
                if(!genere.genres.includes(genresValue)){
                    return 
                }
                this.productsFilter.push(genere)
            })
            
        },
        orderByType(productType){
            this.productsFilter = []
            if(productType == "allType"){
                return this.productsFilter = this.products
            }
            this.products.forEach(genere => {
                if(!genere.productType.includes(productType)){
                    return 
                }
                this.productsFilter.push(genere)
            })
        },
        allProducts(){
            this.productsFilter = this.products
        },
        newProducts(){
            let newProductsByDate = []
            this.products.forEach(date =>{
                if(parseInt(date.releaseDate) >= 2020){
                    newProductsByDate.push(date)
                }
            })
            this.productsFilter = newProductsByDate;
        },
        mostSold(){
            let productsByStock = []
            this.products.forEach(stock =>{
                if(parseInt(stock.stock) <= 7){
                    productsByStock.push(stock)
                }
            })
            this.productsFilter = productsByStock;
        },
        formattedNumber(balance){
            return balance = new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}).format(balance)
        },
        productCondition(condition){
            this.productsFilter = []
            if(condition == "allCondition"){
                return this.productsFilter = this.products
            }
            if(condition == "new"){
                let state = this.products.filter(product => product.firstHand == true)
                return this.productsFilter = state
            }
            if(condition == "used"){
                let state =  this.products.filter(product => product.firstHand == false)
                return this.productsFilter = state
            }
        },
        sendProducts(){
            axios.post('/api/bills',this.carrito)
            .then(alert("anda"))
        }

    },
    computed: {
        filterSerch() {
            this.productsFilter = this.products.filter(item => item.name.toLowerCase().includes(this.input.toLowerCase()))
        }
    }
}).mount('#app');