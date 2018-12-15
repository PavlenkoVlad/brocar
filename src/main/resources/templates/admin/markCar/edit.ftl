<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Изменение марки</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="markCar-edit-form">
                    <div class="form-group">
                        <label for="name">Название</label>
                        <input type="hidden" id="bcmId" name="bcmId" value="${markCar.bcmId}">
                        <input type="text" class="form-control" id="name" name="name" value="${markCar.name}" required>
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Изменить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/markCar">
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
            $("#markCar-edit-form").submit(function (event) {
                event.preventDefault();
                editMarkCar();
            })
        });

        function editMarkCar() {
            var bcmId = $("#bcmId").val();
            var name = $("#name").val();
            $.post("/admin/markCar/edit", {bcmId:bcmId, name:name}, function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Такая марка уже существует</p>");
                }
                else {
                    $(location).attr('href', '/admin/markCar');
                }
            });
        }
    </script>
</@n.navbar>