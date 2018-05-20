function deleteId(node) {
    var url = node.href;/*得到href的值*/
    $.ajax({
        url:url,/*url也可以是json之类的文件等等*/
        type:'DELETE',/*DELETE、POST */
        success:function (result) {
            //判断result结果
            if(result=="DELETE SUCCESS"){
                window.location.reload();
            }else{
                alert("删除文件失败");
            }
        }
    })
};