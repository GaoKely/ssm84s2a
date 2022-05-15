const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm84s2a/",
            name: "ssm84s2a",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm84s2a/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校内民生APP"
        } 
    }
}
export default base
