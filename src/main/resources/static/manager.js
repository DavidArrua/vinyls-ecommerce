const app = Vue.
    createApp({
        data() {
            return {
                products: [],
                Name: "",
                Author: "",
                releaseDate: "",
                Brand: "",
                Image: "",
                Genres: "",
                Stock: "",
                Price: "",
                State: "",
                Type: "",
                Detail: "",
                nameModify: "",
                stockModify: 0
            }

        },

        created() {
            this.loadData();
        },


        methods: {
            addProduct() {
                axios
                    .post("/api/add/vinyl/products", `name=${this.Name}&author=${this.Author}&description=${this.Detail}&releaseDate=${this.releaseDate}
                    &image=${this.Image}&genres=${this.Genres}&stock=${this.Stock}&price=${this.Price}&firstHand=${this.State}&productType=${this.Type}&brand=${this.Brand}`)
                    .then(response => location.reload)
                    .then(()=> this.loadData)
                    .catch(error => console.log(error))
            },

            loadData(){
                axios
                .get("/api/products")
                .then(response => {
                    this.products = response.data;
                    console.log(this.products);
                })
                .catch(function (error) {

                })
            },

            modifyProduct(){
                axios.patch("/api/products/edit", `name=${this.nameModify}&stock=${this.stockModify}`)
                .then(response => location.reload)
                .catch(error => console.log(error))
            },
            logOut() {
                Swal.fire({
                    title: 'Are you sure?',
                    text: "Do you want to exit the app?",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: "Yes, I'm sure!",
                    showCloseButton: true,
                }).then((result) => {
                    if (result.isConfirmed) {
                        axios.post('/api/logout')
                            .then(response => location.href = '/web/index.html')
                            .then(response => location.href = '/web/index.html')
                            .catch(function (error) {
                                alert(error);
                            })
                    }
                })
            }
            
        }
    }).mount('#app')