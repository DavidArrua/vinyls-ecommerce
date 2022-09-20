
const app = Vue.
    createApp({
        data() {
            return {
                select: "selectStep1",
                productStorage:[],
                buy:[]
            }
        },
        created() {
            this.productStorage = JSON.parse(localStorage.getItem('products'))
            let trolleyInStorage = JSON.parse(localStorage.getItem('buy'))
            if(trolleyInStorage){
                    this.buy = trolleyInStorage
            }
        },
        methods: {
            selectStep (value){      
                this.select = value
                var valueStep = document.getElementById(value)
                valueStep.classList.remove("filterSelect") 
            },
            backStep (value) {
                var valueStep = document.getElementById(value)
                this.select = value
                if ( this.select == 'selectStep1') {
                    var valueStep = document.getElementById('selectStep2')
                    valueStep.classList.add("filterSelect") 

                } 
                if ( this.select == 'selectStep2') {
                    var valueStep = document.getElementById('selectStep3')
                    valueStep.classList.add("filterSelect") 

                }                      
             
            },
            formattedNumber(balance){
                return balance = new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}).format(balance)
            },
            sendProducts(){
                axios.post('/api/bills',this.buy)
                .then(() => {
                    this.productStorage = localStorage.removeItem("products")
                    this.buy = localStorage.removeItem("buy")
                })
            },
            selectDelivery(place){
                this.productStorage.forEach(product => {
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
                            quantity:product.quantity,
                            delivery:place
                        }
                        this.buy.push(products)
                        localStorage.setItem("buy",JSON.stringify(this.buy))
                });
            }
        },
        computed: {
            totalAPagar() {
                if(this.productStorage != null){
                    return this.formattedNumber(this.productStorage.reduce((acc, item) => acc + item.quantity * item.price, 0));
                }
            }
            
        }
    }).mount('#app');