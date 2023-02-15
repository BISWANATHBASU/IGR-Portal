<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/jqFancyTransitions.1.8.min.js" type="text/javascript"></script>

<title>Insert title here</title>
</head>
<body>
<script>

function SuccessFunc(result) {
    if (result.ErrorCode == 0) {
        /* 	Display BMP data in image tag
            BMP data is in base 64 format 
        */
        if (result != null && result.BMPBase64.length > 0) {
            document.getElementById("FPImage1").src = "data:image/bmp;base64," + result.BMPBase64;
        }
        var tbl = "<table border=1>";
        tbl += "<tr>";
        tbl += "<td> Serial Number of device </td>";
        tbl += "<td> <b>" + result.SerialNumber + "</b> </td>";
        tbl += "</tr>";
        tbl += "<tr>";
        tbl += "<td> Image Height</td>";
        tbl += "<td> <b>" + result.ImageHeight + "</b> </td>";
        tbl += "</tr>";
        tbl += "<tr>";
        tbl += "<td> Image Width</td>";
        tbl += "<td> <b>" + result.ImageWidth + "</b> </td>";
        tbl += "</tr>";
        tbl += "<tr>";
        tbl += "<td> Image Resolution</td>";
        tbl += "<td> <b>" + result.ImageDPI + "</b> </td>";
        tbl += "</tr>";
        tbl += "<tr>";
        tbl += "<td> Image Quality (1-100)</td>";
        tbl += "<td> <b>" + result.ImageQuality + "</b> </td>";
        tbl += "</tr>";
        tbl += "<tr>";
        tbl += "<td> NFIQ (1-5)</td>";
        tbl += "<td> <b>" + result.NFIQ + "</b> </td>";
        tbl += "</tr>";
        tbl += "<tr>";
        tbl += "<td> Template(base64)</td>";
        tbl += "<td> <b> <textarea rows=8 cols=50>" + result.TemplateBase64 + "</textarea></b> </td>";
        tbl += "</tr>";
        tbl += "</table>";
        document.getElementById('result').innerHTML = tbl;
    }
    else {
        alert("Fingerprint Capture ErrorCode " + result.ErrorCode)
    }
}

function ErrorFunc(status) {

    /* 	
        If you reach here, user is probabaly not running the 
        service. Redirect the user to a page where he can download the
        executable and install it. 
    */
    alert("Check if SGIBIOSRV is running ");

}


        function captureFP() {
            CallSGIFPGetData(SuccessFunc, ErrorFunc);

        }
        function CallSGIFPGetData(successCall, failCall) {
            var uri = "http://localhost:8000/SGIFPCapture";

            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    fpobject = JSON.parse(xmlhttp.responseText);
                    successCall(fpobject);
                }
                else if (xmlhttp.status == 404) {
                    failCall(xmlhttp.status)
                }
            }
            xmlhttp.onerror = function () {
                failCall(xmlhttp.status);
            }
            xmlhttp.open("POST", uri, true);
            xmlhttp.send();
        }


</script>
<img border="2" id="FPImage1" alt="Fingerpint Image" height=300 width=210 src="" > 
<input type="button" value="Click to Scan" onclick="captureFP()"> <br>

</body>
</html>