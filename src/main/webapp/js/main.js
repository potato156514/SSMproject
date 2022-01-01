Vue.createApp({
    data(){
        return{
            state:1
        }
    },
    methods:{
        change(state){
            this.state = state
            console.log(this.state)
        }
    }
}).mount('.main')