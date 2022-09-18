
const app = Vue.
    createApp({
        data() {
            return {
                select: "selectStep1",
                


            }
        },
        created() {
         



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
                                       
             
            }


          




        }
    }).mount('#app');

/*     removeDisableSection(id1,id2){
        let disableSectionColumn1 = document.getElementById(id2)
        let button = document.getElementById(id1)
        disableSectionColumn1.classList.remove("disableSection")
        if(button){
            button.classList.add("d-none")
        }
    }, */