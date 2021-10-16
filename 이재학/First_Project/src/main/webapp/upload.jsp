<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Form</title>
</head>
<body>
	
	
	<form method="post" action="uploadFile.do" enctype="multipart/form-data">
           
           <input type="text" name="field_name" value="값"/><br/>
           
           Select file to upload:<br/>
           <input type="file" name="uploadFile" />
                      <br/><br/>
           <input type="submit" value="Upload" />
       </form>
       
</body>
</html>