$("#exam01Btn").on("click", ()=>{
    $("#exam03Form").attr({
        method: "get",
        action: "/example/exam03"
    });
    $("#exam03Form").submit();
});

$("#exam02Btn").on("click",()=>{
    $("#exam03Form").attr({
        method: "Post",
        action: "/example/exam04"
    });
    $("#exam03Form").submit();
});


















