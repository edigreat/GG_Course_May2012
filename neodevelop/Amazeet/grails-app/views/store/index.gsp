<!doctype html>
<html>
  <head>
    <title>Store</title>
    <meta name="layout" content="earthlingtwo" />
    <r:require modules="jquery"/>
  </head>
  <body>

    <br/>
    <g:remoteLink action="addItemAsync" update="actualizame">
      Hola mundo con Ajax
    </g:remoteLink>
    <div id="actualizame">
    </div>
    <br/>
    
    <h2>Productos</h2>

    <table>
      <thead>
        <tr>
          <td><b>${message(code:'product.name.label',default:'Name')}</b></td>
          <td><b>${message(code:'product.price.label',default:'Price')}</b></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </thead>
      <tbody>
        <g:each in="${products}" var="p">
          <tr>
            <td>${p.name}</td>
            <td>$ ${p.price}</td>
            <td> 
              <store:showProduct url="${p.urlImage}" size="small"/> 
            </td>
            <td>
              <g:form action="addItem">
                <g:hiddenField name="productId" value="${p.id}"/>
                <g:select name="quantity" from="${1..9}" />
                <g:submitButton name="submit" value="Agregar" />
              </g:form>
            </td>
          </tr>
        </g:each>
      </tbody>
    </table>

    
  </body>
</html>