<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Изменение данных об СТО</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="ars-edit-form">
                    <div class="form-group">
                        <label for="name">Название</label>
                        <input type="hidden" id="bcaId" name="bcaId" value="${autoRepairShop.bcaId}">
                        <input type="text" class="form-control" id="name" name="name" value="${autoRepairShop.name}" required>
                    </div>
                    <div class="form-group">
                        <label for="phone1">Моб. тел. 1</label>
                        <input type="text" class="form-control" id="phone1" name="phone1" value="${autoRepairShop.phone1}" required maxlength="13">
                    </div>
                    <#if autoRepairShop.phone2??>
                        <div class="form-group">
                            <label for="phone2">Моб. тел. 2</label>
                            <input type="text" class="form-control" id="phone2" name="phone2" value="${autoRepairShop.phone2}" maxlength="13">
                        </div>
                    <#else>
                        <div class="form-group">
                            <label for="phone2">Моб. тел. 2</label>
                            <input type="text" class="form-control" id="phone2" name="phone2" maxlength="13">
                        </div>
                    </#if>
                    <div class="form-group">
                        <label for="address">Адрес</label>
                        <input type="text" class="form-control" id="address" name="address" value="${autoRepairShop.address}" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Почта</label>
                        <input type="text" class="form-control" id="email" name="email" value="${autoRepairShop.email}" required>
                    </div>
                    <#if autoRepairShop.description??>
                        <div class="form-group">
                            <label for="description">Описание</label>
                            <input type="text" class="form-control" id="description" name="description" value="${autoRepairShop.description}">
                        </div>
                    <#else>
                        <div class="form-group">
                            <label for="description">Описание</label>
                            <input type="text" class="form-control" id="description" name="description">
                        </div>
                    </#if>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Изменить</button>
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
            $("#ars-edit-form").submit(function (event) {
                event.preventDefault();
                editAutoRepairShop();
            });
        });

        function editAutoRepairShop() {
            var bcaId = $("#bcaId").val();
            var name = $("#name").val();
            var phone1 = $("#phone1").val();
            var phone2 = $("#phone2").val();
            var address = $("#address").val();
            var email = $("#email").val();
            var description = $("#description").val();

            $.post("/admin/ars/edit",
                    {bcaId:bcaId, name:name, phone1:phone1, phone2:phone2, address:address, email:email, description:description},
                    function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Уже существует СТО с похожими данными</p>");
                }
                else {
                    $(location).attr('href', '/admin/ars');
                }
            });
        }
    </script>
</@n.navbar>