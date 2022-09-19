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
            trolley:[],
            trolleyInStorage:[],
            selectProducts:[],
        }
    },

    created(){
        axios.get("/api/products")
            .then(response => {
                this.products = response.data;
                
                this.genresFilter()  
                this.productsFilter = this.products
                this.selectProducts = this.productsFilter
                let trolleyInStorage = JSON.parse(localStorage.getItem("productos"))
                if(trolleyInStorage){
                    this.trolley = trolleyInStorage
                }
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
        },
        trolleyPurchase(product){
            let products = this.trolley.filter(item => item.id == product.id)[0]
            if(products != undefined){
                products.quantity++
                localStorage.setItem("products",JSON.stringify(this.trolley))
                
            }else{
                let products = {
                    id: product.id,
                    name: product.name,
                    author: product.author,
                    releaseDate: product.releaseDate,
                    brand: product.brand,
                    description: product.description,
                    image: [product.image],
                    genres: [product.genres],
                    stock: product.stock,
                    price: product.price,
                    firstHand: product.firstHand,
                    productType: product.productType,
                    quantity:1,
                    delivery:"CABA"
                }
                this.trolley.push(products)
                localStorage.setItem("products",JSON.stringify(this.trolley))
            }
            product.stock--
        },
        trolleyRemove(product){
            let products = this.trolley.filter(item => item.id == product.id)[0]
            if(products != undefined){
                products.quantity--
                localStorage.setItem("products",JSON.stringify(this.trolley))
                
            }else{
                let products = {
                    id: product.id,
                    name: product.name,
                    author: product.author,
                    releaseDate: product.releaseDate,
                    brand: product.brand,
                    description: product.description,
                    image: [product.image],
                    genres: [product.genres],
                    stock: product.stock,
                    price: product.price,
                    firstHand: product.firstHand,
                    productType: product.productType,
                    quantity:1
                }
                this.trolley.push(products)
                localStorage.setItem("products",JSON.stringify(this.trolley))
            }
            products.stock--
        },
        removeProduct(product){
            let products = this.allProducts.filter(item => item._id == product._id)[0]
            products.stock += product.cantidad
            let productIndice = 0
            this.trolley.forEach((item, i) =>
                item.id == product._id ? (productIndice = i) : null
            );
            this.trolley.splice(productIndice, 1);
            localStorage.setItem("products",JSON.stringify(this.trolley))
        },

    },
    computed: {
        cantidadDeProductos() {
            return this.trolley.reduce((acc, item) => acc + item.quantity, 0)
        },
        totalAPagar() {
            return this.trolley.reduce((acc, item) => acc + item.quantity * item.price, 0);
        },
        filterSerch() {
            this.productsFilter = this.products.filter(item => item.name.toLowerCase().includes(this.input.toLowerCase()))
        }
    }
}).mount('#app');