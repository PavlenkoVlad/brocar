<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Добавление нового расписания</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="timetable-add-form">
                    <div class="form-group">
                        <label for="bcaId">СТО</label>
                        <select class="form-control" id="bcaId" name="bcaId" required>
                            <option value="-1">Выберите СТО</option>
                            <#list autoRepairShops as ars>
                                <option value="${ars.bcaId}">${ars.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="monday">Понедельник</label>
                        <input type="text" class="form-control" id="monday" name="monday" required>
                    </div>
                    <div class="form-group">
                        <label for="tuesday">Вторник</label>
                        <input type="text" class="form-control" id="tuesday" name="tuesday" required>
                    </div>
                    <div class="form-group">
                        <label for="wednesday">Среда</label>
                        <input type="text" class="form-control" id="wednesday" name="wednesday" required>
                    </div>
                    <div class="form-group">
                        <label for="thursday">Четверг</label>
                        <input type="text" class="form-control" id="thursday" name="thursday" required>
                    </div>
                    <div class="form-group">
                        <label for="friday">Пятница</label>
                        <input type="text" class="form-control" id="friday" name="friday" required>
                    </div>
                    <div class="form-group">
                        <label for="saturday">Суббота</label>
                        <input type="text" class="form-control" id="saturday" name="saturday" required>
                    </div>
                    <div class="form-group">
                        <label for="sunday">Воскресенье</label>
                        <input type="text" class="form-control" id="sunday" name="sunday" required>
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Добавить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/timetable">
                            <button type="button" class="btn btn-default">Отменить</button>
                        </a>
                    </div>
                </form>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center; color: red">
                <div id="error-message">

                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $.ajaxSetup({async:false});
            $("#timetable-add-form").submit(function (event) {
                event.preventDefault();
                addTimetable();
            })
        });

        function addTimetable() {
            var bcaId = $("#bcaId").val();
            var monday = $("#monday").val();
            var tuesday = $("#tuesday").val();
            var wednesday = $("#wednesday").val();
            var thursday = $("#thursday").val();
            var friday = $("#friday").val();
            var saturday = $("#saturday").val();
            var sunday = $("#sunday").val();

            $.post("/admin/timetable/add",
                    {bcaId:bcaId, monday:monday, tuesday:tuesday, wednesday:wednesday, thursday:thursday, friday:friday,
                        saturday:saturday, sunday:sunday},
                    function (data) {
                        if(data == -1) {
                            $("#error-message").empty();
                            $("#error-message").append("<p>Для выбранного СТО уже существует расписание</p>")
                        }
                        else {
                            $(location).attr('href', '/admin/timetable');
                        }
                    });
        }
    </script>
</@n.navbar>