<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Изменение данных о пользователе</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="user-edit-form">
                    <div class="form-group">
                        <label for="username">Имя пользователя</label>
                        <input type="hidden" id="bcuId" name="bcuId" value="${editUser.bcuId}">
                        <input readonly type="text" class="form-control" id="username" name="username" value="${editUser.username}" required>
                    </div>
                    <div class="form-group">
                        <label for="role">Статус пользователя</label>
                        <select class="form-control" id="role" name="role">
                            <option value="-1">Выберите статус пользователя</option>
                            <#if editUser.role == "ADMIN">
                                <option selected value="ADMIN">Администратор</option>
                            <#else>
                                <option value="ADMIN">Администратор</option>
                            </#if>

                            <#if editUser.role == "USER">
                                <option selected value="USER">Пользователь</option>
                            <#else>
                                <option value="USER">Пользователь</option>
                            </#if>
                        </select>
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Изменить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/user">
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
            $("#user-edit-form").submit(function (event) {
                event.preventDefault();
                editUser();
            })
        });

        function editUser() {
            var bcuId = $("#bcuId").val();
            var username = $("#username").val();
            var role = $("#role").val();
            $.post("/admin/user/edit", {bcuId:bcuId, username:username, role:role}, function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Необходимо выбрать статус пользователя</p>");
                }
                else {
                    $(location).attr('href', '/admin/user');
                }
            });
        }
    </script>
</@n.navbar>