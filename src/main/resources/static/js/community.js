//添加评论
function post(){
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2Target(questionId,1,content);

}
//添加二级评论
function comment(e){
    var commentId= e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2Target(commentId,2,content);
}
function comment2Target(targetId,type,content){
    if (!content){
        alert("不能回复空内容");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType:"application/json",
        data: JSON.stringify({
            "parentId":targetId,
            "content":content,
            "type":type
        }),
        success: function(response){
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=69858ac280969df06221&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable",true);
                    }

                }else{
                    alert(response.message);
                }

            }
            console.log(response);
        },
        dataType: "json"
    });
}
//展开二级评论
function collapseComments(e){
    var id= e.getAttribute("data-id");
    var comments=$("#comment-"+id);
    var collapse = e.getAttribute("data-collapse");
    if (collapse){
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else{
        //展开二级评论
        $.getJSON( "/comment/"+id, function( data ) {
            console.log(data);
            comments.addClass("in");
            e.setAttribute("data-collapse","in");
            e.classList.add("active");
        });
    }

}