/**
 * Created by Administrator on 2016/6/2.
 */
base = document.getElementById("base").href;
function login(){
    $.post(base+"/login/auth",
        {
            name:"Tom",
            password:"123456"
        },
        function(data,status){
        	if(data.code == 0){
        		location.href=base;
        	}
        });
}