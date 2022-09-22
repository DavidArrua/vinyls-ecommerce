

const app = Vue.

    createApp({
        data() {
            return {
                products: [],
                orderProduct: "order",
                genresValue: "allGenere",
                selectGenres: [],
                genres: [],
                productType: "allType",
                productsFilter: [],
                input: "",
                condition: "allCondition",
                trolley: [],
                trolleyInStorage: [],
                selectProducts: [],
                client: {},
                verifired: false,
                selectName: [],
            }
        },

        created() {
            axios.get("/api/products")
                .then(response => {
                    this.products = response.data;
                    this.genresFilter()
                    this.productsFilter = this.products
                    this.selectProducts = this.productsFilter
                    let trolleyInStorage = JSON.parse(localStorage.getItem("products"))
                    if (trolleyInStorage) {
                        this.trolley = trolleyInStorage
                    }
                })
                .catch((error) => {
                    console.log(error);
                });
            axios.get("/api/clients/current")
                .then(response => {
                    this.client = response.data;
                    this.verifired = this.client.validation
                })

        },
        methods: {
            orderProducts() {
                if (this.orderProduct == "order") {
                    this.productsFilter = this.products
                }
                if (this.orderProduct == "precioMasBajo") {
                    return this.productsFilter.sort((a, b) => a.price - b.price)
                }
                if (this.orderProduct == "precioMasAlto") {
                    return this.productsFilter.sort((a, b) => b.price - a.price)
                }
                if (this.orderProduct == "laconchadetumadre") {
                    return this.productsFilter.sort()
                }
                if (this.orderProduct == "zA") {
                    return this.productsFilter.sort((a, b) => b.name - a.name)
                }
            },
            genresFilter() {
                this.products.forEach(genere => {
                    genere.genres.forEach(element => {
                        if (!this.selectGenres.includes(element)) {
                            this.selectGenres.push(element)
                        }
                    });
                })
            },
            orderGenres(genresValue) {
                this.productsFilter = []
                if (genresValue == "allGenere") {
                    return this.productsFilter = this.products
                }
                this.products.forEach(genere => {
                    if (!genere.genres.includes(genresValue)) {
                        return
                    }
                    this.productsFilter.push(genere)
                })

            },
            orderByType(productType) {
                this.productsFilter = []
                if (productType == "allType") {
                    return this.productsFilter = this.products
                }
                this.products.forEach(genere => {
                    if (!genere.productType.includes(productType)) {
                        return
                    }
                    this.productsFilter.push(genere)
                })
            },
            allProducts() {
                this.productsFilter = this.products
            },
            newProducts() {
                let newProductsByDate = []
                this.products.forEach(date => {
                    if (parseInt(date.releaseDate) >= 2020) {
                        newProductsByDate.push(date)
                    }
                })
                this.productsFilter = newProductsByDate;
            },
            mostSold() {
                let productsByStock = []
                this.products.forEach(stock => {
                    if (parseInt(stock.stock) <= 7) {
                        productsByStock.push(stock)
                    }
                })
                this.productsFilter = productsByStock;
            },
            formattedNumber(balance) {
                return balance = new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(balance)
            },
            productCondition(condition) {
                this.productsFilter = []
                if (condition == "allCondition") {
                    return this.productsFilter = this.products
                }
                if (condition == "new") {
                    let state = this.products.filter(product => product.firstHand == true)
                    return this.productsFilter = state
                }
                if (condition == "used") {
                    let state = this.products.filter(product => product.firstHand == false)
                    return this.productsFilter = state
                }
            },
            sendProducts() {
                axios.post('/api/bills', this.carrito)
            },
            trolleyPurchase(product) {
                let products = this.trolley.filter(item => item.id == product.id)[0]
                if (products != undefined) {
                    products.quantity++
                    localStorage.setItem("products", JSON.stringify(this.trolley))

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
                        quantity: 1
                    }
                    this.trolley.push(products)
                    localStorage.setItem("products", JSON.stringify(this.trolley))
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
                let products = this.trolley.filter(item => item.id == product.id)[0]
                if (products != undefined) {
                    products.quantity--
                    localStorage.setItem("products", JSON.stringify(this.trolley))

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
                        quantity: 1
                    }
                    this.trolley.push(products)
                    localStorage.setItem("products", JSON.stringify(this.trolley))
                }
                products.stock++;

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
                    color: '#ffd22afe',
                    icon: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "SI",
                }).then((result) => {
                    if (result.isConfirmed) {
                        let products = this.products.filter((item) => item.id == product.id)[0];
                        products.stock += product.quantity;
                        let productIndice = 0;
                        this.trolley.forEach((item, i) =>
                            item.id == product.id ? (productIndice = i) : null
                        );
                        this.trolley.splice(productIndice, 1);
                        localStorage.setItem("products", JSON.stringify(this.trolley));
                        Swal.fire("Eliminado!", "El producto fue eliminado.", "success")
                    }
                })
            },
            logOut() {
                Swal.fire({
                    title: 'Estas seguro?',
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
            },
           
        }
    }).mount('#app');

const gap = 16;

const carousel = document.getElementById("carousel"),
    content = document.getElementById("content"),
    next = document.getElementById("next"),
    prev = document.getElementById("prev");

next.addEventListener("click", e => {
    carousel.scrollBy(width + gap, 0);
    if (carousel.scrollWidth !== 0) {
        prev.style.display = "flex";
    }
    if (content.scrollWidth - width - gap <= carousel.scrollLeft + width) {
        next.style.display = "none";
    }
});
prev.addEventListener("click", e => {
    carousel.scrollBy(-(width + gap), 0);
    if (carousel.scrollLeft - width - gap <= 0) {
        prev.style.display = "none";
    }
    if (!content.scrollWidth - width - gap <= carousel.scrollLeft + width) {
        next.style.display = "flex";
    }
});

let width = carousel.offsetWidth;
window.addEventListener("resize", e => (width = carousel.offsetWidth));

var typed = new Typed('.typed', {
    strings: ['Harry Styles', 'Born To Die', 'Future Nostalgia'],
    typeSpeed: 75,
    startDelay: 1200,
    backSpeed: 75,
    backDelay: 1500,
    loop: true,
});
