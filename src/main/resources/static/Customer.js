$(document).ready(function () {
    getGuidId();
    loadCustomer();

});
function getGuidId() {

    $.ajax({
        type: "GET",
        url: "/api/userDashboard/getGuidId",
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            // alert(result.guid);
            $("#lblCopmanyId").text(result.guid);
            $("#lblname").text(result.name);

        }
    });
}

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

//add data function
function addCustomer() {

    var date = new Date();

    var obj = {

        fullName: $('#txtfullname').val(),
        contactName: $('#txtcontactname').val(),
        companyAddress: $('#txtadres').val(),
        city: $('#txtcity').val(),
        region: $('#txtregion').val(),
        country: $('#drpcountry').val(),
        email: $('#txtemail').val(),
        password: $('#txtpassword').val(),
        phone: $('#txtphone').val(),
        companyPhone: $('#txtcompanyphone').val(),
        whatsUp: $('#txtwahtsup').val(),
        position: $('#txtrole').val(),
        postCode: $('#txtpostcode').val(),

    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/Customer/addCustomer",
        data: JSON.stringify(obj),
        dataType: 'json',

        success: function (result) {

            localStorage.setItem("sonuc", result.status);
            // alert(result.status);
            if (result.status == "EXIST") {
                $("#existSave").show();

            }
            // $('#myModal').modal('hide');
            // $("#CustomerTable tbody tr").remove();
            // loadCustomer();
            // alert(result.status);

        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

///////////////////////////////

//delete
function deleteCustomer(id) {

    var ans = confirm("Are you sure you want to delete this Record?");

    if (ans) {
        var workingObject = $(this);
        $.ajax({
            url: "/api/Customer/deleteCustomer/" + id,
            type: "DELETE",
            //contentType: "application/json;charset=UTF-8",
            // dataType: "json",
            success: function (result) {

                $("#CustomerTable tbody tr").remove();
                loadCustomer();

                $("#resultMsgDiv").html("<p style='background-color:#67597E; color:white; padding:20px 20px 20px 20px'>" +
                    "Customer with Id=" + id + " is deleted successfully!" +
                    "</p>");
                workingObject.closest("tr").remove();


                // re-css for table
                $("#CustomerTable tbody tr:odd").addClass("info");
                $("#CustomerTable tbody tr:even").addClass("success");
            },
            error: function (errormessage) {
                alert(errormessage.responseText);
            }
        });
    }
}

///////// edit/////
function editCustomer() {
    var idCustom= $('#lblCopmanyId').text();

    $('#txtid').css('border-color', 'lightgrey');
    $('#txtname').css('border-color', 'lightgrey');


    $.ajax({
        url: "/api/Customer/getCustomer/" + idCustom,
        type: "GET",
        //contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {

                $('#txtid').text(result.guid);

                $('#txtcompanyname').val(result.companyName),
                $('#txtcontactname').val(result.contactName),
                $('#txtadres').val(result.companyAddress),
                $('#txtcity').val(result.city),
                $('#txtregion').val(result.region),
                $('#txtpostcode').val(result.postCode),
                $('#txtcountry').val(result.country),
                $('#txtemail').val(result.email),
                $('#txtpassword').val(result.password),
                $('#txtphone').val(result.phone),
                $('#txtcompanyphone').val(result.companyPhone),
                $('#txtwahtsup').val(result.whatsUp),
                $('#txtrole').val(result.position),


                $('#m_modal_1').modal('show');
            $('#btnUpdate').show();
            $('#btnAdd').hide();

        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
    return false;
}

///////////////////////
///////
function updateCustomer() {
    var idCustom= $('#lblCopmanyId').text();

    var CustomerObj = {

        companyName: $('#txtcompanyname').val(),
        contactName: $('#txtcontactname').val(),
        companyAddress: $('#txtadres').val(),
        city: $('#txtcity').val(),
        postCode: $('#txtpostcode').val(),
        region: $('#txtregion').val(),
        country: $('#drpcountry').val(),
        email: $('#txtemail').val(),
        password: $('#txtpassword').val(),
        phone: $('#txtphone').val(),
        companyPhone: $('#txtcompanyphone').val(),
        whatsUp: $('#txtwahtsup').val(),
        position: $('#txtrole').val(),
    };

    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/Customer/updateCustomer/" + idCustom,
        data: JSON.stringify(CustomerObj),
        dataType: 'json',

        success: function (result) {
            alert("Updated...")
            // $('#m_modal_1').modal('hide');
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }

    });
}

//Function for clearing the textboxes
function clearTextBox() {

    $('#txtid').val("");

    $('#txtname').val(""),
        $('#txtemail').val(""),
        $('#txtpassword').val(""),
        $('#txtphone').val(""),
        $('#rdorole').val(""),
        $('#rdoactivate').val(""),

        $('#btnUpdate').hide();
    $('#btnAdd').show();

}

function loadusers(id,currentUser) {
//alert("#ord1");
    $('#txtIdUser').val(id);
    $('#txtUserName').val(currentUser);

    $.ajax({
        type: "GET",
        url: "/api/adminDashboard/mapUserList",
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        data: {},
        success: function (result) {

            var category = $("#rdoUsers");
            category.empty().append('<option selected="selected" value="0">All List</option>');
            $.each(result, function (key, value) {
                $('#rdoUsers')
                    .append($("<option></option>")
                        .attr("value", key)
                        .text(value));
            });

        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

function updateUserId() {
    var id = $('#txtIdUser').val();
    var userId = {
        userId: $('#rdoUsers').val()
    };
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/api/adminDashboard/updateUserForCustomer/" + id,
        data: JSON.stringify(userId),
        dataType: 'json',

        success: function (result) {
            //alert("Updated...")
            $('#txtUserName').val($('#rdoUsers option:selected').text());
            loadCustomer();
            // $('#m_modal_1').modal('hide');
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }

    });

}

/*
load category publisging
 */
function loadPublish(id) {

    //clear();
    $('#userI').text(id);

    $.ajax({
        type: "GET",
        url: "/api/order/bookCategory",
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        data: {},
        success: function (result) {

            var publish = $("#drpPublisher");
            publish.empty().append('<option selected="selected" value="0">Select</option>');

            $.each(result, function () {
                publish.append($("<option class='form-control' />").val(this).text(this));
            });


        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
    //loadCustomerDiscount();
}
/*
loadPublish chance
 */
$("#drpPublisher").change(function () {

    var publishName=$('#drpPublisher option:selected').text();
    $.ajax({
        type: "GET",
        url: "/api/adminDashboard/publishCategory/"+publishName,
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        data: {},
        success: function (result) {
            var category = $("#drpCategoryName");
            category.empty().append('<option selected="selected" value="0"></option>');
            $.each(result, function (key, value) {
                $('#drpCategoryName')
                    .append($("<option></option>")
                        .attr("value", key)
                        .text(value));
            });

        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });

});

/*
add customer discount
 */
function addCustomerDiscount() {
var id=$('#userI').text();
    var obj = {
        categoryId: $('#drpCategoryName').val(),
        categoryName: $('#drpCategoryName option:selected').text(),
        discount: $('#txtDiscount').val(),
        publishing: $('#drpPublisher option:selected').text(),
        discountGroupId:$('#groupId').text(),
        customer: {
            id: id
        }
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/adminDashboard/addCustomerDiscount/"+id,
        data: JSON.stringify(obj),
        dataType: 'json',

        success: function (result) {
            //loadCustomerDiscount();

        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}
/*
load discount

function loadCustomerDiscount() {
    var id=$('#userI').text();
    $.ajax({
        type: "GET",
        url: "/api/adminDashboard/getListOfDiscount/"+id,
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        success: function (result) {

            $("#html_table_CustomersDiscount tbody tr").remove();

            $.each(result, function (i, customerDiscount) {

                var CustomerRowDiscount = '<tr>' +

                    '<td>' + customerDiscount.discountGroupId + '</td>' +
                    '<td>' + customerDiscount.date + '</td>' +
                    '<td>' + customerDiscount.publishing + '</td>' +
                    '<td>' + customerDiscount.categoryName + '</td>' +
                    '<td>' + customerDiscount.discount + '</td>' +
                    '<td> <a href="#" onclick="deleteCustomerDiscount(\'' + customerDiscount.discountGroupId + '\')" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Delete">\n' +
                    '                <i class="la la-trash"></i>' +
                    '</td>'

                '</tr>';

                $('#customerDiscountList').append(CustomerRowDiscount);

            });
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}
/*
create discount group id
 */
function createDiscountGroupId() {
   $("#groupId").text("");
    //clear();
    $.ajax({
        type: "GET",
        url: "/api/adminDashboard/createGroupId",
        contentType: "aplication/json;charset=utf-8",
        dataType: "json",
        success: function (result) {

            $('#groupId').append(result.groupId);
            clear();

        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

function clear() {
        $('#drpCategoryName').val("");
        $('#txtDiscount').val("");
      //  $('#drpPublisher').val("");
        //$('#groupId').text("");
       // $('#userI').text("");

}
/*
delete discount
 */
function deleteCustomerDiscount(discountGroupId) {

    var ans = confirm("Are you sure you want to delete this Record?");

    if (ans) {
        var workingObject = $(this);
        $.ajax({
            url: "/api/adminDashboard/deleteDiscount/" + discountGroupId,
            type: "DELETE",

            success: function (result) {
               // loadCustomerDiscount();

            },
            error: function (errormessage) {
                alert(errormessage.responseText);
            }
        });
    }
}