Vue.createApp({
    data(){
        return{
            state:'stu',
            stuState:'addStu',
            peopleID: null,
            name:null,
            password:null,
            phone:null,
            keyword:null,
            stuErr:''
        }
    },
    methods:{
        change(state){
            this.state = state
            console.log(this.state)
        },
        useAdd(state){
            this.stuState = state
        },
        addStu(){
            axios
                .post("/SSMproject/test",{
                    peopleID:this.peopleID,
                    name:this.name,
                    password:this.password,
                    phone:this.phone
                })
                .then(result=>{
                    console.log(result.data)
                    if(result.data.data){
                        // for(var )
                        console.log(result.data.data)
                        // var users = result.data.data
                        // var ins ="<form method='post'><div>老师工号  <input type='text' name='peopleID' > </div>" +
                        //
                        // for(var key in users){
                        //     ins += `<div>姓名：${users[key].userma,e}</div><`
                        // }
                        // ins
                    }
                    if(result.data){
                        this.stuErr = '增加成功！'
                        // alert()
                        // alert("OK")
                    }
                    else{
                        alert("失败")
                        this.stuErr = '插入失败！请检查输入！'
                    }
                        // alert("No")
                    // console.log(result)
                })
                .catch(err=>{
                    console.log(err.status)
                })
        }
    }
}).mount('.main')