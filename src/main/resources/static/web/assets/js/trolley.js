
const app = Vue.
    createApp({
        data() {
            return {
                select: "selectStep1",
                productStorage:[]
            }
        },
        created() {
            // this.productStorage = localStorage.products;   
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
        },
        computed: {
            totalAPagar() {
                return this.formattedNumber(this.productStorage.reduce((acc, item) => acc + item.quantity * item.price, 0));
            }
            
        }
    }).mount('#app');