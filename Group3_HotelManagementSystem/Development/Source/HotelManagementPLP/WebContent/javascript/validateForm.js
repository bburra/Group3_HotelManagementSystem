/**
 * 
 */
function validateRoom() {
	var roomType = document.addRoom.roomType.value;
	var availability = document.addRoom.availability.value;
	if (roomType == "Select") {
		alert("Choose Room Type");
		return false;
	}

	else if(availability == "YES"|| availability == "NO" )
	{
		return true;
	}
	alert("Please Enter YES/NO in Availability");
	return false;
}