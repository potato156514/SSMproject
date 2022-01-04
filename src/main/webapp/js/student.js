Vue.createApp({
    data(){
        return {
            //选课，退选，查成绩
            mode:'选择实验',
            shiyanList:{},
            myShiyan:{},
            state:'',
            tuixuanRes:''
        }
    },
    methods:{
        switchMode(mode){
            this.mode = mode
            // if(this.mode === '选择实验'){
            //     this.getShiyanList()
            // }
            switch (this.mode) {
                case '选择实验':
                    this.getShiyanList() ;break;
                case '查看成绩':
                    this.getMyShiyan();break;
                case '退选实验':
                    this.getMyShiyan();break;
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
        },
        choose(shiyanId){
            axios
                .post('/SSMproject/chooseShiyan',{id:shiyanId})
                .then(res=> {
                    console.log(res.data)
                    if(res.data === true) this.state = '实验报名成功！'
                    else this.state = '实验报名失败！或者您已经报名了此项实验'
                    this.getShiyanList()
                })
                .catch(err=>console.log(err))
        },
        getMyShiyan(){
            axios
                .post('/SSMproject/getMyShiYan')
                .then(res=>{
                    console.log(res.data)
                    this.myShiyan = res.data
                })
                .catch(err=>{
                    console.log(err)
                })
        },
        tuixuan(shiyanID){
            console.log(shiyanID)
            axios
                .post(`/SSMproject/tuixuan`,{id:shiyanID})
                .then(res=>{
                    console.log(res.data)
                    this.tuixuanRes = res.data?"退选成功":"退选失败"
                    this.getMyShiyan();
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