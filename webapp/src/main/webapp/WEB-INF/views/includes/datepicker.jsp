<script>

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
        if (($("#date1").val().length != 10) || ($("#date2").val().length != 10)) {
            $("#dateTooShortError").show();
            return false;
        } else if ($("#date1").datepicker('getDate') > $("#date2").datepicker('getDate')) {
            $("#dateError").show();
            return false;
        } else {
            $("#dateTooShortError").hide();
            $("#dateError").hide();
            $("#dateError").hide();
            window.location = "<%= request.getParameter("windowLocation") %>" + "?startDate=" + $('#date1').val() + "&endDate=" + $('#date2').val();
        }
    }

    function exportButtonClicked() {
        if (($("#date1").val().length != 10) || ($("#date2").val().length != 10)) {
            $("#dateTooShortError").show();
        } else if ($("#date1").datepicker('getDate') > $("#date2").datepicker('getDate')) {
            $("#dateError").show();
        }
        else {
            $("#dateTooShortError").hide();
            $("#dateError").hide();
            window.location = 'service/ussdVisits/csvFormat' + '?' + 'startDate=' + $("#date1").val() + '&endDate=' + $("#date2").val();
        }
    }
    
    function convertParamDate(param) {
        if (param == null || param == '') {
            return null;
        } else {
            var date = $.datepicker.parseDate("dd/mm/yy", param);
            var strTime = date.getDate() + "/" + (date.getMonth()+1) + "/" + date.getFullYear();
            return strTime;
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
         <p>One or both of the dates are invalid. Format must be "dd/MM/yyyy".</p>
     </div>
</div>