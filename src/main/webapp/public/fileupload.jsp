<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="pt-BR" id="ng-app" ng-app="myApp">
<head>

<meta charset="utf-8">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<meta http-equiv="X-UA-Compatible" content="IE=11" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


<link href="<c:url value='/resources/css_fu/fileinput.css'/>"
	rel="stylesheet" />




<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
				        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
				        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
				    <![endif]-->

<!-- jQuery -->

<script src="<c:url value='/resources/js/angular.min.js' />"></script>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<!-- Plugin JavaScript -->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>



<script src="<c:url value='/resources/js_fu/fileinput.js' />"></script>

<script src="<c:url value="/resources/js_fu/fileupload.js" />"></script>

</head>
<body>

	<div class="container" ng-controller="fileuploadController">

		<div class="progress"  ng-show="showProgress">
			<div class="progress-bar progress-bar-striped active"
				role="progressbar" aria-valuenow="100" aria-valuemin="0"
				aria-valuemax="100" style="width: 100%"></div>
		</div>

		<div>
			<form method="post" id="fromFileUpload" enctype="multipart/form-data"
				ng-submit="continueFileUpload()">
				<div class="container form-group col-lg-12 col-md-12 col-sm-12">

					<input id="file" class="file img-responsive" type="file"
						name="file" ng-model="file" data-rule-required="true"
						accept=".jpg, .jpeg, ,.bmp, .png" ng-click="clicked()"> <span
						id="vaildFile" class="text-success icon-ok hide">Valid File</span>
					<span id="invaildFile" class="text-error icon-remove hide">Invalid
						File</span>

					<hr>
				</div>
			</form>

		</div>

		<div>
			<img ng-show="showImage"
				src="data:image/jpg;base64,{{parentBase64strWithRects}}"
				class="img-responsive img-centered img-thumbnail" alt="" />
		</div>
	</div>





</body>


</html>

