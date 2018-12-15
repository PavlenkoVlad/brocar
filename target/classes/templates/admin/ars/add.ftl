<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Добавление нового СТО</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="ars-add-form">
                    <div class="form-group">
                        <label for="name">Название</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="phone1">Моб. тел. 1</label>
                        <input type="text" class="form-control" id="phone1" name="phone1" required maxlength="13">
                    </div>
                    <div class="form-group">
                        <label for="phone2">Моб. тел. 2</label>
                        <input type="text" class="form-control" id="phone2" name="phone2" maxlength="13">
                    </div>
                    <div class="form-group">
                        <label for="address">Адрес</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Почта</label>
                        <input type="text" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Описание</label>
                        <input type="text" class="form-control" id="description" name="description">
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Добавить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/ars">
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
            $("#ars-add-form").submit(function (event) {
                event.preventDefault();
                addAutoRepairShop();
            })
        });

        function addAutoRepairShop() {
            var name = $("#name").val();
            var phone1 = $("#phone1").val();
            var phone2 = $("#phone2").val();
            var address = $("#address").val();
            var email = $("#email").val();
            var description = $("#description").val();

            $.post("/admin/ars/add",
                    {name:name, phone1:phone1, phone2:phone2, address:address, email:email, description:description},
                    function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Уже существует СТО с похожими данными</p>")
                }
                else {
                    $(location).attr('href', '/admin/ars');
                }
            });
        }
    </script>
</@n.navbar>