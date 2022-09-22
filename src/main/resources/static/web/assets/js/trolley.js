
const app = Vue.
    createApp({
        data() {
            return {
                select: "selectStep1",
                productStorage: [],
                buy: [],
                deliveryPrice: 0,
                verifired: false
            }
        },
        created() {
            axios.get("/api/clients/current")
                .then(response => {
                    this.client = response.data;
                    this.verifired = this.client.validation
                })
            this.productStorage = JSON.parse(localStorage.getItem('products'))
            let trolleyInStorage = JSON.parse(localStorage.getItem('buy'))
            if (trolleyInStorage) {
                this.buy = trolleyInStorage
            }
        },
        methods: {
            selectStep(value) {
                this.select = value
                var valueStep = document.getElementById(value)
                valueStep.classList.remove("filterSelect")
            },
            backStep(value) {
                var valueStep = document.getElementById(value)
                this.select = value
                if (this.select == 'selectStep1') {
                    var valueStep = document.getElementById('selectStep2')
                    valueStep.classList.add("filterSelect")

                }
                if (this.select == 'selectStep2') {
                    var valueStep = document.getElementById('selectStep3')
                    valueStep.classList.add("filterSelect")

                }

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
                            .catch(function (error) {
                                alert(error);
                            })
                    }
                })
            },
            formattedNumber(balance) {
                return balance = new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(balance)
            },
            sendProducts() {
                Swal.fire({
                    title: "¿Finalizar compra?",
                    // text: "Eliminar producto del carrito",
                    icon: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "Finalizar",
                }).then((result) => {
                    if (result.isConfirmed) 
                        axios.post('/api/bills',this.buy)
                            .then(() => {
                                this.productStorage = localStorage.removeItem("products")
                                this.buy = localStorage.removeItem("buy")
                                this.deliveryPrice = 0
                                setTimeout(() => { location.href = "/web/index.html"}, 1500)
                            })
                    
                })
            },
            selectDelivery(place, price) {
                this.deliveryPrice = price
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
                            quantity: product.quantity,
                            delivery: place
                        }
                        this.buy.push(products)
                        localStorage.setItem("buy", JSON.stringify(this.buy))
                })


            },
            trolleyPurchase(product) {
                let products = this.productStorage.filter(item => item.id == product.id)[0]
                if (products != undefined) {
                    products.quantity++
                    localStorage.setItem("products", JSON.stringify(this.productStorage))

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
                        stock: product.stock,
                        totalStock: product.stock,
                        price: product.price,
                        firstHand: product.firstHand,
                        productType: product.productType,
                        quantity: product.quantity,
                        delivery: ""
                    }
                    this.buy.push(products)
                    localStorage.setItem("products", JSON.stringify(this.buy))
                }
                product.stock--

                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Producto agregado',
                    showConfirmButton: false,
                    timer: 1900,
                })

            },
            trolleyRemove(product) {
                let products = this.productStorage.filter(item => item.id == product.id)[0]
                if (products != undefined) {
                    products.quantity--
                    localStorage.setItem("products", JSON.stringify(this.productStorage))

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
                        stock: product.stock,
                        totalStock: product.stock,
                        price: product.price,
                        firstHand: product.firstHand,
                        productType: product.productType,
                        quantity: product.quantity,
                        delivery: ""
                    }
                    this.buy.push(products)
                    localStorage.setItem("products", JSON.stringify(this.buy))
                }
                products.stock++

                Swal.fire({
                    position: "top",
                    icon: "success",
                    title: "Producto removido",
                    showConfirmButton: false,
                    timer: 1500,

                })
            },



            confirmarModal(product) {
                Swal.fire({
                    title: "¿Estas seguro?",
                    text: "Eliminar producto del carrito",
                    icon: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "SI",
                }).then((result) => {
                    if (result.isConfirmed) {
                        let products = this.productStorage.filter(item => item.id == product.id)[0]
                        products.stock += product.quantity
                        let productIndice = 0
                        this.productStorage.forEach((item, i) =>
                            item.id == product.id ? (productIndice = i) : null
                        );
                        this.productStorage.splice(productIndice, 1);
                        localStorage.setItem("products", JSON.stringify(this.buy))
                        Swal.fire("Eliminado!", "El producto fue eliminado.", "success")
                    }
                })
            },


        },
        computed: {
            total() {
                if (this.productStorage != null) {
                    return this.formattedNumber(this.productStorage.reduce((acc, item) => acc + item.quantity * item.price, 0));
                }
            },
            totalAPagar() {
                if (this.productStorage != null) {
                    return this.formattedNumber(this.productStorage.reduce((acc, item) => acc + item.quantity * item.price + this.deliveryPrice, 0));
                }
            },
        }
    }).mount('#app');