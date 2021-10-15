var cnt = 1;

function fn_addFile() {
	$("#file").append("<br>" + "<input type='file' name='file" + cnt + "' />");
	cnt++;
}
// 주소검색 팝업 호출
function fn_openPopup(){
	var url = "fileUploadPopUp.jsp";
	var name = "FileUpload";
	var option = "width=650, height=500, top=100, left=200, location=no"
	window.open(url, name, option);
	
}

function fn_dragAndDrop() {
	$('.content')
	  .on("dragover", dragOver)
	  .on("dragleave", dragOver)
	  .on("drop", uploadFiles);
	 
	function dragOver(e){
	  e.stopPropagation();
	  e.preventDefault();
	}
	 
	function uploadFiles(e){
	  e.stopPropagation();
	  e.preventDefault();
	}
}

function dragOver(e) {
    e.stopPropagation();
    e.preventDefault();
    if (e.type == "dragover") {
        $(e.target).css({
            "background-color": "black",
            "outline-offset": "-20px"
        });
    } else {
        $(e.target).css({
            "background-color": "gray",
            "outline-offset": "-10px"
        });
    }
}

function uploadFiles(e) {
    e.stopPropagation();
    e.preventDefault();
    dragOver(e); //1
 
    e.dataTransfer = e.originalEvent.dataTransfer; //2
    var files = e.target.files || e.dataTransfer.files;
 
    if (files.length > 1) {
        alert('하나의 사진만 올려주세요.');
        return;
    }
    
    if (files[0].type.match(/image.*/)) {
        
    }else{
        alert('이미지가 아닙니다.');
        return;
    }
    
    if (files[0].type.match(/image.*/)) {
        $(e.target).css({
            "background-image": "url(" + window.URL.createObjectURL(files[0]) + ")",
            "outline": "none",
            "background-size": "50% 50%"
        });
    }else{
      alert('이미지가 아닙니다.');
      return;
    }

}


