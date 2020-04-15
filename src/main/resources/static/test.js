$(document).ready(function () {
loadCustomer();


});
function loadCustomer() {

    $.ajax({
        type: "GET",
        url: "/student",
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        success: function (result) {

            $("#html_table_Customers tbody tr").remove();

            $.each(result, function (i, Student) {

                var CustomerRow =
                '<tr>'+
                '<td>' + Student.fullName + '</td>'+
                '<td>' + Student.address + '</td>' +

                '</tr>';

                $('#students').append(CustomerRow);

            });


        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}