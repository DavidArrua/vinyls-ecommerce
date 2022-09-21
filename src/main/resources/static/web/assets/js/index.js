const app = Vue.

    createApp({
        data() {
            return {
                products: [],
                productId: [],
                client: {},
                verifired: false,
            }
        },

        created() {
            axios.get("/api/clients/current")
                .then(response => {
                    this.client = response.data;
                    this.verifired = this.client.validation
                })

        },
        methods: {
            formattedNumber(balance) {
                return balance = new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(balance)
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

