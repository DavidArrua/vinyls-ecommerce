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
                    title: 'Estas seguro?',
                    text: "Quieres salir de la app?",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: "salir",
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


    $(document).ready(function(){

        $('.ir-arriba').click(function(){
            $('body, html').animate({
                scrollTop: '0px'
            }, 300);
        });
    
        $(window).scroll(function(){
            if( $(this).scrollTop() > 0 ){
                $('.ir-arriba').slideDown(300);
            } else {
                $('.ir-arriba').slideUp(300);
            }
        });
    
    });
    