function searchTeacher() {
    let teacherName = $("#searchValue").val();
    $.ajax({
        url: "http://localhost:8080/api/student/searchTeacherName",
        data: {
            nameTeacher: teacherName
        },
        type: "get",
        dataType: "json",
        success: function (response) {
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `
                    <tr>
                        <td>${response[i].subjectId}</td>
                        <td>${response[i].subjectName}</td>
                        <td>${response[i].teacher}</td>
                        <td>${response[i].note}</td>
                    </tr>
                `;

                // result += "<tr>"
                //     + "<td>"+ response[i].subjectId + "</td>"
            }
            $("#result").html(result);
            // $("#result").append(result);
        },
        error: function (e) {

        }
    });
}