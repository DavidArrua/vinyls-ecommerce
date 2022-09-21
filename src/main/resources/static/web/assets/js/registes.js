const app = Vue.createApp({
    data() {
        return {
            email: "",
            pwd: "",
            firstName: "",
            lastName: "",
            queryString: "",
            params: "",
            id: "",
            account: {},
            transactions: [],
            client: {},
        };
    },
    created() {
        this.queryString = location.search
        this.params = new URLSearchParams(this.queryString)
        this.id = this.params.get("id")
        this.verify()
     },
    methods: {
        login() {
            axios
                .post("/api/login", `email=${this.email}&pwd=${this.pwd}`, {
                    headers: { "content-type": "application/x-www-form-urlencoded" },
                })
                .then((response) => (location.href = "/web/index.html"))
                .catch((response) => console.log(error));
        },

        register() {
            axios
                .post(
                    "/api/clients",
                    `firstName=${this.firstName}&lastName=${this.lastName}&email=${this.email}&password=${this.pwd}`,
                    { headers: { "content-type": "application/x-www-form-urlencoded" } }
                )
                .then((response) => (location.href = "/web/index.html"))
                .catch(function (error) {
                    console.log(error);
                });
        },
        verify() {
            axios.get(`/api/clients/verify/${this.id}`)
                .then(console.log("si"))
        },
    },
}).mount("#app");