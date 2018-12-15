<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Изменение модели</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="modelCar-edit-form">
                    <div class="form-group">
                        <input type="hidden" id="bcmdId" name="bcmdId" value="${modelCar.bcmdId}">
                        <label for="bcmId">Название марки</label>
                        <select class="form-control" id="bcmId" name="bcmId">
                            <option value="-1">Выберите марку</option>
                            <#list markCars as markCar>
                                <#if modelCar.markCar == markCar>
                                    <option selected value="${markCar.bcmId}">${markCar.name}</option>
                                <#else>
                                    <option value="${markCar.bcmId}">${markCar.name}</option>
                                </#if>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="name">Название модель</label>
                        <input type="text" class="form-control" id="name" name="name" value="${modelCar.name}" required>
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Изменить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/modelCar">
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
            $("#modelCar-edit-form").submit(function (event) {
                event.preventDefault();
                editModelCar();
            })
        });

        function editModelCar() {
            var bcmdId = $("#bcmdId").val();
            var bcmId = $("#bcmId").val();
            var name = $("#name").val();
            $.post("/admin/modelCar/edit", {bcmdId:bcmdId, bcmId:bcmId, name:name}, function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Обязательно нужно выбрать марку</p>");
                }
                else {
                    $(location).attr('href', '/admin/modelCar');
                }
            });
        }
    </script>
</@n.navbar>