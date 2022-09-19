
const app = Vue.
    createApp({
        data() {
            return {
                select: "selectStep1",
                productStorage:[],
                buy:[],
                caba:"",
                amba:"",
                interior:""
            }
        },
        created() {
            this.productStorage = JSON.parse(localStorage.getItem('products'))
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
                axios.post('/api/bills',this.productStorage)
                .then(() => {
                    this.productStorage = []
                })
            },
            // selectDelivery(){
            //     this.productStorage.forEach(product => {
            //         if(this.caba == "CABA"){
            //             let products = {
            //                 id: product.id,
            //                 name: product.name,
            //                 author: product.author,
            //                 releaseDate: product.releaseDate,
            //                 brand: product.brand,
            //                 description: product.description,
            //                 image: [product.image],
            //                 genres: [product.genres],
            //                 stock: product.stock,
            //                 price: product.price,
            //                 firstHand: product.firstHand,
            //                 productType: product.productType,
            //                 quantity:product.quantity,
            //                 delivery:"AMBA"
            //             }
            //             this.buy.push(products)
            //             localStorage.setItem("buy",this.buy)
            //         }
                    
            //     });
            // }
        },
        computed: {
            totalAPagar() {
                return this.formattedNumber(this.productStorage.reduce((acc, item) => acc + item.quantity * item.price, 0));
            }
            
        }
    }).mount('#app');