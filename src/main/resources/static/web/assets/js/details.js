let urlParams = new URLSearchParams(window.location.search);
let urlName = urlParams.get("id");

const app = Vue.

createApp({
    data() {
        return {
            products: [],
            productId:[],
              productsFilter: [],
            selectProducts: [],
            trolleyInStorage: [],
            trolley: []

        }
    },

    created(){
        axios.get("/api/products")
            .then(response => {
                this.products = response.data;
                this.productId = this.products.find(product => product.id == urlName)
                console.log(this.productId.productType)
                this.selectProducts = this.productsFilter;
                let trolleyInStorage = JSON.parse(localStorage.getItem("products"));
                if (trolleyInStorage) {
                    this.trolley = trolleyInStorage;
                }
            })
            .catch((error) =>{
                console.log(error);
            });

    },
    methods: {
        formattedNumber(balance){
            return balance = new Intl.NumberFormat('en-US', {style: 'currency', currency: 'USD'}).format(balance)
        },

        trolleyPurchase(product) {
            let products = this.trolley;
            if (products != undefined) {
                products.quantity++;
                localStorage.setItem("products", JSON.stringify(this.trolley));
            } else {
                let products = {
                    id: product.id,
                    name: product.name,
                    author: product.author,
                    releaseDate: product.releaseDate,
                    brand: product.brand,
                    description: product.description,
                    image: [product.image],
                    genres: [product.genres],
                    // stock: product.stock,
                    // totalStock: product.stock,
                    price: product.price,
                    firstHand: product.firstHand,
                    productType: product.productType,
                    quantity: 1,
                };
                this.trolley.push(products);
                localStorage.setItem("products", JSON.stringify(this.trolley));
            }
            // product.stock--;

            Swal.fire({
                position: "top-end",
                icon: "success",
                title: "Producto agregado",
                showConfirmButton: false,
                timer: 1900,
            })
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
        },

        
    },
}).mount('#app');



