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
                <form id="provService-edit-form">
                    <div class="form-group">
                        <input type="hidden" id="bcaId" name="bcaId" value="${provService.bcpId.ars.bcaId}">
                        <input type="hidden" id="bcmdId" name="bcmdId" value="${provService.bcpId.modelCar.bcmdId}">
                        <input type="hidden" id="bcsId" name="bcsId" value="${provService.bcpId.service.bcsId}">
                        <label for="price">Цена</label>
                        <input type="text" class="form-control" id="price" name="price" value="${provService.price}" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Описание</label>
                        <#if provService.description??>
                            <input type="text" class="form-control" id="description" name="description" value="${provService.description}">
                        <#else>
                            <input type="text" class="form-control" id="description" name="description">
                        </#if>
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Изменить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/provService">
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
            $("#provService-edit-form").submit(function (event) {
                event.preventDefault();
                editProvService();
            })
        });

        function editProvService() {
            var bcaId = $("#bcaId").val();
            var bcmdId = $("#bcmdId").val();
            var bcsId = $("#bcsId").val();
            var price = $("#price").val();
            var description = $("#description").val();
            $.post("/admin/provService/edit",
                    {bcaId:bcaId, bcmdId:bcmdId, bcsId: bcsId, price:price, description:description}, function (data) {
                        if (data == -1) {
                            $("#error-message").empty();
                            $("#error-message").append("<p>Обязательно нужно выбрать СТО</p>");
                        }
                        else {
                            if (data == -2) {
                                $("#error-message").empty();
                                $("#error-message").append("<p>Обязательно нужно выбрать модель</p>");
                            }
                            else {
                                if (data == -3) {
                                    $("#error-message").empty();
                                    $("#error-message").append("<p>Обязательно нужно выбрать услугу</p>");
                                }
                                else {
                                    $(location).attr('href', '/admin/provService');
                                }
                            }
                        }
            });
        }
    </script>
</@n.navbar>