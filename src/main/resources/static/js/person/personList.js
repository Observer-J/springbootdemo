$(function () {
    initPersonTable();
})



function initPersonTable() {
    $.ajax({
        url:"/person/personList",
        type:"post",
        data:"",
        success:function (responseData) {
            // var jsonData = JSON.parse(responseData);
            if(responseData.code == 0){
              var personList = responseData.data;
              // var personList = JSON.parse(responseData.data);
                var str = '<ul class="th">' +
                                '<li>编号</li>' +
                                '<li>姓名</li>' +
                                '<li>性别</li>' +
                            '</ul>';
              $.each(personList,function (index,value) {
                  str+='<ul>' +
                          '<li>'+value.personId+'</li>' +
                          '<li>'+value.name+'</li>' +
                          '<li>'+value.gender+'</li>' +
                       '</ul>'
              })
                $("#personList").html(str);

            }else{
                showErrorTip("获取用户列表失败！")
            }
        },
        error:function () {
            showErrorTip("连接失败!")
        }
    })
}