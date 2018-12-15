<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Изменение услуги</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="service-edit-form">
                    <div class="form-group">
                        <label for="name">Название</label>
                        <input type="hidden" id="bcsId" name="bcsId" value="${service.bcsId}">
                        <input type="text" class="form-control" id="name" name="name" value="${service.name}" required>
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Изменить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/service">
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
            $("#service-edit-form").submit(function (event) {
                event.preventDefault();
                editService();
            });
        });

        function editService() {
            var bcsId = $("#bcsId").val();
            var name = $("#name").val();
            $.post("/admin/service/edit", {bcsId:bcsId, name:name}, function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Такая услуга уже существует</p>");
                }
                else {
                    $(location).attr('href', '/admin/service');
                }
            });
        }
    </script>
</@n.navbar>