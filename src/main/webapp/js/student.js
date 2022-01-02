Vue.createApp({
    data(){
        return {
            //选课，退选，查成绩
            mode:'选择实验',
            shiyanList:{}
        }
    },
    methods:{
        switchMode(mode){
            this.mode = mode
            if(this.mode === '选择实验'){
                this.getShiyanList()
            }
        },
        getShiyanList(){
            axios
                .post('/SSMproject/AllShiyan')
                .then(res=>{
                    console.log(res.data)
                    this.shiyanList = res.data
                })
                .catch(err=>{
                    console.log(err)
                })
        }
    },
    mounted(){
        axios
            .post('/SSMproject/AllShiyan')
            .then(res=>{
                // console.log(res.data)
                this.shiyanList = res.data
                console.log(this.shiyanList)
            })
            .catch(err=>{
                console.log(err)
            })

    }
}).mount('.app')