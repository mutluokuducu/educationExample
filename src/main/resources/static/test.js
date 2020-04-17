$(document).ready(function () {
loadStudent();


});
function loadStudent() {

    $.ajax({
        type: "GET",
        url: "/student",
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        success: function (result) {

            $("#html_table_Customers tbody tr").remove();

            $.each(result, function (i, Student) {

                var studentRow =
                '<tr>'+
                 '<td>' + Student.id + '</td>'+
                '<td>' + Student.fullName + '</td>'+
                '<td>' + Student.address + '</td>' +
                '</tr>';

                $('#students').append(studentRow);

            });
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

function addStudent() {



    var obj = {

// fullName: $('#txtfullname').val(),
// full name from db fields response fields
//txtfullname is from htmls form id

        fullName: $('#txtfullname').val(),
        address: $('#txtaddress').val()

    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "student",
        data: JSON.stringify(obj),
        dataType: 'json',

        success: function (result) {

            loadStudent();



        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}