<#macro login2 path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
<label class="col-sm-2 col-form-label" > User Name : </label> 
<div class="col-sm-6">
<input type="text" name="username" class="form-control"/> </div>
</div>

    <div class="form-group row">
<label class="col-sm-2 col-form-label"> Password:</label>  
<div class="col-sm-6">
<input type="password" name="password" class="form-control"/> </div>
</div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
<#if !isRegisterForm><a href="/registration">Добавить нового участника</a></#if>   
    <button type="submit" class="btn btn-primary">Создать</button>
</div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Выйти</button>
</form>
</#macro>
