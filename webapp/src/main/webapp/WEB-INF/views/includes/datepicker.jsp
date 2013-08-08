<script>

    /* Table initialisation */
    $(document).ready(function () {
        $('#remediTable').dataTable({
            "bSort": false,
            "sDom": 'lfr<"toolbar">tip'
        });
        $("div.toolbar").html('' +
                '<form class="form-inline">' +
                '<fieldset>' +
                '<label>From:</label>' +
                '<input id="date1" type="text" name="date1" value="${param.startDate}" onchange="fromDateSelected()" class="form-control form-remedi-date" /> ' +
                '<label>To:</label>' +
                '<input id="date2" type="text" name="date2" value="${param.endDate}" class="form-control form-remedi-date" />' +
                '<button id="filter" type="button" class="btn btn-default" onclick="filterButtonClicked()">Apply</button>' +
                '</fieldset>' +
                '</form>' );
    });

    $(function () {
        $('#date1').datepicker({
            dateFormat: 'dd/mm/yy'
        });
        $('#date1').datepicker();

        if ($('#date1').datepicker('getDate') == null) {
            var date = new Date(), y = date.getFullYear(), m = date.getMonth();
            $('#date1').datepicker("setDate", new Date(y, m, 1));
        }

    });

    $(function () {
        $('#date2').datepicker({
            minDate: $('#date1').datepicker('getDate'),
            dateFormat: 'dd/mm/yy'
        });
        $('#date2').datepicker();
        if ($('#date2').datepicker('getDate') == null) {
            $('#date2').datepicker("setDate", new Date());
        }
    })

    function fromDateSelected() {
        $('#date2').datepicker("option", "minDate", $('#date1').datepicker('getDate'));
    }

    function filterButtonClicked() {
        if (($("#date1").val().length != 19) || ($("#date2").val().length != 19)) {
            $("#dateTooShortError").show();
            return false;
        } else if ($("#date1").datepicker('getDate') > $("#date2").datepicker('getDate')) {
            $("#dateError").show();
            return false;
        } else {
            $("#dateTooShortError").hide();
            $("#dateError").hide();
            $("#dateError").hide();
            window.location = "<%= request.getParameter("windowLocation") %>" + "&startDate=" + $('#date1').val() + "&endDate=" + $('#date2').val();
        }
    }

</script>

<div class="row">
    <div id="dateError" class="alert alert-block alert-error" style="display:none;margin:20px;">
            <p>Error: The "From" date must be earlier than the "To" date.</p>
    </div>
</div>

<div class="row">
     <div id="dateTooShortError" class="alert alert-block alert-error" style="display:none;margin:20px;">
         <p>One or both of the dates are invalid. Format must be "dd/MM/yyyy hh:mm aa".</p>
     </div>
</div>