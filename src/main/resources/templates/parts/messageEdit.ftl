
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
Добавить сообщение</a>

<div class="collapse" id="collapseExample">
 <div class="form-group mt-3">
    <form method="post"action="/add" enctype="multipart/form-data">
<div class="form-group">
        <input type="text" name="text"placeholder="Введите сообщение"class="form-control"/>
</div>



<div class="form-group">

         <div class="custom-file">
        <input type="file" name="file" id="custom-file"/>
        <label class="custom-file-label" for="custom-file">Выбрать файл</label>
        </div>
</div>
        <input type="hidden"name="_csrf"value="${_csrf.token}"/>
         <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
<div class="form-group">

<button type="submit"class="btn btn-primary ">Добавить</button>

</div>
    </form>
    </div>
</div>