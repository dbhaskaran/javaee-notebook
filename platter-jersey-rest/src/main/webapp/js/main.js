// The root URL for the RESTful services
var rootURL = "http://localhost:8089/platter-jersey-rest/webapi/dishes";

var currentDish;

// Retrieve wine list when application starts 
findAll();


// Replace broken images with generic wine bottle


function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else
		findByName(searchKey);
}

function newDish() {
	$('#btnDelete').hide();
	currentDish = {};
	renderDetails(currentDish); // Display empty form
}

//Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

$('#dishList a').live('click', function() {
	findById($(this).data('identity'));
});

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}

function findById(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			console.log('findById success: ' + data.name);
			currentWine = data;
			renderDetails(currentWine);
		}
	});
}


$('#btnAdd').click(function() {
	newDish();
	return false;
});

$('#btnSave').click(function() {
	if ($('#dishId').val() == '')
		addDish();
	else
		updateDish();
	return false;
});

$("img").error(function(){
	  $(this).attr("src", "pics/generic.jpg");

	});

$('#btnDelete').click(function() {
	deleteDish();
	return false;
});




function findByName(searchKey) {
	console.log('findByName: ' + searchKey);
	$.ajax({
		type: 'GET',
		url: rootURL + '/search/' + searchKey,
		dataType: "json",
		success: renderList 
	});
}



function addDish() {
	console.log('addDish');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Dish created successfully');
			$('#btnDelete').show();
			$('#dishId').val(data.id);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addDish error: ' + textStatus);
		}
	});
}

function updateDish() {
	console.log('updateDish');
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#wineId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Wine updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateDish error: ' + textStatus);
		}
	});
}

function deleteDish() {
	console.log('deleteDish');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + $('#dishId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Dish deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteDish error');
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#dishList li').remove();
	$.each(list, function(index, dish) {
		$('#dishList').append('<li><a href="#" data-identity="' + dish.id + '">'+dish.name+'</a></li>');
	});
}

function renderDetails(dish) {
	$('#dishId').val(dish.id);
	$('#name').val(dish.name);
	$('#category').val(dish.category);
	$('#country').val(dish.country);
	$('#region').val(dish.region);
	$('#pic').attr('src', 'pics/' + dish.id + '.jpg');
	$('#description').val(dish.description);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var dishId = $('#dishId').val();
	return JSON.stringify({
		"id": dishId == "" ? null : dishId, 
		"name": $('#name').val(),
		"category": $('#category').val(),
		"country": $('#country').val(),
		"region": $('#region').val(),
		"picture": currentWine.picture,
		"description": $('#description').val()
		});
}
