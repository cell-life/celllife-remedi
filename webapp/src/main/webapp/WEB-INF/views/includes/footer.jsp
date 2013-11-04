    <hr>

    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

<script>$.get
("totalvisits",{},
function(data) {
	var totals = data.totalVisits;
    $("#totals").html("Total Visits: " + totals);
	}
)
</script>