var app = angular.module("myApp", []);

app.controller("fileuploadController", function($scope, $http, $location) {


	$scope.showImage = false;
	$scope.showProgress = false;
	
	$scope.file = null;
	
	$scope.continueFileUpload = function() {
		$scope.showProgress = true;
		var uploadUrl = "/uaiContacts/fileupload";
		var formData = new FormData();
  		formData.append("file", file.files[0]);
		
		$http({
			method : 'POST',
			url : uploadUrl,
			headers : {
				'Content-Type' : undefined
			},
			data : formData,
			transformRequest : function(data, headersGetterFunction) {
				return data;
			}
		}).success(function(data, status) {
			if(data != ""){
				$scope.showProgress = false;
				$scope.showImage = true;
				$scope.parentBase64strWithRects = data;
			}else{
				alert("failed");
			}
		})

	};
	
	 $scope.clicked = function() {
		 $scope.showImage = false;
	}	


});




